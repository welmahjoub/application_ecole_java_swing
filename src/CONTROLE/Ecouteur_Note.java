package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAOclass;
import DAO.DAOeleve;
import DAO.DAOmatier;
import DAO.DAOniveau;
import DAO.DAOnote;
import MODEL.Classe;
import MODEL.Matiere;
import MODEL.Note;

public class Ecouteur_Note extends Ecouteur implements  ActionListener,ItemListener{
	
	
	public ResultSet rs;
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
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
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	public void RemplirCmbClasse()
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
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	public void RemplirCmbMatiere()
	{
		
	        DAOmatier d=new DAOmatier();
			ArrayList<String> tab=null;

			if(this.cmb_matier.getItemCount()>0)
				this.cmb_matier.removeAllItems();
			
			int niv=this.cmb_niveau.getSelectedIndex()+1;
			tab	=d.ListeDesMatiereByNiveau(niv);

			if(tab!=null)
			{
				for (String c : tab)
				{
					this.cmb_matier.addItem(c);
				}
			}	
	}
	
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btn_enregistrer)
		{
			int numMat =getId_Matiere_selectione();
			Matiere matierselect=new DAOmatier().getById(numMat);
			
			if(matierselect.getHas_Note_Orale()==1)
				Enregistrer_Notes_Matiere_Has_NoteOral();	
			else
				Enregistrer_Notes_Matiere_dontHave_NoteOral();
		}
		
			
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Enregistrer_Notes_Matiere_Has_NoteOral()
	{
		int idsimestre=0,idclass=0,idmatiere=0;
    	idsimestre=getId_SimestreSeelectioner();
    	idclass=getId_Classe_selectione();
    	idmatiere=getId_Matiere_selectione();
    	boolean TestNoteDejaSaisi,TestLesNotesCorrect;
	    
	 
    		TestLesNotesCorrect=Tester_LesNotesSaisi_Correct_Matiere_Has_NoteOrale();
    		
    		if(TestLesNotesCorrect)
    		{
    			 TestNoteDejaSaisi=new DAOnote().Note_class_DejaSaisir(idclass, idmatiere, idsimestre);
    			 
        		 if(TestNoteDejaSaisi==true)
        			Modifier();
        		 else
        			Ajouter();
    		}
    		else 
       		 JOptionPane.showMessageDialog(null," Veuillez Saisir des Note Correct  ", " Erreur ", JOptionPane.WARNING_MESSAGE);	
    
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Enregistrer_Notes_Matiere_dontHave_NoteOral()
	{
		int idsimestre=0,idclass=0,idmatiere=0;
    	idsimestre=getId_SimestreSeelectioner();
    	idclass=getId_Classe_selectione();
    	idmatiere=getId_Matiere_selectione();
    	boolean TestNoteDejaSaisi,TestLesNotesCorrect;
	    

    		TestLesNotesCorrect=Tester_LesNotesSaisi_Correct_Matiere_DontHave_NoteOrale();
    		
    		if(TestLesNotesCorrect)
    		{
    			 TestNoteDejaSaisi=new DAOnote().Note_class_DejaSaisir(idclass, idmatiere, idsimestre);
    			 
        		 if(TestNoteDejaSaisi==true)
        			Modifier();
        		 else
        			Ajouter();
    		}
    		else 
       		 JOptionPane.showMessageDialog(null," Veuillez Saisir des Note Correct  ", " Erreur ", JOptionPane.WARNING_MESSAGE);	
    	
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Ajouter()
	{
		String num,orale,ds1,ds2,obs;
		int numeelev;	
	    DAOnote d=new DAOnote();
		Note not=new Note();
		
		not.setCLASS(getId_Classe_selectione());
		not.setMATIERE(getId_Matiere_selectione());
		not.setSIMESTRE(getId_SimestreSeelectioner());
		
		DefaultTableModel model = (DefaultTableModel) this.table_note.getModel();
		 
		for(int i=0;i<model.getRowCount();i++)
		{
			num=model.getValueAt(i, 0).toString();
			numeelev=Integer.parseInt(num);
			orale=model.getValueAt(i, 2).toString();
			ds1=model.getValueAt(i, 3).toString();
			ds2=model.getValueAt(i, 4).toString();
			obs=model.getValueAt(i, 5).toString();
			not.setNUM(numeelev);
			not.setORALE(orale);
			not.setDS1(ds1);
			not.setDS2(ds2);
			not.setOBSERVATION(obs);
			
			d.Ajouter(not);
		}
		
		JOptionPane.showMessageDialog(null, "  Les Notes Ont etaient Bien Enregistrer  ", " Bravo ", JOptionPane.INFORMATION_MESSAGE); 
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void Modifier() {
		
		String num="",ds1,ds2,orale,obs;
		int numeroeleve=0;	
	    DAOnote d=new DAOnote();
		Note notelev=new Note();
	
		 int numClass=getId_Classe_selectione();
	     int numMatier=getId_Matiere_selectione();
	     int simestre=getId_SimestreSeelectioner();
	     
	     DefaultTableModel model;
		 model = (DefaultTableModel) this.table_note.getModel();
		
			 for(int i=0;i<model.getRowCount();i++)
				{
					num=model.getValueAt(i, 0).toString();
					numeroeleve=Integer.parseInt(num);
					orale=model.getValueAt(i, 2).toString();
					ds1=model.getValueAt(i, 3).toString();
					ds2=model.getValueAt(i, 4).toString();
				    obs=model.getValueAt(i, 5).toString();
				    notelev=d.GetNoteEleve(numeroeleve, numClass, numMatier, simestre);	
			
					if(notelev!=null)
					{
						notelev.setDS2(ds2);
						notelev.setDS1(ds1);
						notelev.setORALE(orale);
						notelev.setOBSERVATION(obs);
						d.Modifier(notelev);
					}
				}
			 
		JOptionPane.showMessageDialog(null, "  Les Notes Ont etaient  Modifier   ", " Bravo ", JOptionPane.INFORMATION_MESSAGE); 
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void UpdateTable() 
	{
		ArrayList<String> ListeNum,ListeNomPrenom;
        DAOnote d=new DAOnote(); 

		if(Tester_formlaire()==true)
		{
		    int numClass=getId_Classe_selectione();
		    int numMatier=getId_Matiere_selectione();
		    int simestre=getId_SimestreSeelectioner();
			
			ListeNum=getListe_Num_Eleves();
			ListeNomPrenom=getListe_NomPrenom_Eleves();
		    setModel_TableNote_ParDesfault();
		    DefaultTableModel model = (DefaultTableModel) this.table_note.getModel();
		    
			for (int i=0;i<ListeNomPrenom.size();i++) 
			{
				String col1,col2,col3=" ",col4=" ",col5=" ",col6=" ";
				
				col1=ListeNum.get(i);
				col2=ListeNomPrenom.get(i);
				int num=Integer.parseInt(col1);
				Note noteeleve=null;
				noteeleve=d.GetNoteEleve(num, numClass, numMatier, simestre);
				
				if(noteeleve!=null)
				{
					col3=noteeleve.getORALE();
					col4=noteeleve.getDS1();
					col5=noteeleve.getDS2();
					col6=noteeleve.getOBSERVATION();
				}	
				
				Object[] row = { col1, col2, col3, col4 ,col5,col6};
				 model.addRow(row);			
			}
		}
		else
			setModel_TableNote_ParDesfault();
		
	}
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	boolean Tester_LesNotesSaisi_Correct_Matiere_Has_NoteOrale()
	{
		 DefaultTableModel model = (DefaultTableModel) this.table_note.getModel();
		 
			 for(int i=0;i<model.getRowCount();i++)
				{
					 String noteOrale=model.getValueAt(i, 2).toString();
					 String noteDs1=model.getValueAt(i, 3).toString();
					 String noteDs2=model.getValueAt(i, 4).toString();
					 
					 if(NoteCorrect(noteOrale)==false)
						 return false;
					 if(NoteCorrect(noteDs1)==false)
						 return false;
					 if(NoteCorrect(noteDs2)==false )
						 return false; 
				}
			 
			 return true; 
	}
	
	
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	boolean Tester_LesNotesSaisi_Correct_Matiere_DontHave_NoteOrale()
	{
		 DefaultTableModel model = (DefaultTableModel) this.table_note.getModel();

			 for(int i=0;i<this.table_note.getRowCount();i++)
				{
				    String noteDs1=null,noteDs2=null,oral=null;	
				    oral=model.getValueAt(i, 2).toString();
					noteDs1=model.getValueAt(i, 3).toString();
					noteDs2=model.getValueAt(i, 4).toString();

					 if(NoteCorrect(oral) ==false)
						 return false;
					 if(NoteCorrect(noteDs1) ==false)
						 return false;
					 if(NoteCorrect(noteDs2) ==false)
						 return false; 		 
				}		 
				return true;
	}
	
	
	
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean NoteCorrect(String note)
	{
	
		if(NoteVide(note)==false)
		{
			if(note.matches("[0-9 ]*"))
			{
				double not=Double.parseDouble(note);
				if(not<0 || not >20)
					return false;
				else
					return true;
			}
			else
			return false;
		}
		else
		return true;
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
	
	void setModel_TableNote_ParDesfault()
	{
		this. table_note.setModel(new javax.swing.table.DefaultTableModel(new Object [][] { },
	            new String [] {" Numero  "," Nom Prenom ", " Note Orale  ", " Note Devoir1 " ," Note Devoir2 " ," Observations "}));
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public int getId_Matiere_selectione()
	{
   
    	String nommatiere="";
    	Matiere m=null;

    	if(this.cmb_matier.getItemCount()>0)
    	{
    		 nommatiere=this.cmb_matier.getSelectedItem().toString();
   	         m=new DAOmatier().getByNom(nommatiere);
   	
	   	     if(m!=null){ 
	   	    	 return m.getID(); }
    	}
    	     return -1;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public int getId_Classe_selectione()
	{
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
	
	public int getId_SimestreSeelectioner()
	{
		return this.cmb_simestre.getSelectedIndex()+1;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public ArrayList<String> getListe_Num_Eleves()
	{
		DAOeleve de=new DAOeleve();
		ArrayList<String> ListeNum;
	    int numclasse=getId_Classe_selectione();
		ListeNum=de.ListeDesNumElevesByClasse(numclasse);
		
		return ListeNum;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public ArrayList<String> getListe_NomPrenom_Eleves()
	{
		DAOeleve de=new DAOeleve();
		ArrayList<String> ListeNomPrenom;
	    int numclasse=getId_Classe_selectione();
	    ListeNomPrenom=de.ListeDesNomElevesByClasse(numclasse);
	    
		return ListeNomPrenom;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public boolean Tester_formlaire() {
		
		if(this.cmb_class.getItemCount()>0 && this.cmb_matier.getItemCount()>0)
			return true;
		
		return false;
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void UpdateTitreMatiere()
	{
		if(this.cmb_matier.getItemCount()>0)
		this.label_Titre_matiere.setText(" Matiere : "+this.cmb_matier.getSelectedItem().toString());
		else
			this.label_Titre_matiere.setText("");
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==this.cmb_niveau)
		{
			RemplirCmbClasse();
			RemplirCmbMatiere();
			
			UpdateTable();
			UpdateTitreMatiere();
		}
		else
		{
			UpdateTable();
			UpdateTitreMatiere();
		}
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public boolean All_champs_is_empty() {return false;}
	@Override
	public void clear() {}
	@Override
	public void Recherche() {}
	@Override
	public void Supprimer() {}
	@Override
	public void Consulter() {}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	//private javax.swing.JButton btnImprime;
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JComboBox<String> cmb_class;
    private javax.swing.JComboBox<String> cmb_matier;
    private javax.swing.JComboBox<String> cmb_niveau;
    private  javax.swing.JComboBox<String> cmb_simestre;
    private javax.swing.JLabel label_Titre_matiere;
    private javax.swing.JTable table_note;


	public Ecouteur_Note(JButton btn_enregistrer, JComboBox<String> cmb_class, JComboBox<String> cmb_matier,
			JComboBox<String> cmb_niveau, JComboBox<String> cmb_simestre, JLabel label_Titre_matiere,
			JTable table_note) {
		super();
		this.btn_enregistrer = btn_enregistrer;
		this.cmb_class = cmb_class;
		this.cmb_matier = cmb_matier;
		this.cmb_niveau = cmb_niveau;
		this.cmb_simestre = cmb_simestre;
		this.label_Titre_matiere = label_Titre_matiere;
		this.table_note = table_note;
	}
    
    
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

}
