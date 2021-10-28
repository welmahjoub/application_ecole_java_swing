package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.DAOclass;
import DAO.DAOeleve;
import DAO.DAOmatier;
import DAO.DAOnote;
import MODEL.Classe;
import MODEL.Matiere;
import MODEL.Note;

public class Ecouteur_Bulltin implements ItemListener,ActionListener{
	


	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean TesterCombox()
	{
		if((this.cmb_class.getItemCount()!=0)  && (this.cmb_eleve.getItemCount()!=0))
		return true;
		else
			return false;
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_cmb_Eleve()
	{
		
		
	    int numclasse=getId_Classe_selectione();
		
		ListeNum=del.ListeDesNumElevesByClasse(numclasse);
	    ListeNomPrenom=del.ListeDesNomElevesByClasse(numclasse);
	    
	    if(this.cmb_eleve.getItemCount()>0)
	    	this.cmb_eleve.removeAllItems();
	    
	    for(int i=0;i<ListeNum.size();i++)
	    {
	    	this.cmb_eleve.addItem(ListeNum.get(i) +"-" +ListeNomPrenom.get(i));
	    }
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private int getId_Classe_selectione() 
	{
		
		Classe c=null;
		String nomclass="";
		if(this.cmb_class.getItemCount()>0)
		{
			nomclass=this.cmb_class.getSelectedItem().toString();
			c=dcl.getByNom(nomclass);
			if(c!=null){
				return c.getID();}
		}
		    return -1;
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_cmb_Classe()
	{

		if(this.cmb_class.getItemCount()>0)
			this.cmb_class.removeAllItems();
		
	    int niv=this.cmb_niveau.getSelectedIndex()+1;
		tab=dcl.ListeDesClasseByNiveau(niv);
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_class.addItem(c);
			}
		}
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Update_Table()
	{
		 ListMatiere=GetListeMatiere();
		
		double moye;
		int num,numClass,simestre;
		boolean hasnote=false;
		try {
			
		
			if(TesterCombox()==true && ClasseIsVide()==false)
			{
				num=getId_Eleve_Select();
				numClass=getId_class_select();
				simestre=getId_Simestre_Selec();
	
			    setModel_TableBulltin_ParDesfault();
			    
			     model = (DefaultTableModel) this.table_bultin.getModel();
			    
				for (int i=0;ListMatiere!=null && i<ListMatiere.size();i++) 
				{
					String col1=" ",col2 = " ",col3=" ",col4=" ",col5=" ",col6=" ",nomMat;
					int numMatier=0;
					Matiere m = null;
					nomMat=ListMatiere.get(i);
	                m=dmat.getByNom(nomMat);
	                if(m!=null)
	                	numMatier=m.getID();
					Note noteeleve =null;
					noteeleve=	dnot.GetNoteEleve(num, numClass, numMatier, simestre);
					col1=nomMat;
	
					if(noteeleve!=null)
					{
						
						col2=noteeleve.getORALE();
						col3=noteeleve.getDS1();
						col4=noteeleve.getDS2();
						moye=Calcul_Moyen_Matier(m,noteeleve);
						
						col5=String.valueOf(moye);
						col6=noteeleve.getOBSERVATION();
						hasnote=true;
					}	
					Object[] row = { col1, col2, col3, col4 ,col5,col6};
					 model.addRow(row);			
				}
				
				if(hasnote)
				{
					if(simestre==1 || simestre==2 )
					     Remplir_Champs_MoyeGeneral__Decision_Simestre_1_2();
					if(simestre==3)
						Remplir_Champs_MoyeGeneral__Decision_Simestre_3();
				}
					
			}
			else
				setModel_TableBulltin_ParDesfault();
		
		} catch (Exception e) 
		{System.out.println(" exception ");}
		
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean ClasseIsVide()
	{
		if(dcl.ClassContientDesEleves(getId_Classe_selectione()))
		return false;
		else
			return true;
	}
	
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void Remplir_Champs_MoyeGeneral__Decision_Simestre_3()throws Exception
	{
		  String col1=" ",col2 = " ",col3=" ",col4=" ",col5=" ",col6=" ";
		  DefaultTableModel model = (DefaultTableModel) this.table_bultin.getModel();
		  double Moye=0,Moy1=0,Moy2=0,Moy3=0,moyene=0;
		  
		  for (int i = 1; i <= 3; i++) 
		  {
			  Moye=CalculerMoyen_Simestre(i);
			  col4=" Moyene simestre" + i +" : ";
			  col5=String.valueOf(Moye);
			  col5=col5.substring(0, 4);
			  
			  Object[] row = { col1, col2, col3, col4 ,col5,col6};
				 model.addRow(row);	
				 
				 if(i==1)
					 Moy1=Moye;
				 if(i==2)
					 Moy2=Moye;
				 if(i==3)
					 Moy3=Moye;
			
		 }
     
		   moyene=Moy1+Moy2+Moy3;		
		   moyene/=3;
		   String moyenGeneral=String.valueOf(moyene);
		   moyenGeneral=moyenGeneral.substring(0, 4);
		   this.txt_moy_general.setText(moyenGeneral);
		   
		   if(moyene >=10.0)
			   this.txt_decision.setText(" Admis ");
		   else
			   this.txt_decision.setText(" Redoublent ");
		  
		 
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	double CalculerMoyen_Simestre(int simestre)throws Exception
	{

		
		int idniv=1;
		idniv=getId_niveau_Selec();
		ListMatiere=dmat.ListeDesMatiereByNiveau(idniv);
		Note noteelev=new Note();
		double somme=0;
		Matiere m;
		Double moyeneMtaier=0.0;
		int idMatier=0;
		int idElev=getId_Eleve_Select();
		int idclass=getId_class_select();

		 String NomMatiere;
		for (int i = 0; i < ListMatiere.size(); i++) {
			
			  NomMatiere=ListMatiere.get(i);
			 m=dmat.getByNom(NomMatiere);
			 if(m!=null)
				 idMatier=m.getID();
			 
			 noteelev=dnot.GetNoteEleve(idElev,idclass,idMatier, simestre);
			 if(noteelev!=null)
			  moyeneMtaier=Calcul_Moyen_Matier(m, noteelev);
			 
			 somme+=moyeneMtaier;
		}

		return somme/ListMatiere.size();
		
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_Champs_MoyeGeneral__Decision_Simestre_1_2()throws Exception
	{
		    model = (DefaultTableModel) this.table_bultin.getModel();
		   
		   String moye;
		   double moyene=0;
		   int nbMat=0;
		   for(int i=0;i<this.table_bultin.getRowCount();i++)
		   {
			   moye=model.getValueAt(i, 4).toString();
			   
			   if(NoteVide(moye)==false)
			   moyene+=Double.parseDouble(moye);
			   
			   nbMat++;
		   }
		
		   moyene/=nbMat;
		   String m=String.valueOf(moyene);
		   m=m.substring(0,4);
		   this.txt_moy_general.setText(m);
		   
		   if(moyene >=10.0)
			   this.txt_decision.setText(" Admis ");
		   else
			   this.txt_decision.setText(" Redoublent ");
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getId_Eleve_Select()
	{

		if(TesterCombox())
		{
			String item=this.cmb_eleve.getSelectedItem().toString();
			String num=item.substring(0, item.indexOf("-"));
			int numEleve=Integer.parseInt(num);
			
			return numEleve;
		}
		else
			return -1;
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getIdmatiere(String nomMat)
	{
		Matiere m=dmat.getByNom(nomMat);
		
		if(m!=null)
			return m.getID();
		else
			return -1;
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	int getId_niveau_Selec()
	{
		return this.cmb_niveau.getSelectedIndex()+1;
		
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getId_Simestre_Selec()
	{
		return this.cmb_simestre.getSelectedIndex()+1;
		
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	ArrayList<String> GetListeMatiere()
	{
		int idniv=getId_niveau_Selec();
		tab=dmat.ListeDesMatiereByNiveau(idniv);
		
		return tab;
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void setModel_TableBulltin_ParDesfault()
	{
		this.  table_bultin.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] { },
	            new String [] {"Matiere", "Note orale ", "Note Devoir1", "Note Devoir2", "Moyen :", "Observations"}));
		
		this.txt_decision.setText("");
		this.txt_moy_general.setText("");
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public int getId_class_select()
	{
		Classe c=null;
		String nomclass="";
		if(this.cmb_class.getItemCount()>0)
		{
			nomclass=this.cmb_class.getSelectedItem().toString();
			c=dcl.getByNom(nomclass);
			if(c!=null){
				return c.getID();}
		}
		    return -1;
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean NoteVide(String note)
	{
		
		if( note== null)
			return true;
		else if(note.equals("")==true)
			return true;
		else if(note.equals(" ")==true)
			return true;
		
			return false;
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public double Calcul_Moyen_Matier(Matiere m,Note n)throws Exception
	{
		double res=0,NoteOrale=0,NoteDs1=0,NoteDs2=0;
		
		if(n!=null && m!=null)
		{
			if(NoteVide(n.getDS1())==false)
			NoteDs1=Double.parseDouble(n.getDS1());
				
			if(NoteVide(n.getDS2())==false)
				NoteDs2=Double.parseDouble(n.getDS2());
				
				if(m.getHas_Note_Orale()==1)
				{
					if(NoteVide(n.getORALE())==false)
					NoteOrale=Double.parseDouble(n.getORALE());
					
				   	res= ( NoteOrale * 1) + ( NoteDs1 *  1 ) + ( NoteDs2 * 2) ;
				   	res=res/4;
			
				   	return res;
				}
				else
				{
					res=( NoteDs1 ) +  ( NoteDs2 * 2 );
				   	res=res/3;
				
				   	return res;
				}
		}
		else
			return 0;
		

	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==btn_imprimer)
		{

				if(hasnoteEleve())
				Imprimer_Bulltin.Imprimmer(getId_Eleve_Select(), getId_Simestre_Selec(), getId_niveau_Selec(), getId_Classe_selectione());
			
		}
	}

	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private boolean hasnoteEleve() {
		
		
		return true;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==this.cmb_niveau)
		{
			Remplir_cmb_Classe();
			Remplir_cmb_Eleve();
			
			
		}
		if(e.getSource()==this.cmb_class)
		{
			Remplir_cmb_Eleve();
		
		}
		
		Update_Table();
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

    private javax.swing.JButton btn_imprimer;
    private javax.swing.JComboBox<String> cmb_class;
    private javax.swing.JComboBox<String> cmb_eleve;
    private javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JComboBox<String> cmb_simestre;
    private javax.swing.JTable table_bultin;
    private javax.swing.JLabel txt_decision;
    private javax.swing.JLabel txt_moy_general;
    DAOmatier dmat;
    DAOclass dcl;
    DAOeleve del;
    DAOnote dnot;
    ArrayList<String> ListeNum;
	ArrayList<String> ListeNomPrenom;
	ArrayList<String> ListMatiere;
	ArrayList<String> tab;
	DefaultTableModel model;
	 /*===========ao=============================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/
    
	public Ecouteur_Bulltin(JButton btn_imprimer, JComboBox<String> cmb_class, JComboBox<String> cmb_eleve,
			JComboBox<String> cmb_niveau, JComboBox<String> cmb_simestre, JTable table_bultin, JLabel txt_decision,
			JLabel txt_moy_general) {
		super();
		this.btn_imprimer = btn_imprimer;
		this.cmb_class = cmb_class;
		this.cmb_eleve = cmb_eleve;
		this.cmb_niveau = cmb_niveau;
		this.cmb_simestre = cmb_simestre;
		this.table_bultin = table_bultin;
		this.txt_decision = txt_decision;
		this.txt_moy_general = txt_moy_general;
		dmat=new DAOmatier();
		dcl=new DAOclass();
		del=new DAOeleve();
		dnot=new DAOnote();
	}
    
	
	 /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/   

}
