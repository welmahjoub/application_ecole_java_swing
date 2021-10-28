package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import DAO.DAOabsence;
import DAO.DAOclass;
import DAO.DAOeleve;
import DAO.DAOniveau;
import MODEL.Absence;
import MODEL.Classe;


public class Ecouteur_Absence extends Ecouteur implements ActionListener,ItemListener,PropertyChangeListener,KeyListener{

	

	
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Ajouter() 
	{
	   int classe=getId_Classe_selectione();
	   String dat=getDate_Select();
	
		if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selectionnez la date   et/ou Calsse ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
	   	 }	 
		  else if(TesterAbsenceBiensaisi()==false)
		   	 {
		   		 JOptionPane.showMessageDialog(null, " Veuillez Saisir Des Informations Correct  ", " Error", JOptionPane.WARNING_MESSAGE); 
		   	 }
	     else  
	     {
                Boolean  test2=new DAOabsence().Absence_class_DejaSaisir(classe, dat);

		    	if(test2==false)
				{
					if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette Liste d absence    ? ")==0)
					{
						AjouterTousLesAbsences();
						 UpdateTable();
						 clear();
					}
				}
				else
				{
					 JOptionPane.showMessageDialog(null, " Absence daja saisir Dans cette date  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 

				}
	     }  
		
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void AjouterTousLesAbsences()
	{
		String  num;
		int Numelev;
		String dat=getDate_Select();
		int numClass=getId_Classe_selectione();
		DAOabsence dao=new DAOabsence();
		
		DefaultTableModel model = (DefaultTableModel) this.table_absenceClass.getModel();
		 
		Absence A1 = null,A2= null,A3= null,A4= null,A5= null;	
		String v1=" ",v2,v3,v4,v5;
		
		for(int i=0;i<model.getRowCount();i++)
		{
			num=model.getValueAt(i, 0).toString();
			Numelev=Integer.parseInt(num);
			
			v1=model.getValueAt(i, 2).toString();
			v2=model.getValueAt(i, 3).toString();
			v3=model.getValueAt(i, 4).toString();
			v4=model.getValueAt(i, 5).toString();
			v5=model.getValueAt(i, 6).toString();
			
			A1=cretate(Numelev, numClass, dat, v1, 1);
			A2=cretate(Numelev, numClass, dat, v2, 2);
			A3=cretate(Numelev, numClass, dat, v3, 3);
			A4=cretate(Numelev, numClass, dat, v4, 4);
			A5=cretate(Numelev, numClass, dat, v5, 5);	
			
			dao.Ajouter(A1);
			dao.Ajouter(A2);
			dao.Ajouter(A3);
			dao.Ajouter(A4);
			dao.Ajouter(A5);
		}
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	Absence cretate(int num,int classe,String date,String valeur,int horaire)
	{
		Absence s=new Absence();
		
		s.setCLASSE(classe);
		s.setHORAIRE(horaire);
		s.setDATE(date);
		s.setNUM(num);
		s.setVALEUR(valeur);
		
		return s;
	}
	
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Modifier()
	{
	
		if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selectionnez la date   et/ou Calsse ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
	   	 }	 
	     else if(TesterAbsenceBiensaisi()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez Saisir Des Informations Correct  ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	     else  
	     {
            
	    	  int classe=getId_Classe_selectione();
			   String dat=getDate_Select();
			Boolean  test2=new DAOabsence().Absence_class_DejaSaisir(classe, dat);

		    	if(test2==true)
				{
					if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifer   cette Liste d absence   ? ")==0)
					{
						 ModifierAbsence();
						 UpdateTable();
						 clear();
					}
				}
				else
				{
					 JOptionPane.showMessageDialog(null, " Absence n existe pas veuillez Ajouter D abord   ", " Erreur ", JOptionPane.WARNING_MESSAGE); 

				}
	     }  
	}
  
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void ModifierAbsence() {
		
		String  num;
		int Numelev;
		String dat=getDate_Select();
		int numClass=getId_Classe_selectione();
		DAOabsence dao=new DAOabsence();
		
		DefaultTableModel model = (DefaultTableModel) this.table_absenceClass.getModel();
		 
		
		
		
		for(int i=0;i<model.getRowCount();i++)
		{
			Absence A1 = null,A2= null,A3= null,A4= null,A5= null;	
			String v1=" ",v2,v3,v4,v5;
			int id1=0,id2=0,id3=0,id4=0,id5=0;
			
			num=model.getValueAt(i, 0).toString();
			Numelev=Integer.parseInt(num);
			
			v1=model.getValueAt(i, 2).toString();
			v2=model.getValueAt(i, 3).toString();
			v3=model.getValueAt(i, 4).toString();
			v4=model.getValueAt(i, 5).toString();
			v5=model.getValueAt(i, 6).toString();
			
			A1=cretate(Numelev, numClass, dat, v1, 1);
			A2=cretate(Numelev, numClass, dat, v2, 2);
			A3=cretate(Numelev, numClass, dat, v3, 3);
			A4=cretate(Numelev, numClass, dat, v4, 4);
			A5=cretate(Numelev, numClass, dat, v5, 5);	
			
			id1=dao.getidAbsence(A1);
			id2=dao.getidAbsence(A2);
			id3=dao.getidAbsence(A3);
			id4=dao.getidAbsence(A4);
			id5=dao.getidAbsence(A5);
		
			A1.setID(id1);
			A2.setID(id2);
			A3.setID(id3);
			A4.setID(id4);
			A5.setID(id5);
			
			dao.Modifier(A1);
			dao.Modifier(A2);
			dao.Modifier(A3);
			dao.Modifier(A4);
			dao.Modifier(A5);
			
		}
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Supprimer() {
	
		if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selectionnez la date   et/ou Calsse ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
	   	 }	 
	     else if(TesterAbsenceBiensaisi()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez Saisir Des Informations Correct  ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	     else  
	     {
           
	    	  int classe=getId_Classe_selectione();
			   String dat=getDate_Select();
			Boolean  test2=new DAOabsence().Absence_class_DejaSaisir(classe, dat);

		    	if(test2==true)
				{
					if(JOptionPane.showConfirmDialog(null, " Voulez vous Supprimer   cette Liste d absence  ? ")==0)
					{
						 new DAOabsence().SupprimerListeAbsence(dat);
						 UpdateTable();
						 clear();
					}
				}
				else
				{
					 JOptionPane.showMessageDialog(null, " Absence n existe pas veuillez Ajouter D abord   ", " Erreur ", JOptionPane.WARNING_MESSAGE); 

				}
	     }
	}
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Consulter() {
		
		
	}
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void UpdateTable() {
		
		ArrayList<String> ListeNum,ListeNomPrenom;
        String date=getDate_Select();
        DAOabsence dao=new DAOabsence();
        int numElev;
        ArrayList<Absence> listeAbsence;
        
		if(Tester_formlaire()==true)
		{
		    int numClass=getId_Classe_selectione();

			ListeNum=getListe_Num_Eleves();
			ListeNomPrenom=getListe_NomPrenom_Eleves();
			
		    setModel_TableAbsenceClass_ParDesfault();
		    DefaultTableModel model = (DefaultTableModel) this.table_absenceClass.getModel();
		    
			for (int i=0;i<ListeNomPrenom.size();i++) 
			{
				String col1,col2,col3=" ",col4=" ",col5=" ",col6=" ",col7=" ";
				col1=ListeNum.get(i);
				col2=ListeNomPrenom.get(i);
				numElev=Integer.parseInt(col1);
				boolean test=dao.Absence_class_DejaSaisir(numClass, date);
				
				if(test==true)
				{
					 listeAbsence=dao.getAll(numElev, numClass, date);
					 
					 col3=listeAbsence.get(0).getVALEUR();
					 col4=listeAbsence.get(1).getVALEUR();
					 col5=listeAbsence.get(2).getVALEUR();
					 col6=listeAbsence.get(3).getVALEUR();
					 col7=listeAbsence.get(4).getVALEUR();
				}

				Object[] row = { col1, col2, col3, col4 ,col5,col6,col7};
				 model.addRow(row);			
			}
		}
		else
			setModel_TableAbsenceClass_ParDesfault();
		
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public void InitialiseDate()
	{

		java.util.Date date = new java.util.Date(); 

		this.txt_date.setDate(date);
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
    private String getDate_Select() {
		
    	
    	if(Tester_formlaire())
    	{
    		String d=((JTextField)this.txt_date.getDateEditor()).getText();
    		return d;
    	}
		return null;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
	private ArrayList<String> getListe_NomPrenom_Eleves() {
		
    	DAOeleve de=new DAOeleve();
		ArrayList<String> ListeNomPrenom;
	    int numclasse=getId_Classe_selectione();
	    ListeNomPrenom=de.ListeDesNomElevesByClasse(numclasse);
	    
		return ListeNomPrenom;
	}
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	private ArrayList<String> getListe_Num_Eleves() {
	
		DAOeleve de=new DAOeleve();
		ArrayList<String> ListeNum;
	    int numclasse=getId_Classe_selectione();
		ListeNum=de.ListeDesNumElevesByClasse(numclasse);
		
		return ListeNum;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	private int getId_Classe_selectione() {
		
		Classe c=null;
		String nomclass="";
		if(this.cmb_class.getItemCount()>0)
		{
			nomclass=this.cmb_class.getSelectedItem().toString();
			c=new DAOclass().getByNom(nomclass);
			if(c!=null){
				return c.getID();}
		}
		    return -1;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void setModel_TableAbsenceClass_ParDesfault() {
		
		this. table_absenceClass.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {    },
		            new String [] { "NUM", "Nom Prenom", "8h - 10h", "10 h -  12h", "12 h -  13h", "14 h -  16h", "16 h -  18h" }));
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void clear() {
		
		
	}
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public boolean Tester_formlaire() {
		
		if(this.txt_date.getDate()==null || this.cmb_class.getItemCount()==0)
		return false;
		
		return true;
	}
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	  private boolean TesterAbsenceBiensaisi()
	  {
		
			DefaultTableModel model = (DefaultTableModel) this.table_absenceClass.getModel();
			
			
			for(int i=0;i<model.getRowCount();i++)
			{
				String v1,v2,v3,v4,v5;

				v1=model.getValueAt(i, 2).toString();
				v2=model.getValueAt(i, 3).toString();
				v3=model.getValueAt(i, 4).toString();
				v4=model.getValueAt(i, 5).toString();
				v5=model.getValueAt(i, 6).toString();
				
			    if(TesterCase(v1) == false)
			    	return false;
			    if(TesterCase(v2) == false)
			    	return false;
			    if(TesterCase(v3) == false)
			    	return false;
			    if(TesterCase(v4) == false)
			    	return false;
			    if(TesterCase(v5) == false)
			    	return false;
			    
			}
			
			return true;
		}
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	  
	 boolean TesterCase(String valeur)
	 {
		 if(valeur == null)
			 return true;
		 
		 if(valeur.equals(" "))
			 return true;
		 if(valeur.equals(""))
			 return true;
		 
		 String cas=valeur.toLowerCase();
		 
		 if((cas.equals("a")) ||  (cas.equals("p")))
			 return true;
		
		 if((cas.equals(" a")) ||  (cas.equals(" p")))
			 return true;
		 
		 if((cas.equals("  a")) ||  (cas.equals("  p")))
			 return true;
		 
		 return false;
	 }
	  
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Recherche() {
		
		String num,dat,horair;
       ArrayList<String> tab;
       setModel_TableAbsenceElevE_ParDesfault();
       
       DefaultTableModel model = (DefaultTableModel) this.table__absenceEleve.getModel();
       
		if(this.txt_recherche.getText().equals("")==false)
		{
			num=this.txt_recherche.getText();

			if(num.matches("[0-9]*")==true)
			 {
				  int numero=Integer.parseInt(num);
				  tab=new DAOabsence().ListeDesAbsence_ByEleve(numero);
				  
				  for (String line : tab) 
				  {					
					  dat=line.substring(0, line.indexOf("/"));
					  horair=line.substring(line.indexOf("/")+1,line.length());
					  
					  Object[] row = { dat,horair};
					  model.addRow(row);						  
				  }
				 
			
			 }else
				 setModel_TableAbsenceElevE_ParDesfault();
		}
		else
			 setModel_TableAbsenceElevE_ParDesfault();
		
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    private void setModel_TableAbsenceElevE_ParDesfault() {
		
    	   this.table__absenceEleve.setModel(new javax.swing.table.DefaultTableModel(
    	            new Object [][] {},
    	            new String [] {"Date  D'absence", "Horaire" } ));
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public void Remplir_cmb_Niveau()
	{
		DAOniveau d=new  DAOniveau();
		ArrayList<String> tab;
		
		if(this.cmb_niveau.getItemCount()>0)
			this.cmb_niveau.removeAllItems();

		tab=d.ListeDesNiveau();
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_niveau.addItem(c);
			}
		}
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_cmb_Classe()
	{
		DAOclass d=new DAOclass();
		ArrayList<String> tab;
		
		if(this.cmb_class.getItemCount()>0)
			this.cmb_class.removeAllItems();
		
	    int niv=this.cmb_niveau.getSelectedIndex()+1;
		tab=d.ListeDesClasseByNiveau(niv);
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
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==this.cmb_class)
		{
			UpdateTable();
		}
		if(e.getSource()==this.cmb_niveau)
		{
			Remplir_cmb_Classe();
			UpdateTable();
		}
		
		
		
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this.btn_ajout)
		{
			Ajouter();
		}
		if(e.getSource()==this.btn_modifer)
		{
			Modifier();
		}
		if(e.getSource()==this.btn_supprimer)
		{
			Supprimer();
		}
		if(e.getSource()==this.btn_imprimer)
		{
			int idclass=0,idniv=0;
			String nomclass="",dat;
			dat=getDate_Select();
			idclass=getId_Classe_selectione();
			Classe c =new DAOclass().getById(idclass);
			nomclass=c.getNOM();
			idniv=c.getNIVEAU();
			
			Imprimer_Absence.Imprimer(nomclass, idclass, idniv,dat);
		}
		
	}

	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		
		if(e.getSource()==this.txt_date)
		{
			UpdateTable();
		}
	}
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		Recherche();
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyReleased(KeyEvent arg0) {

		Recherche();
	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public boolean All_champs_is_empty() {		return false;}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	    private  javax.swing.JButton btn_ajout;
	   
		private javax.swing.JButton btn_imprimer;
	    public javax.swing.JButton btn_modifer;
	    private javax.swing.JButton btn_supprimer;
	    private  javax.swing.JComboBox<String> cmb_class;
	    private  javax.swing.JComboBox<String> cmb_niveau;
	    private javax.swing.JTable table__absenceEleve;
	    private javax.swing.JTable table_absenceClass;
	    private com.toedter.calendar.JDateChooser txt_date;
	    private javax.swing.JTextField txt_recherche;
	    
	    /*========================================================================================================================*/
	   	/*========================================= 2) fonction  ================================================*/
	   	/*========================================================================================================================*/ 
	    
		public Ecouteur_Absence(JButton btn_ajout, JButton btn_imprimer, JButton btn_modifer, JButton btn_supprimer,
				JComboBox<String> cmb_class, JComboBox<String> cmb_niveau, JTable table__absenceEleve,
				JTable table_absenceClass, JDateChooser txt_date, JTextField txt_recherche) {
			super();
			this.btn_ajout = btn_ajout;
			this.btn_imprimer = btn_imprimer;
			this.btn_modifer = btn_modifer;
			this.btn_supprimer = btn_supprimer;
			this.cmb_class = cmb_class;
			this.cmb_niveau = cmb_niveau;
			this.table__absenceEleve = table__absenceEleve;
			this.table_absenceClass = table_absenceClass;
			this.txt_date = txt_date;
			this.txt_recherche = txt_recherche;
		}
	    
		 /*========================================================================================================================*/
	   	/*========================================= 2) fonction  ================================================*/
	   	/*========================================================================================================================*/ 
}
