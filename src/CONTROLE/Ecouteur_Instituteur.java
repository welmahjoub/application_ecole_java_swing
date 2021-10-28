package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.DAOinstituteur;
import MODEL.Instituteur;
import net.proteanit.sql.DbUtils;

public class Ecouteur_Instituteur extends Ecouteur implements  ActionListener,KeyListener,MouseListener{

	DAOinstituteur d;
	Instituteur Inst;
	ResultSet rs;
	
	
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		
		if(arg.getSource()==this.btn_Ajout_inst)
		{
		  Ajouter();
		}

		if(arg.getSource()==this.btn_clear)
		{
			clear();	
		}

		if(arg.getSource()==this.btn_Mod_inst)
	     {
			
			Modifier();
	     }
		if(arg.getSource()==this.btn_Sup_inst)
		{
			
			Supprimer();
		}
	
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void  Create()
	{
		int cin=Integer.parseInt(this.txt_cin.getText()); 
		Inst=new Instituteur();
        Inst.setCIN(cin);
  	    Inst.setNOM(this.txt_nom.getText());
  	    Inst.setPRENOM(this.txt_prenom.getText());
  	    Inst.setTEL(this.txt_tel.getText());
  	    Inst.setEMAIL(this.txt_email.getText());
  	    Inst.setADRESS(this.txt_adress.getText());
  	    Inst.setDESCRIPTION(this.txt_desc.getText());
  	    Inst.setSPECIAL(this.txt_special.getText());  
  	    
  	    
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
		else  if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez Saisir Des Informations Correct  "
	   				 , " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
		else
			{
			    int cin=Integer.parseInt(this.txt_cin.getText());

				if(d.getById(cin)!=null)
				{
					 JOptionPane.showMessageDialog(null, " Instituteurs Existe Deja  ", " Error", JOptionPane.WARNING_MESSAGE); 
				}
				else if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette Instituteur   ? ")==0)
					{						
                        Create();
						d.Ajouter(Inst);
						UpdateTable();
					    clear();
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
			 JOptionPane.showMessageDialog(null," Veuillez saisi des informations Correct slvp "
					 , " Erreur ", JOptionPane.WARNING_MESSAGE); 
		 }
		 else 
		     {
		    	 int cin=Integer.parseInt(this.txt_cin.getText());
		    	 Instituteur test=d.getById(cin);
		    	 if(test==null)
		    	 {
		    		 JOptionPane.showMessageDialog(null, " Instituteur N'Existe pas ", " Erreur ", JOptionPane.WARNING_MESSAGE); 
				 }

		    	 else  if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifier   cette Instituteur  ? ")==0)
						{
						   Create();		        
						   d.Modifier(Inst);
						   UpdateTable();
						   clear();
						} 
		     }
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	

	@Override
	public void Supprimer()
	{
		int  cin;
		if(All_champs_is_empty()==true)
        {
  	        JOptionPane.showMessageDialog(null, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
        }		
	     else  if(Tester_formlaire()==false)
	     {
	    	 JOptionPane.showMessageDialog(null, "Veuillez saisi des informations Correct slvp"
					 , "Champs Vide ", JOptionPane.WARNING_MESSAGE);  
	     }
         else
	        {
			    cin=Integer.parseInt(this.txt_cin.getText());      
			    Instituteur test=d.getById(cin);	 
			    if(test==null)
			    {
			     JOptionPane.showMessageDialog(null, " Insitituteur n existe pas ");
			    }
			    else if(JOptionPane.showConfirmDialog(null, " Voulez vous supprimer   cette Insitituteur  ? ")==0)
				     {
					   d.Supprimer(cin);
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
	
		 this.txt_cin.setText(String.valueOf(Inst.getCIN()));
		 this.txt_nom.setText(Inst.getNOM());
		 this.txt_prenom.setText(Inst.getPRENOM());
		 this.txt_email.setText(Inst.getEMAIL());
		 this.txt_tel.setText(Inst.getTEL());
		 this.txt_adress.setText(Inst.getADRESS());
		 this.txt_desc.setText(Inst.getDESCRIPTION());
		 this.txt_special.setText(Inst.getSPECIAL());
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void UpdateTable() 
	{
		 rs=d.getAll();
          this.liste_inst.setModel(DbUtils.resultSetToTableModel(rs));		
		
	}
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/



	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		int row =this.liste_inst.getSelectedRow();
		if(row!=-1)
		{
			String  num=  this.liste_inst.getModel().getValueAt(row, 0).toString();
			int n=Integer.parseInt(num);
			
			this.txt_cin.enable(false);
		    Inst=d.getById(n);
		    Consulter();
		}
		
	}
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public boolean Tester_formlaire()
	{

		if(this.lbl_test_cin.getText().equals("")  ==false)
			return false;
		if(this.lbl_test_email.getText().equals("")   ==false)
			return false;
		if(this.lbl_test_nom.getText().equals("")   ==false)
			return false;
		if(this.lbl_test_prenom.getText().equals("")   ==false)
			return false;
		if(this.lbl_test_tel.getText().equals("")   ==false)
			return false;
	
		if(this.txt_nom.getText().equals(""))
			return false;
		if(this.txt_cin.getText().equals(""))
			return false;
		if(this.txt_prenom.getText().equals(""))
			return false;
		
			return true;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public boolean All_champs_is_empty() {
		
		if(this.txt_nom.getText().equals("") && this.txt_cin.getText().equals("") && this.txt_prenom.getText().equals(""))
			return true;
			else
				return false;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@SuppressWarnings("deprecation")
	@Override
	public void clear()
	{
		
		this.txt_cin.setText("");
    	this.txt_nom.setText("");
    	this.txt_prenom.setText("");
    	this.txt_adress.setText("");
    	this.txt_email.setText("");
    	this.txt_tel.setText("");
    	this.txt_desc.setText("");
    	this.txt_special.setText("");
    	this.txt_cin.enable(true);
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
			
			if(nom.matches("[A-Za-z ]*")==true)
			{
				rs =d.Find_ByNom(nom);
			    this.liste_inst.setModel(DbUtils.resultSetToTableModel(rs));
			}
			else
				if(nom.matches("[0-9 ]*")==true)
			{
				int num;
			    num=Integer.parseInt(this.txt_recherche.getText());
			    rs =d.Find_ById(num);
				this.liste_inst.setModel(DbUtils.resultSetToTableModel(rs));
			}
			   else
			  {
				JOptionPane.showMessageDialog(null, "Veuillez saisir numero ou nom  correct ");
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
	
	@Override
	public void keyPressed(KeyEvent arg) 
	{
		if(arg.getSource()!=this.txt_recherche)
		{
			tester_nom_instituteur();
			tester_cin_instituteur();
			tester_prenom_instituteur();
			tester_email_instituteur();
			tester_tel_instituteur();
		}
	
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyReleased(KeyEvent arg) 
	{
		
		if(arg.getSource()!=this.txt_recherche)
		{
			tester_nom_instituteur();
			tester_cin_instituteur();
			tester_prenom_instituteur();
			tester_email_instituteur();
			tester_tel_instituteur();
		}
		
		
		if(arg.getSource()==this.txt_recherche)
		{
			Recherche();
		}
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyTyped(KeyEvent arg) {
		// TODO Auto-generated method stub
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void tester_nom_instituteur()
	{
		if(this.txt_nom.getText().equals(""))
		{
			this.lbl_test_nom.setIcon(null);
			this.  lbl_test_nom.setText(" * ");
		}	
		else 
		     if(this.txt_nom.getText().matches("[A-Za-z]*")==true)
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

	void tester_prenom_instituteur()
	{
		if(this.txt_prenom.getText().equals(""))
		{
			this.lbl_test_prenom.setIcon(null);
			this.  lbl_test_prenom.setText(" * ");
		}	
		else 
		     if(this.txt_prenom.getText().matches("[A-Za-z ]*")==true)
		     {
		         this.  lbl_test_prenom.setText("");
		         this.lbl_test_prenom.setIcon(null);
		     }
            else 
             {
                 this.  lbl_test_prenom.setText("");
                 this.lbl_test_prenom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
              }
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void tester_cin_instituteur()
	{
		if(this.txt_cin.getText().equals(""))
		{
			this.lbl_test_cin.setIcon(null);
		
		}	
		else 
		     if((this.txt_cin.getText().matches("[0-9 ]*")==true) && (this.txt_cin.getText().length()==8))
		     {
		         this.  lbl_test_cin.setText("");
		         this.lbl_test_cin.setIcon(null);
		     }
	        else 
	         {
	             this.  lbl_test_cin.setText("");
	             this.lbl_test_cin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	          }
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void tester_tel_instituteur()
	{
		if(this.txt_tel.getText().equals(""))
		{
			this.lbl_test_tel.setIcon(null);
			 this.  lbl_test_tel.setText("");
		}	
		else 
		     if((this.txt_tel.getText().matches("[0-9 ]*")==true) && (this.txt_tel.getText().length()==8))
		     {
		         this.  lbl_test_tel.setText("");
		         this.lbl_test_tel.setIcon(null);
		     }
	        else 
	         {
	        	 this.  lbl_test_tel.setText("");
	             this.lbl_test_tel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	          }
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

    void tester_email_instituteur()
   {
			if(this.txt_email.getText().equals(""))
			{
				this.lbl_test_email.setText("");
			}	
			else	
			       if( isValidEmailAddress(this.txt_email.getText()))
			       {
			    	      this.  lbl_test_email.setText("");
					       this.lbl_test_email.setIcon(null);
			    	   
			       }				          
			         else
			         {
			        	 this.  lbl_test_email.setText("");
			             this.lbl_test_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
			        	 
			         }
				           
		}
    /*========================================================================================================================*/
	/*============================================   Fin =====================================================================*/
	/*========================================================================================================================*/
		
    public boolean isValidEmailAddress(String email)
    {
			  
	          String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\"
	          		+ ".[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	          java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	          java.util.regex.Matcher m = p.matcher(email);
	          return m.matches();
	          
	  }
		  
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
    private  javax.swing.JButton btn_Ajout_inst;
    private javax.swing.JButton btn_Mod_inst;
    private javax.swing.JButton btn_Sup_inst;
    private javax.swing.JButton btn_clear;
    private javax.swing.JLabel lbl_test_cin;
    private javax.swing.JLabel lbl_test_email;
    private javax.swing.JLabel lbl_test_nom;
    private javax.swing.JLabel lbl_test_prenom;
    private javax.swing.JLabel lbl_test_tel;
    private javax.swing.JTable liste_inst;
    private  javax.swing.JTextField txt_adress;
    private javax.swing.JTextField txt_cin;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prenom;
    private javax.swing.JTextField txt_recherche;
    private javax.swing.JTextField txt_special;
    private javax.swing.JTextField txt_tel;

    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
    
	public Ecouteur_Instituteur(JButton btn_Ajout_inst, JButton btn_Mod_inst, JButton btn_Sup_inst, JButton btn_clear,
			JLabel lbl_test_cin, JLabel lbl_test_email, JLabel lbl_test_nom, JLabel lbl_test_prenom,
			JLabel lbl_test_tel, JTable liste_inst, JTextField txt_adress, JTextField txt_cin, JTextField txt_desc,
			JTextField txt_email, JTextField txt_nom, JTextField txt_prenom, JTextField txt_recherche,
			JTextField txt_special, JTextField txt_tel) {
		super();
		this.btn_Ajout_inst = btn_Ajout_inst;
		this.btn_Mod_inst = btn_Mod_inst;
		this.btn_Sup_inst = btn_Sup_inst;
		this.btn_clear = btn_clear;
		this.lbl_test_cin = lbl_test_cin;
		this.lbl_test_email = lbl_test_email;
		this.lbl_test_nom = lbl_test_nom;
		this.lbl_test_prenom = lbl_test_prenom;
		this.lbl_test_tel = lbl_test_tel;
		this.liste_inst = liste_inst;
		this.txt_adress = txt_adress;
		this.txt_cin = txt_cin;
		this.txt_desc = txt_desc;
		this.txt_email = txt_email;
		this.txt_nom = txt_nom;
		this.txt_prenom = txt_prenom;
		this.txt_recherche = txt_recherche;
		this.txt_special = txt_special;
		this.txt_tel = txt_tel;
		
		d=new DAOinstituteur();
		Inst=new Instituteur();
	}
    
    
    
    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
}
