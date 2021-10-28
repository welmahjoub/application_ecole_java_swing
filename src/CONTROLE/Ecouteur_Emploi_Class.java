package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.DAOclass;
import DAO.DAOinstituteur;
import DAO.DAOmatier;
import DAO.DAOniveau;
import DAO.DAOsalle;
import DAO.DAOseance;
import MODEL.Classe;
import MODEL.Instituteur;
import MODEL.Matiere;
import MODEL.Salle;
import MODEL.Seance;

public class Ecouteur_Emploi_Class extends Ecouteur implements  ActionListener,MouseListener,ItemListener{
	
	
	public static int  Id_Seance_Select=0;
	DAOseance dao;

	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		
		if(arg.getSource()==this.btn_ajout)
		{
			Ajouter();
		}
		if(arg.getSource()==this.btn_modifier)
		{
			Modifier();
		}
		if(arg.getSource()==this.btn_suprimer)
		{
			Supprimer();
		}
		if(arg.getSource()==this.btn_impr)
		{
			int idclass=getId_Classe_select();
			 int idniv=cmb_niveau.getSelectedIndex()+1;
		  String nomclass=getNom_Class(idclass);
			
			Imprimer_Emploi_class.Imprimer(nomclass, idclass, idniv);
		}
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Ajouter() 
	{
			 
	      if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selection  les Information du senace ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	     else  
	     {
	    	   Seance s = Create();
	    	   boolean test=SeanceExiste(s);
	    	  
		    	if(test==false )
				{
		    	   if(TesterChauvechment())
		    	   {
						if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette Seance    ? ")==0)
						{
	                        dao.Ajouter(s);
							 UpdateTable();
							 clear();
							 SetId_Seance_Seelect_A_zeero();
						}
		    	   }
				}
				else
				{
					 JOptionPane.showMessageDialog(null, " Seance  existe  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 

		     	}
	     }	
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void Modifier() 
	{
		
		if(Id_Seance_Select==0)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selection Une seance ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
		else  if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selection  les Information du senace ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	     else  
	     {
	    	   Seance nouvelsSeance = Create();
	    	   boolean test=SeanceExiste(nouvelsSeance);
	    	   nouvelsSeance.setID(Id_Seance_Select);
	    	   
		    	if(test==false)
				{
					if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifier   cette Seance    ? ")==0)
					{
                         dao.Modifier(nouvelsSeance);
						 UpdateTable();
						 clear();
						 SetId_Seance_Seelect_A_zeero();
					}
				}
				else
				{
					 JOptionPane.showMessageDialog(null, " Seance  existe  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 

				}
	     }	
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	

	@Override
	public void Supprimer() 
	{
		if(Id_Seance_Select==0)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selection Une seance ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
		else  if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez selection  les Information du senace ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	     else  
	     {
			  if(JOptionPane.showConfirmDialog(null, " Voulez vous supprimer    cette Seance    ? ")==0)
			  {
                     dao.Supprimer(Id_Seance_Select);
					 UpdateTable();
					 clear();
					 SetId_Seance_Seelect_A_zeero();
			 }
	     }	
		
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean TesterChauvechment()
	{
		
		Seance test1= new DAOseance().getSeanceInstituteur(getId_Instituteur_select(), getId_Horaire_select(), getId_Jour_select());
		Seance test2= new DAOseance().getSeanceSalle(getId_Salle_select(), getId_Horaire_select(), getId_Jour_select());
		Seance test3= new DAOseance().getSeanceClasse(getId_Classe_select(), getId_Horaire_select(), getId_Jour_select());
		
		if(test1!=null)
		{
			 JOptionPane.showMessageDialog(null, "Chauvechment Institutteur Enseigne Une Autre classe ", " Error", JOptionPane.WARNING_MESSAGE);
			 return false;
		}
		if(test2!=null)
		{
			 JOptionPane.showMessageDialog(null, "Chauvechment Salle n est pas disponible ", " Error", JOptionPane.WARNING_MESSAGE);
			 return false;
		}
		if(test3!=null)
		{
			 JOptionPane.showMessageDialog(null, "Chauvechment Classe Etude Une autre Matiere  ", " Error", JOptionPane.WARNING_MESSAGE);
			 return false;
		}

		 return true;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean SeanceExiste(Seance s)
	{
		return false;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	Seance Create()
	{
		Seance s=new Seance();
		s.setCIN(getId_Instituteur_select());
		s.setCLASSE(getId_Classe_select());
		s.setHORAIRE(getId_Horaire_select());
		s.setMATIERE(getId_Matiere_select());
		s.setSALLE(getId_Salle_select());
		s.setJOUR(getId_Jour_select());
		
		
		return s;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	

	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void UpdateTable() 
	{
		String cas;
		int ligne,colone;
		int classe=getId_Classe_select();
		ArrayList<Seance> tab=new DAOseance().getALL(classe);
		
		 setModel_TableEmploi_ParDesfault();
		    
		 DefaultTableModel model = (DefaultTableModel) this.table_emploiClass.getModel();
		    
		for (Seance s : tab) {
			
			ligne=s.getHORAIRE()-1;
			colone=s.getJOUR();
			cas=ConcatenerSeance(s);
			
			model.setValueAt(cas, ligne, colone);
		}	
		
		SetId_Seance_Seelect_A_zeero();
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/

	String getNomPrenom_Insitituteur(int cin)
	{
		
		Instituteur inst=new DAOinstituteur().getById(cin);
		String nom,prenom,NomPrenom;
		
		if(inst!=null)
		{
			nom=inst.getNOM();
			prenom=inst.getPRENOM();
			NomPrenom=nom+"-"+prenom;
			return NomPrenom;
		}
		return null;
		
	}
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	String  getNom_Matiere(int num)
	{
		Matiere m=new DAOmatier().getById(num);
		
		if(m!=null)
		{
			return m.getNOM();
		}
		return null;
	}
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	String  getNom_Class(int num)
	{
		Classe c=new DAOclass().getById(num);
		
		if(c!=null)
		{
			return c.getNOM();
		}
		return null;
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	String  getNom_Salle(int num)
	{
		Salle c=new DAOsalle().getById(num);
		
		if(c!=null)
		{
			return c.getNOM();
		}
		return null;
	}
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	
	private String ConcatenerSeance(Seance s) 
	{
		
		String nomInst,nomMatier,Cas,nomSale;
		
		nomInst=getNomPrenom_Insitituteur(s.getCIN());
		nomMatier=getNom_Matiere(s.getMATIERE());
		nomSale=getNom_Salle(s.getSALLE());
		
		
		Cas= nomInst +"&" + nomMatier + "&" + nomSale;
		return Cas;
	}
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/

	public void setModel_TableEmploi_ParDesfault() {

		
		this.table_emploiClass.setModel(new javax.swing.table.DefaultTableModel(
     		   new Object [][] {
             	   {"     8H-10h", " ", " ", " ", " ", " ", " "},
                   {"    10H-12h",  " ", " ", " ", " ", " ", " "},
                   {"    12H-13h", " ", " ", " ", " ", " ", " "},
                   {"    14H-16h",  " ", " ", " ", " ", " ", " "},
                   {"    16H-18h",  " ", " ", " ", " ", " ", " "}},
             new String [] {"", "Lundi", "Mardi", "Mecredi", "Jeudi", "Vendredi", "Samedi"}));
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void clear() {
		
		if(Tester_formlaire())
		{
			this.cmb_matier.setSelectedIndex(0);
			this.cmb_salle.setSelectedIndex(0);
			this.cmb_institiuteur.setSelectedIndex(0);
			this.cmb_horair.setSelectedIndex(0);
			this.cmb_date.setSelectedIndex(0);
			this.cmb_salle.setSelectedIndex(0);
		}
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public boolean Tester_formlaire() {
		
		if((this.cmb_class.getItemCount()>0 ) && (this.cmb_matier.getItemCount()>0 ) && (this.cmb_salle.getItemCount()>0 ) && (this.cmb_institiuteur.getItemCount()>0 ))
		return true;
		
		return false;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public boolean All_champs_is_empty() {
		
		return false;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	int getId_Jour_select()
	{
		return this.cmb_date.getSelectedIndex()+1;
	}
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	int getId_Horaire_select()
	{
		return this.cmb_horair.getSelectedIndex()+1;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getId_Classe_select()
	{
		Classe c=null;
		String nomclass="";
		
		if(this.cmb_class.getItemCount()>0)
		{
			nomclass=this.cmb_class.getSelectedItem().toString();
			c=new DAOclass().getByNom(nomclass);
			if(c!=null)
				return c.getID();
		}
		    return -1;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getId_Matiere_select()
	{
		Matiere m=null;
		String nomMat="";
		
		if(this.cmb_matier.getItemCount()>0)
		{
			nomMat=this.cmb_matier.getSelectedItem().toString();
			m=new DAOmatier().getByNom(nomMat);
			if(m!=null)
				return m.getID();
		}
		    return -1;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getId_Instituteur_select()
	{
		Instituteur m=null;
		String nomInst="",prenomInst="",Inst;
		int i;
		if(this.cmb_institiuteur.getItemCount()>0)
		{
			
			Inst=this.cmb_institiuteur.getSelectedItem().toString();
			i=Inst.length();
			nomInst=Inst.substring(0, Inst.indexOf("-"));
			prenomInst=Inst.substring(Inst.indexOf("-")+1,i);

			m=new DAOinstituteur().getByNomPrenom(nomInst, prenomInst);
			if(m!=null)
				return m.getCIN();
		}
		    return -1;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getId_Salle_select()
	{
		Salle m=null;
		String nomSal="";
		if(this.cmb_salle.getItemCount()>0)
		{
			nomSal=this.cmb_salle.getSelectedItem().toString();
			m=new DAOsalle().getByNom(nomSal);
			if(m!=null){
				return m.getID();}
		}
		    return -1;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int ligne=this.table_emploiClass.getSelectedRow();
		int col=this.table_emploiClass.getSelectedColumn();
		String nomMat,nomSal,nomInst,NomMat_NomSale;
		int taile_Seance_Select,Taile_NomMatier_NomSale;
		
		if(ligne!=-1 && col!=-1)
		{
			String Seance_Select=this.table_emploiClass.getValueAt(ligne, col).toString();
			
			if(seanceVide(Seance_Select)==false)
			{
				taile_Seance_Select=Seance_Select.length();
				nomInst=Seance_Select.substring(0, Seance_Select.indexOf("&"));
				NomMat_NomSale=Seance_Select.substring(Seance_Select.indexOf("&")+1,taile_Seance_Select);
				Taile_NomMatier_NomSale=NomMat_NomSale.length();
				nomMat=NomMat_NomSale.substring(0,NomMat_NomSale.indexOf("&") );
			    nomSal=NomMat_NomSale.substring(NomMat_NomSale.indexOf("&")+1 ,Taile_NomMatier_NomSale);
			
			    UpdateCombo(ligne,col,nomInst,nomMat,nomSal);
			    
			    UpdateIdSeance_Seelect();
			}
			else
			{
				this.cmb_date.setSelectedIndex(col-1);
				this.cmb_horair.setSelectedIndex(ligne);
				
				Id_Seance_Select=0;
			}
			
		}
		
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Key   listener   =========================================================*/
   	/*========================================================================================================================*/
	
	public void UpdateIdSeance_Seelect() 
	{
		
	  Seance seance_select=new Seance();
	  seance_select.setCIN(getId_Instituteur_select());
	  seance_select.setSALLE(getId_Salle_select());
	  seance_select.setMATIERE(getId_Matiere_select());
	  seance_select.setJOUR(getId_Jour_select());
	  seance_select.setHORAIRE(getId_Horaire_select());
	  seance_select.setCLASSE(getId_Classe_select());
	  
	  Id_Seance_Select=new DAOseance().getidSeance(seance_select);

	}
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void SetId_Seance_Seelect_A_zeero()
	{
		Id_Seance_Select=0;
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Key   listener   =========================================================*/
   	/*========================================================================================================================*/
	boolean seanceVide(String seance)
	{
	    if(seance==null)
		return true;
	    
		if(seance.equals(" "))
			return true;
		
		return false;
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Key   listener   =========================================================*/
   	/*========================================================================================================================*/
	
	private void UpdateCombo(int ligne, int col, String nomInst, String nomMat, String nomSal)
	{
		
	this.cmb_matier.setSelectedItem(nomMat);
	this.cmb_salle.setSelectedItem(nomSal);
	this.cmb_institiuteur.setSelectedItem(nomInst);
	this.cmb_date.setSelectedIndex(col-1);
	this.cmb_horair.setSelectedIndex(ligne);
		
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Key   listener   =========================================================*/
   	/*========================================================================================================================*/


	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource()==this.cmb_niveau)
		{
			clear();
			Remplir_cmb_Classe();
			Remplir_cmb_Matiere();
			UpdateTable();
			
			
		}
		if(e.getSource()==this.cmb_class)
		{
			UpdateTable();
		}
	
		
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
	
	public void Remplir_cmb_Salle()
	{
		DAOsalle d=new DAOsalle();
		ArrayList<String> tab;
		
		if(this.cmb_salle.getItemCount()>0)
			this.cmb_salle.removeAllItems();

		tab=d.ListeDesSalles();
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_salle.addItem(c);
			}
		}
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_cmb_Matiere()
	{
		DAOmatier d=new DAOmatier();
		ArrayList<String> tab;
		
		if(this.cmb_matier.getItemCount()>0)
			this.cmb_matier.removeAllItems();
		
	    int niv=this.cmb_niveau.getSelectedIndex()+1;
		tab=d.ListeDesMatiereByNiveau(niv);
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_matier.addItem(c);
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
	
	public void Remplir_cmb_Instituteur()
	{
		DAOinstituteur d=new DAOinstituteur();
		ArrayList<String> tab;
		
		if(this.cmb_institiuteur.getItemCount()>0)
			this.cmb_institiuteur.removeAllItems();
		
		tab=d.ListeDesInstituteur();
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_institiuteur.addItem(c);
			}
		}
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public void Remplir_cmb_Horaire()
	{
		DAOseance d=new DAOseance();
		ArrayList<String> tab;
		
		if(this.cmb_horair.getItemCount()>0)
			this.cmb_horair.removeAllItems();
		
		tab=d.ListeDesHoraires();
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_horair.addItem(c);
			}
		}
	}
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_cmb_date()
	{
		DAOseance d=new DAOseance();
		ArrayList<String> tab;
		
		if(this.cmb_date.getItemCount()>0)
			this.cmb_date.removeAllItems();
		
		tab=d.ListeDesJours();
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_date.addItem(c);
			}
		}
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*======================================================================================================================== */
	
	  private javax.swing.JButton btn_ajout;
	    private javax.swing.JButton btn_impr;
	    private javax.swing.JButton btn_modifier;
	    private javax.swing.JButton btn_suprimer;
	    private javax.swing.JComboBox<String> cmb_class;
	    private javax.swing.JComboBox<String> cmb_date;
	    private javax.swing.JComboBox<String> cmb_horair;
	    private javax.swing.JComboBox<String> cmb_institiuteur;
	    private javax.swing.JComboBox<String> cmb_matier;
	    private javax.swing.JComboBox<String> cmb_niveau;
	    private javax.swing.JComboBox<String> cmb_salle;
	    private javax.swing.JTable table_emploiClass;
	    
	    
	    
	public Ecouteur_Emploi_Class(JButton btn_ajout, JButton btn_impr, JButton btn_modifier, JButton btn_suprimer,
				JComboBox<String> cmb_class, JComboBox<String> cmb_date, JComboBox<String> cmb_horair,
				JComboBox<String> cmb_institiuteur, JComboBox<String> cmb_matier, JComboBox<String> cmb_niveau,
				JComboBox<String> cmb_salle, JTable table_emploiClass) {
			super();
			this.btn_ajout = btn_ajout;
			this.btn_impr = btn_impr;
			this.btn_modifier = btn_modifier;
			this.btn_suprimer = btn_suprimer;
			this.cmb_class = cmb_class;
			this.cmb_date = cmb_date;
			this.cmb_horair = cmb_horair;
			this.cmb_institiuteur = cmb_institiuteur;
			this.cmb_matier = cmb_matier;
			this.cmb_niveau = cmb_niveau;
			this.cmb_salle = cmb_salle;
			this.table_emploiClass = table_emploiClass;
			dao=new   DAOseance();
		}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Consulter() {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void Recherche() {	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
}
