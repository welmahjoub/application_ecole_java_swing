package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.DAOclass;
import DAO.DAOconseil;
import DAO.DAOniveau;
import MODEL.Classe;
import MODEL.Conseil;
import VUE.Fenetre_Conseil;

import net.proteanit.sql.DbUtils;

public class Ecouteur_Conseil extends Ecouteur implements ActionListener,ItemListener,MouseListener,KeyListener{

	private Fenetre_Conseil fen;
	private DAOconseil d;
	private ResultSet rs;
	private Conseil con;
	
	public Ecouteur_Conseil(Fenetre_Conseil fen)
	{
		this.fen=fen;
		d=new DAOconseil();
	
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_cmb_Classe()
	{
		
		DAOclass d=new DAOclass();
		ArrayList<String> tab;
		
		if(fen.cmb_class.getItemCount()>0)
			fen.cmb_class.removeAllItems();
		
	    int niv=fen.cmb_niveau.getSelectedIndex()+1;
		tab=d.ListeDesClasseByNiveau(niv);
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				fen.cmb_class.addItem(c);
			}
		}
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void Remplir_cmb_Niveau()
	{
		DAOniveau d=new  DAOniveau();
		ArrayList<String> tab;
		
		if(fen.cmb_niveau.getItemCount()>0)
			fen.cmb_niveau.removeAllItems();

		tab=d.ListeDesNiveau();
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				fen.cmb_niveau.addItem(c);
			}
		}
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public int getId_Classe_selectione()
	{
		Classe c=null;
		String nomclass="";
		if(fen.cmb_class.getItemCount()>0)
		{
			nomclass=fen.cmb_class.getSelectedItem().toString();
			c=new DAOclass().getByNom(nomclass);
			if(c!=null){
				return c.getID();}
		}
		    return -1;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	Conseil Create()
	{
		Conseil c =new Conseil();
		int idclass=getId_Classe_selectione();
		String Date=((JTextField)fen.txt_Date.getDateEditor()).getText();
		
		 c.setTEXT(fen.txt_conseil.getText());
		 c.setCLASS(idclass);
		 c.setDATE(Date);
		 return c;	 
		 
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Ajouter() 
	{
		Conseil c;
		
		if(All_champs_is_empty()==true)
	   	 {
	   		 JOptionPane.showInternalMessageDialog(fen, " Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
	   	 }	 
	     else if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showInternalMessageDialog(fen, " Veuillez Saisir Des Informations Correct  ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	     else  
	     { 
	    	 c=Create();
	    	 if(ConseilExiste(c.getDATE(),c.getCLASS())==false)
	    	 {
	    		 
	    		 if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette Conseil    ? ")==0)
					{ 					 
                         d.Ajouter(c);
						 UpdateTable();
						 clear();
					}
	    		 
	    	 }
	    	 else
	    		 JOptionPane.showInternalMessageDialog(fen, " On ne peut Avoir des Conseil pour mem class dans le meme date ", "Exist", JOptionPane.WARNING_MESSAGE); 
					
	     }  	 
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Modifier() 
	{
		 if(All_champs_is_empty()==true)
         {
	        JOptionPane.showInternalMessageDialog(fen, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
          }	
		 else if(Tester_formlaire()==false)
		 {
			 JOptionPane.showInternalMessageDialog(fen, " Veuillez saisi des informations Correct slvp ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
		 }
		 else {

			     Conseil c =Create();
			     if(ConseilExiste(c.getDATE(),c.getCLASS())==true)
			     {
			    	 if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifier   cette Classe  ? ")==0)
						{
			    		    Conseil n=d.getConseil(c.getDATE(), c.getCLASS());
			    		    n.setDATE(c.getDATE());
			    		    n.setTEXT(c.getTEXT());
			    		    
			    		    if(n!=null)
			    		    {
			    		    	    d.Modifier(n);
						    	    UpdateTable();
						    	    clear();
			    		    }
						} 	 
			     } 
			     else
			    	 JOptionPane.showInternalMessageDialog(fen, " Conseil n existe pas  ", "Exist", JOptionPane.WARNING_MESSAGE);
		 }	
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Supprimer() 
	{
		if(All_champs_is_empty()==true)
        {
	        JOptionPane.showInternalMessageDialog(fen, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
         }	
		 else if(Tester_formlaire()==false)
		 {
			
			 JOptionPane.showInternalMessageDialog(fen, " Veuillez saisi des informations Correct slvp ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
		 }
	     else {
	    	
	          Conseil c=Create();
	          
	          if(ConseilExiste(c.getDATE(),c.getCLASS())==false)
	          {
	        	  JOptionPane.showInternalMessageDialog(fen, " Conseil n existe pas    ", "Champs Vide ", JOptionPane.WARNING_MESSAGE);   
	          }
	          else if(JOptionPane.showConfirmDialog(null, " Voulez vous supprimer   cette conseil  ? ")==0)
		        {
	    	     
	        	  Conseil n=d.getConseil(c.getDATE(), c.getCLASS());
                  d.Supprimer(n.getID());
			       UpdateTable();
				   clear();
		         } 
	     }	
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Consulter() 
	{
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void UpdateTable() 
	{
		rs=d.getAll();
		if(rs!=null)
        fen.table_conseil.setModel(DbUtils.resultSetToTableModel(rs));
	
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void clear() 
	{
	
		fen.txt_conseil.setText("");
		fen.txt_Date.setDate(null);
		InitialiseDate();
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public void InitialiseDate()
	{

		java.util.Date date = new java.util.Date(); 

		fen.txt_Date.setDate(date);
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean ConseilExiste(String date,int classe)
	{	
		 Conseil t=d.getConseil(date, classe);
		 
		 if(t!=null)
		return true;
		 else
			 return false;
	}

	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public boolean Tester_formlaire() {
		
		
		return true;
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
	@Override
	public void Recherche() 
	{
	         int numclass=0;
	         setModel_TableConseil_ParDesfault();
	       
			if(fen.txt_recherche.getText().equals("")==false)
			{
				     String nomclass=fen.txt_recherche.getText();
				     
					  Classe c=new DAOclass().getByNom(nomclass);
					  if(c!=null)
					  numclass=c.getID();
						
					  ResultSet rs=null;
					  rs =new DAOconseil().getAll_ByClass(numclass); 
					  
					  if(rs!=null)
					  fen.table_conseil.setModel(DbUtils.resultSetToTableModel(rs)); 
			}
			else
				 UpdateTable();
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	private void setModel_TableConseil_ParDesfault() {
		fen. table_conseil.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {		          },
		            new String [] { "Date ", "class", "text" } ));
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==fen.cmb_niveau)
		{
			Remplir_cmb_Classe();
			
		}
	
			
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fen.btn_ajout)
		{
			Ajouter();
		}
		if(e.getSource()==fen.btn_mod)
		{
			Modifier();
		}
		if(e.getSource()==fen.btn_sup)
		{
			Supprimer();
		}
		if(e.getSource()==fen.btn_clear)
		{
			clear();
		}
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{

		String dat,nomclass;
		int i=fen.table_conseil.getSelectedRow();
		dat=fen.table_conseil.getValueAt(i,0).toString();
		nomclass=fen.table_conseil.getValueAt(i,1).toString();
		Classe cl=new DAOclass().getByNom(nomclass);
	    int idclass=cl.getID();
	    int idniv=cl.getNIVEAU();
	    fen.cmb_niveau.setSelectedIndex(idniv-1);
		fen.cmb_class.setSelectedItem(nomclass);
		con= d.getConseil(dat,idclass) ;
	    fen.txt_conseil.setText(con.getTEXT()); 
	    
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	     try {
	            java.util.Date date = formatter.parse(dat);
	 	          fen.txt_Date.setDate(date);
	 	          
	     } catch (ParseException ex) { System.out.println(" erreur convertion date  ");}
 
	    
	        
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource()==fen.txt_recherche)
			Recherche();
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getSource()==fen.txt_recherche)
			Recherche();
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void mouseReleased(MouseEvent arg0) {	
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {	
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}
	@Override
	public void keyTyped(KeyEvent arg0) {	
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
}
