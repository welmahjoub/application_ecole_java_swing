package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import DAO.DAOsalle;
import MODEL.Salle;
import net.proteanit.sql.DbUtils;

public class Ecouteur_Salle extends Ecouteur implements  ActionListener,KeyListener,MouseListener{

	
	private DAOsalle d;
	private Salle s;
	private ResultSet rs;
	private Salle test;
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	

	
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		
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
	    	   test=d.getByNom(nom);

		    	if(test==null)
				{
					if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette salle    ? ")==0)
					{
						 
						s.setNOM(this.txt_nom.getText());
						s.setTYPE(this.cmb_type.getSelectedItem().toString());
						s.setCAPACITE(this.txt_capa.getText());
						
                        d.Ajouter(s);
						UpdateTable();
						clear();
					}
				}
				else
				{
					 JOptionPane.showMessageDialog(null," salle existe  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 

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
			    	 test = d.getByNom(nom);
			      if(test!=null) 
				{
			    	  if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifier   cette Salle  ? ")==0)
						{
			    		  
			    		     test.setCAPACITE(this.txt_capa.getText());
			    		     test.setTYPE(this.cmb_type.getSelectedItem().toString());
				    	     d.Modifier(test);
				    	     UpdateTable();
				    	     clear();
				    	  
						} 
				}else
					JOptionPane.showMessageDialog(null, " Salle n existe pas  ", " Erreur ", JOptionPane.WARNING_MESSAGE);
					
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
	          test=d.getByNom(nom);
	          
	          if(test==null)
	          {
	        	  JOptionPane.showMessageDialog(null, "Salle n exitse pas  ", "Champs Vide ", JOptionPane.WARNING_MESSAGE);   
	          }
	          else if(JOptionPane.showConfirmDialog(null, " Voulez vous supprimer   cette Salle  ? ")==0)
		        {
	    	     
                  d.Supprimer(test.getID());
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
		if(s!=null)
		{
			this.txt_nom.setText(s.getNOM());
			this.cmb_type.setSelectedItem(s.getTYPE());
			this.txt_capa.setText(s.getCAPACITE());
			
		}	
		
		TesterCapacite();
		TesterNom();
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void UpdateTable() 
	{
		rs=d.getAll();
		if(rs!=null)
        this.table_salle.setModel(DbUtils.resultSetToTableModel(rs));
		else
		{
			 this.table_salle.setModel(new javax.swing.table.DefaultTableModel(
			 new Object [][] {  },
			 new String [] { " Salle ", "TYPE" }));
		}

	}
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/

	@SuppressWarnings("deprecation")
	@Override
	public void clear() 
	{
		
	  this.txt_nom.enable(true);
	  this.cmb_type.setSelectedIndex(0);
	  this.txt_capa.setText("");
	  this.txt_nom.setText("");
	  this.lbl_test_capa.setText("");
	  this.lbl_test_nom.setText("");
	  
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public boolean Tester_formlaire()
	{
		
		   TesterNom();
		  if(this.txt_nom.getText().matches("[A-Za-z][A-Za-z0-9 ]*")==true)
			return true;
		  TesterNom();
		  if(this.txt_capa.getText().matches("[0-9]*")==true)
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
		if(this.txt_capa.getText().equals(""))
			   return true;	
		
		return false;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row =this.table_salle.getSelectedRow();
		if(row!=-1)
		{
			String  nom=  this.table_salle.getModel().getValueAt(row, 0).toString();
			s=d.getByNom(nom);
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
				if(nom.equals("TP") || nom.equals("Cour")|| nom.equals("cour")|| nom.equals("tp"))
				rs=d.Find_ByType(nom);
				else
					rs=d.Find_ByNom(nom);	
			}
			if(nom.matches("[0-9]*")==true)
			 {
				  int capa=Integer.parseInt(nom);  
				  rs=d.Find_ByCapacite(capa);
			 }
			  
			 if(rs!=null)
		     this.table_salle.setModel(DbUtils.resultSetToTableModel(rs));
			 else
			 {
				 this.table_salle.setModel(new javax.swing.table.DefaultTableModel(
						 new Object [][] {  },
						 new String [] {  "   Matiere", "Niveau" })); 
			 }
		}
		else
		{
			UpdateTable();
		}	
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void  TesterNom()
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
	
	void TesterCapacite()
	{

		if(this.txt_capa.getText().equals(""))
		{
			this.lbl_test_capa.setIcon(null);
			this.  lbl_test_capa.setText(" * ");
		}	
		else 
		     if(this.txt_capa.getText().matches("[0-9 ]*")==true)
		     {
		         this.  lbl_test_capa.setText("");
		         this.lbl_test_capa.setIcon(null);
		     }
            else 
             {
                 this.  lbl_test_capa.setText("");
                 this.lbl_test_capa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
              }
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	
	@Override
	public void keyPressed(KeyEvent arg) 
	{
	
		if(arg.getSource()!=this.txt_recherche)
		{
			TesterNom();
			TesterCapacite();
		}
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
		{
			TesterNom();
			TesterCapacite();
		}
		  	
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
   	/*========================================= Fin   ================================================*/
   	/*========================================================================================================================*/
	
	 private  javax.swing.JButton btn_ajout;
	    private javax.swing.JButton btn_clear;
	    private javax.swing.JButton btn_mod;
	    private javax.swing.JButton btn_sup;
	    private javax.swing.JTextField txt_capa;
	    private javax.swing.JTextField txt_nom;
	    private javax.swing.JTextField txt_recherche;
	    private javax.swing.JComboBox<String> cmb_type;
	    private javax.swing.JLabel lbl_test_capa;
	    private javax.swing.JLabel lbl_test_nom;
	    private javax.swing.JTable table_salle;

		public Ecouteur_Salle(JButton btn_ajout, JButton btn_clear, JButton btn_mod, JButton btn_sup,
				JTextField txt_capa, JTextField txt_nom, JTextField txt_recherche, JComboBox<String> cmb_type,
				JLabel lbl_test_capa, JLabel lbl_test_nom, JTable table_salle) {
			super();
			this.btn_ajout = btn_ajout;
			this.btn_clear = btn_clear;
			this.btn_mod = btn_mod;
			this.btn_sup = btn_sup;
			this.txt_capa = txt_capa;
			this.txt_nom = txt_nom;
			this.txt_recherche = txt_recherche;
			this.cmb_type = cmb_type;
			this.lbl_test_capa = lbl_test_capa;
			this.lbl_test_nom = lbl_test_nom;
			this.table_salle = table_salle;
			
			d=new DAOsalle();
			s=new Salle();
		}
	    
	    
		/*========================================================================================================================*/
	   	/*========================================= Fin   ================================================*/
	   	/*========================================================================================================================*/
}
