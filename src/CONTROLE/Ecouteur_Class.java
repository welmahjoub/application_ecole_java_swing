package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.DAOclass;
import DAO.DAOniveau;
import MODEL.Classe;
import net.proteanit.sql.DbUtils;

public class Ecouteur_Class extends Ecouteur implements  ActionListener,KeyListener,MouseListener{

	
    DAOclass d;
    Classe m =null;

	public int id,id_niv;
	ResultSet rs;
	private Classe test1;
	
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	
	@Override
	public void actionPerformed(ActionEvent arg) 
	{
		if(arg.getSource()==this.btn_ajout)
		{
			Ajouter();
		}
		if(arg.getSource()==this.btn_mod)
		{
			Modifier();
		}
		if(arg.getSource()==this.btn_sup)
		{
			Supprimer();
		}
		if(arg.getSource()==this.btn_clear)
		{
			clear();
		}
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Ajouter() 
	{
		if(All_champs_is_empty()==true)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
	   	 }	 
	     else if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez Saisir Des Informations Correct  ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	     else  
	     {
               String nom=this.txt_nom.getText();
	    	   Classe test2=d.getByNom(nom);

		    	if(test2==null)
				{
					if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette Classe   ? ")==0)
					{
						 m.setNIVEAU(this.cmb_niveau.getSelectedIndex()+1);
						 m.setNOM(this.txt_nom.getText());
						
						 
                         d.Ajouter(m);
						 UpdateTable();
						 clear();
					}
				}
				else
				{
					 JOptionPane.showMessageDialog(null, " Classe existe  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 

				}
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
	        JOptionPane.showMessageDialog(null, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
          }	
		 else if(Tester_formlaire()==false)
		 {
			 JOptionPane.showMessageDialog(null, " Veuillez saisi des informations Correct slvp ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
		 }
		 else {
				    String nom=this.txt_nom.getText();
			    	 test1 = d.getByNom(nom);
			      if(test1!=null) 
				{
			    	  if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifier   cette Classe  ? ")==0)
						{
			    		  
			    		     test1.setNIVEAU(this.cmb_niveau.getSelectedIndex()+1); 
				    	     d.Modifier(test1);
				    	     UpdateTable();
				    	     clear();
				    	  
						} 
				}else
					JOptionPane.showMessageDialog(null, " Classe n existe pas  ", " Erreur ", JOptionPane.WARNING_MESSAGE);
					
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
	        JOptionPane.showMessageDialog(null, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
          }	
		 else if(Tester_formlaire()==false)
		 {
			
			 JOptionPane.showMessageDialog(null, " Veuillez saisi des informations Correct slvp ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
		 }
	     else {
	    	 
	    
	    	 String nom=this.txt_nom.getText();
	          test1=d.getByNom(nom);
	          
	          if(test1==null)
	          {
	        	  JOptionPane.showMessageDialog(null, "Classe n exitse pas  ", "Champs Vide ", JOptionPane.WARNING_MESSAGE);   
	          }
	          else if(JOptionPane.showConfirmDialog(null, " Voulez vous supprimer   cette Classe  ? ")==0)
		        {
	    	     
                   d.Supprimer(test1.getID());
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
		
		if(m!=null)
		{
			
			this.txt_nom.setText(m.getNOM());
			this.cmb_niveau.setSelectedIndex(m.getNIVEAU()-1);
		
		}
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void UpdateTable()
	{

		rs=d.getAll();
		if(rs!=null)
        this.table_class.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/

	@SuppressWarnings("deprecation")
	@Override
	public void clear() 
	{
		this.cmb_niveau.setSelectedIndex(0);
		this.txt_nom.setText("");
		this.txt_nom.enable(true);
		this.lbl_test_nom.setText("");
		
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

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public boolean Tester_formlaire() {

		TesterNom();
		  if(this.txt_nom.getText().matches("[A-Za-z][A-Za-z0-9 ]*")==true)
			return true;
		
		return false;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public boolean All_champs_is_empty() {
		
		if(this.txt_nom.getText().equals(""))
		   return true;
					
		
		return false;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row =this.table_class.getSelectedRow();
		if(row!=-1)
		{
			String  nom=  this.table_class.getModel().getValueAt(row, 0).toString();
			m=d.getByNom(nom);
			this.txt_nom.enable(false);
		    Consulter();
		    
		}
	}
	
	
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Key   listener   =========================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Recherche()
	{

		String nom;

		if(this.txt_recherche.getText().equals("")==false)
		{
			nom=this.txt_recherche.getText();
			
			if(nom.matches("[A-Za-z][A-Za-z0-9 ]*")==true)
			{
				rs=d.Find_ByNom(nom);
			}
			if(nom.matches("[0-9]*")==true)
			 {
				  int id_niv=Integer.parseInt(nom);
				  
				  rs=d.FindByNiveau(id_niv);
			 }
			  
			  if(rs!=null)
		     this.table_class.setModel(DbUtils.resultSetToTableModel(rs));
		}
		else
		{
			UpdateTable();
		}
		
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void  TesterNom()
	{
		if(this.txt_nom.getText().equals(""))
		{
			this.lbl_test_nom.setIcon(null);
			this.  lbl_test_nom.setText(" * ");
		}	
		else 
		     if(this.txt_nom.getText().matches("[A-Za-z][A-Za-z0-9 ]*")==true)
		     {
		         this.  lbl_test_nom.setText("");
		         this.lbl_test_nom.setIcon(null);
		     }
            else 
             {
                 this.  lbl_test_nom.setText("");
                 this.lbl_test_nom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
              }
                    	
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void keyPressed(KeyEvent arg)
	{
	
		if(arg.getSource()!=this.txt_recherche)
		TesterNom();
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void keyReleased(KeyEvent arg)
	{
		
		if(arg.getSource()==this.txt_recherche)
			Recherche();
		else
		  TesterNom();
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyTyped(KeyEvent arg) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	/*========================================================================================================================*/
   	/*========================================= fin                           ================================================*/
   	/*========================================================================================================================*/
	    private javax.swing.JButton btn_ajout;
	    private javax.swing.JButton btn_clear;
	    private javax.swing.JButton btn_mod;
	    private javax.swing.JButton btn_sup;
	    private javax.swing.JComboBox<String> cmb_niveau;
	    private javax.swing.JTable table_class;
	    private javax.swing.JTextField txt_nom;
	    private javax.swing.JTextField txt_recherche;
	    private javax.swing.JLabel lbl_test_nom;

		public Ecouteur_Class(JButton btn_ajout, JButton btn_clear, JButton btn_mod, JButton btn_sup,
				JComboBox<String> cmb_niveau, JTable table_class, JTextField txt_nom, JTextField txt_recherche,
				JLabel lbl_test_nom) {
			super();
			this.btn_ajout = btn_ajout;
			this.btn_clear = btn_clear;
			this.btn_mod = btn_mod;
			this.btn_sup = btn_sup;
			this.cmb_niveau = cmb_niveau;
			this.table_class = table_class;
			this.txt_nom = txt_nom;
			this.txt_recherche = txt_recherche;
			this.lbl_test_nom = lbl_test_nom;
			
			d=new DAOclass();
			m=new Classe();
		}
	    
	
	    
	    
	    
	
	/*========================================================================================================================*/
   	/*========================================= fin                           ================================================*/
   	/*========================================================================================================================*/
	
}


