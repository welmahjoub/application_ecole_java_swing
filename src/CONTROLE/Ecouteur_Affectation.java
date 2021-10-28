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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.DAOclass;
import DAO.DAOeleve;
import DAO.DAOniveau;
import MODEL.Classe;

import net.proteanit.sql.DbUtils;

public class Ecouteur_Affectation implements MouseListener,ItemListener,KeyListener,ActionListener {


	ResultSet rs;
	DAOeleve Dao_eleve;
	DAOclass Dao_class;
	
	int id_niv=1;
	int id_class;
	Classe c=null;
	String nom_class;
	int num;
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==this.btn_affecter)
		{
			Affecter_Eleve();
		}
		if(arg0.getSource()==this.btn_sup_consulter)
		{
			Supprimer_Eleve_From_class();
		}
		if(arg0.getSource()==this.btn_imprimer_consulter)
		{
			EvenementImpression();
		}
		if(arg0.getSource()==this.btn_imprimer__affectation)
		{
			EvenementImpression();
		}
		
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	private void EvenementImpression() {
		
		if(this.cmb_class_consulter.getItemCount()>0)
		{
			String nom=this.cmb_class_consulter.getSelectedItem().toString();
			
			Classe c=Dao_class.getByNom(nom);
			
			if(c!=null)
			Imprimer_Listeleve.Imprimer(c.getID());
			
		}
		
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	void Supprimer_Eleve_From_class()
	{
		
		    int tab[];
		    if(TesterFormulaire_Consulter()==false)
			{
				JOptionPane.showMessageDialog(null, " Veuillez Selectionnez Une classe  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
			}
			else
			{
				nom_class=this.cmb_class_consulter.getSelectedItem().toString();
			    String  n;
			    int i;
			    tab=this.table_consulter.getSelectedRows();
				int nb=this.table_consulter.getSelectedRowCount();
				int row =this.table_consulter.getSelectedRow();
				
				if(row!=-1)
				{
						if(TesterFormulaire_Consulter()==false)
						{
							JOptionPane.showMessageDialog(null, " Veuillez Selectionnez Une classe  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
						}
						else if(JOptionPane.showConfirmDialog(null, " Voulez - vous supprimer   ces eleves de cette class " +nom_class)==0)
						{
								for(i=0;i<nb;i++)
								{
									n=  this.table_consulter.getModel().getValueAt(tab[i], 0).toString();
								    num=Integer.parseInt(n);
					                Dao_eleve.Supprimer_Eleve_from_class(num);	
								}
							   UpdateTableConsulter();    		     
						       UpdateTableAffectation();
					   }
				}
		       else
		    	   JOptionPane.showMessageDialog(null, " Veuillez Selectionnez Des Eleves  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
			}
		    
		
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	void Affecter_Eleve()
	{
		 
		int tab[];
		 int nb=0; 
		String  n;
		
		if(TesterFormulaire_Affectation()==false)
		{
			JOptionPane.showMessageDialog(null, " Veuillez Selectionnez Une classe  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
		}
		else
			{
				 nb=this.table__affectation.getSelectedRowCount();	
				 tab=this.table__affectation.getSelectedRows();
				 nom_class=this.cmb_class__affectation.getSelectedItem().toString();
				 c=Dao_class.getByNom(nom_class);
		         id_class=c.getID();
		         
		         if(nb!=0)
		 		{
		 			 if(JOptionPane.showConfirmDialog(null, " Voulez vous Affecter  ces eleves Au class  " + nom_class)==0)
		 			{
		 				for(int i=0;i<nb;i++)
		 				{
		 				    n= this.table__affectation.getModel().getValueAt(tab[i],0 ).toString();
		 					num=Integer.parseInt(n);
		 				    Dao_eleve.Affecter_Eleve_to_class(num, id_class);
		 				}
		 				UpdateTableAffectation();
		 				UpdateTableConsulter();
		 		    }	
		 	     }else
		 			  JOptionPane.showMessageDialog(null, " Veuillez Selectionnez Des Eleves  ", " Erreur ", JOptionPane.WARNING_MESSAGE); 	
		 	}      
	}				
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	public void UpdateTableConsulter()
    {  	
		 if(this.cmb_class_consulter.getItemCount()!=0)
	    	{
			   nom_class=this.cmb_class_consulter.getSelectedItem().toString();
	    	
        	if(nom_class!=null)
        	{
        		c=Dao_class.getByNom(nom_class);
        		if(c!=null)
        		{
        			id_class=c.getID();
                	rs=Dao_eleve.Find_AllEleves_ByClass(id_class);	
                	if(rs!=null)
        			this.table_consulter.setModel(DbUtils.resultSetToTableModel(rs));
        		}
            	
        	}
	    }
		 else
		 {
		        this. table_consulter.setModel(new javax.swing.table.DefaultTableModel(
	 			new Object [][] {},
	 		    new String [] {	 "Num ", " Nom", "Prenom","class "," Niveau " } )); 
			       
		 }
			 
    }
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	 public void UpdateTableAffectation()
	    {
	    	 int niveau=this.cmb_niveau_affectation.getSelectedIndex()+1;
	    	 
	    	 rs=Dao_eleve.Find_AllEleves_No_Affecte(niveau);
	    	 if(rs!=null)
			this.table__affectation.setModel(DbUtils.resultSetToTableModel(rs));
	    	 else
	    	 {
	 			this. table__affectation.setModel(new javax.swing.table.DefaultTableModel(
	 			new Object [][] {},
	 		    new String [] {	 "Num ", " Nom", "Prenom"," Niveau " } ));     
	 	 }
	 }
	    
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	 public   void Remplir_cmb_Consulter()
	    {
		     id_niv=this.cmb_niveau_consulter.getSelectedIndex()+1;
		    
	    	 rs=Dao_class.FindByNiveau(id_niv);
	    	 
	    	 if(this.cmb_class_consulter.getItemCount()!=0)
		    	{
		    		this.cmb_class_consulter.removeAllItems();
		    	}
		        if(rs!=null)
		    	{
		        	try {
		        		
		    			while(rs.next())
		    			{
		    				
		    				this.cmb_class_consulter.addItem(rs.getString("classe"));
		    			}
		    		} catch (Exception e) {
		    			System.out.println(" erueru au niveau remplir cmb  gere class");
		    		}
		    	}
	    	
	    
	    }
		/*========================================================================================================================*/
		/*========================================= 2) fonction  ================================================*/
		/*========================================================================================================================*/
	 
	 public void Remplir_cmb_Niveau_consulter()
		{
			DAOniveau d=new  DAOniveau();
			ArrayList<String> tab;
			
			if(this.cmb_niveau_consulter.getItemCount()>0)
				this.cmb_niveau_consulter.removeAllItems();

			tab=d.ListeDesNiveau();
			if(tab!=null)
			{
		 		for (String c : tab) 
				{
		 			this.cmb_niveau_consulter.addItem(c);
				}
			}
		}
	 /*========================================================================================================================*/
		/*========================================= 2) fonction  ================================================*/
		/*========================================================================================================================*/
	 
		public void Remplir_cmb_Niveau_affect()
		{
			DAOniveau d=new  DAOniveau();
			ArrayList<String> tab;
			
			if(this.cmb_niveau_affectation.getItemCount()>0)
				this.cmb_niveau_affectation.removeAllItems();

			tab=d.ListeDesNiveau();
			if(tab!=null)
			{
		 		for (String c : tab) 
				{
		 			this.cmb_niveau_affectation.addItem(c);
				}
			}
		}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	 
	 public   void Remplir_Cmb_Affectation()
	    {
		    id_niv=this.cmb_niveau_affectation.getSelectedIndex()+1;

	    	rs=Dao_class.FindByNiveau(id_niv);
	    	
	    	if(this.cmb_class__affectation.getItemCount()!=0)
	    	{
	    		this.cmb_class__affectation.removeAllItems();
	    	}
	    	if(rs!=null)
	    	{
	    		try {
	        		
	    			while(rs.next())
	    			{
	    				
	    				this.cmb_class__affectation.addItem(rs.getString("classe"));
	    			}
	    		} catch (Exception e) {
	    			System.out.println(" erueru au niveau remplir cmb 2 gere class");
	    		} 
	    	}
	    	
	    	
	    }
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	 boolean TesterFormulaire_Consulter()
	 {
		 if(this.cmb_class_consulter.getSelectedIndex()==-1)
		 return false;
		 
		 return true;
	 }
	 
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	 
	 boolean TesterFormulaire_Affectation()
	 {
		 if(this.cmb_class__affectation.getSelectedIndex()==-1)
			 return false;
		 
		 return true;
	 }
	 
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

	public void Evenement_recherche_Tablble_Affectation()
	{
			int num;
			String nom;
			int niveau=this.cmb_niveau_affectation.getSelectedIndex()+1;
            
			if(this.txt_recherche_affectation.getText().equals("")==false)
			{
				nom=this.txt_recherche_affectation.getText();
				
				if(nom.matches("[A-Za-z][A-Za-z0-9 ]*")==true)
				{
					rs =Dao_eleve.Find_Eleve_No_Affecter(nom,niveau);
				}
				if(nom.matches("[0-9 ]*")==true)
				{
				    num=Integer.parseInt(this.txt_recherche_affectation.getText());
					rs =Dao_eleve.Find_Eleve_No_Affecter(num,niveau);
				}
				
				if(rs!=null)
					this.table__affectation.setModel(DbUtils.resultSetToTableModel(rs));
				else
					{
					        this. table__affectation.setModel(new javax.swing.table.DefaultTableModel(
				 			new Object [][] {},
				 		    new String [] {	 "Num", " Nom", "Prenom"," Niveau " } ));  
		 		    }	
			}
			else
			{
				UpdateTableAffectation();
			}
		}

		
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	 
	 public void Evenement_recherche_Table_Consulter()
		{
			
				int num;
				String nom;
				
				if(this.cmb_class_consulter.getItemCount()>0)
				nom_class=this.cmb_class_consulter.getSelectedItem().toString();
				else
					nom_class=null;
		    	
		    	if(nom_class!=null)
		    	{
		    		c=Dao_class.getByNom(nom_class);
		        	
		        	id_class=c.getID();
		    	}

				if(this.txt_recherche_consulter.getText().equals("")==false)
				{
					nom=this.txt_recherche_consulter.getText();
					
					if(nom.matches("[A-Za-z][A-Za-z0-9 ]*")==true)
					{
						rs =Dao_eleve.Find_Eleve_By_Class(nom,id_class);
					}
					else
						if(nom.matches("[0-9 ]*")==true)
					{
					    num=Integer.parseInt(this.txt_recherche_consulter.getText());
					    
						rs =Dao_eleve.Find_Eleve_By_class(num,id_class);
						
						
					}
					if(rs!=null)
					this.table_consulter.setModel(DbUtils.resultSetToTableModel(rs));
					else
					{
				        this. table_consulter.setModel(new javax.swing.table.DefaultTableModel(
			 			new Object [][] {},
			 		    new String [] {	 "Num", " Nom", "Prenom","class "," Niveau " } ));   
		 		    }	
				}
				else
				{
					UpdateTableConsulter();
				}

		}
			
	 
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	

	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		if(arg0.getSource()==this.cmb_niveau_affectation)
		{
			Remplir_Cmb_Affectation();
			
		}
		if(arg0.getSource()==this.cmb_niveau_consulter)
		{
			Remplir_cmb_Consulter();
			UpdateTableConsulter();
			
		}
		if(arg0.getSource()==this.cmb_class_consulter)
		{
			UpdateTableConsulter();
			
		}
		if(arg0.getSource()==this.cmb_class__affectation)
		{
			UpdateTableAffectation();
		}
		
	}

	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		if(arg0.getSource()==this.txt_recherche_affectation)
		{
			Evenement_recherche_Tablble_Affectation();
		}
		if(arg0.getSource()==this.txt_recherche_consulter)
		{
			Evenement_recherche_Table_Consulter();
		}
		
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		
		if(arg0.getSource()==this.txt_recherche_affectation)
		{
			Evenement_recherche_Tablble_Affectation();
		}
		if(arg0.getSource()==this.txt_recherche_consulter)
		{
			Evenement_recherche_Table_Consulter();
		}
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mouseEntered(MouseEvent arg0) {	}
		@Override
		public void keyTyped(KeyEvent arg0) {	}
		@Override
		public void mouseClicked(MouseEvent arg0) {	}
	/*========================================================================================================================*/
	/*=========================================                  Fin          ================================================*/
	/*========================================================================================================================*/
	
	    private javax.swing.JButton btn_affecter;
	    private javax.swing.JButton btn_sup_consulter;
	    private javax.swing.JTextField txt_recherche_affectation;
	    private javax.swing.JTextField txt_recherche_consulter;
	    private javax.swing.JTable table__affectation;
	    private javax.swing.JTable table_consulter;
	    private javax.swing.JComboBox<String> cmb_niveau_affectation;
	    private javax.swing.JComboBox<String> cmb_niveau_consulter;
	    private javax.swing.JComboBox<String> cmb_class__affectation;
	    private javax.swing.JComboBox<String> cmb_class_consulter;
	    private javax.swing.JButton btn_imprimer__affectation;
	    private javax.swing.JButton btn_imprimer_consulter;

	    /*========================================================================================================================*/
		/*=========================================                  Fin          ================================================*/
		/*========================================================================================================================*/
	    
		public Ecouteur_Affectation(JButton btn_affecter, JButton btn_sup_consulter,
				JTextField txt_recherche_affectation, JTextField txt_recherche_consulter, JTable table__affectation,
				JTable table_consulter, JComboBox<String> cmb_niveau_affectation,
				JComboBox<String> cmb_niveau_consulter, JComboBox<String> cmb_class__affectation,
				JComboBox<String> cmb_class_consulter, JButton btn_imprimer__affectation,
				JButton btn_imprimer_consulter) {
			super();
			this.btn_affecter = btn_affecter;
			this.btn_sup_consulter = btn_sup_consulter;
			this.txt_recherche_affectation = txt_recherche_affectation;
			this.txt_recherche_consulter = txt_recherche_consulter;
			this.table__affectation = table__affectation;
			this.table_consulter = table_consulter;
			this.cmb_niveau_affectation = cmb_niveau_affectation;
			this.cmb_niveau_consulter = cmb_niveau_consulter;
			this.cmb_class__affectation = cmb_class__affectation;
			this.cmb_class_consulter = cmb_class_consulter;
			this.btn_imprimer__affectation = btn_imprimer__affectation;
			this.btn_imprimer_consulter = btn_imprimer_consulter;
			
			   Dao_eleve=new DAOeleve();
				Dao_class=new DAOclass();
		}
	    

	    
	    
	    

	    
	    
	    
	    /*========================================================================================================================*/
		/*=========================================                  Fin          ================================================*/
		/*========================================================================================================================*/

}
