package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import DAO.DAOecole;
import MODEL.Ecole;

public class Ecouteur_Ecole   implements ActionListener, KeyListener  {


	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btn_enregistre)
		Enregistrer_Info_Ecole();
		
		
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	void Enregistrer_Info_Ecole()
	{
		
		
		if(Tester_Formulaire()==false)
			JOptionPane.showMessageDialog(null, " Veuillez saisi des informations Correct slvp");
		else 
			if(JOptionPane.showConfirmDialog(null, " voulez vous enregistre ces information ")==0)
			{
				 
			     ecole.setNom(txt_nom.getText()); 
			     ecole.setAdres(txt_adress.getText()); 
			     ecole.setEmail(txt_email.getText()); 
			     ecole.setFixe(txt_fixe.getText()); 
			     ecole.setDetail(txt_detail.getText()); 
			     ecole.setTel(txt_tel.getText()); 
			     ecole.setCodepost(txt_code_postal.getText());
			     d.enregistre_info(ecole);
   
			}
		        
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	public  void RemplirLesChamps()
	{
	    	
		    list  =new DAOecole(). recuperer_info_from_base_donne();
	    	this.txt_nom.setText(list.get(0));
	    	this.txt_adress.setText(list.get(1));
	    	this.txt_tel.setText(list.get(2));
	    	this.txt_code_postal.setText(list.get(3));
	    	this.txt_fixe.setText(list.get(4));
	    	this.txt_email.setText(list.get(5));
	    	this.txt_detail.setText(list.get(6));	
	    	
	    	
	    }
	
	    /*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/
	 
		@Override
		public void keyPressed(KeyEvent e) 
		{
			 Tester_Nom_Ecole();
			 Tester_Tele_Ecole();
			 Tester_Tel_Fixe_Ecole();
			 tester_Email_Ecole();
			 Tester_Code_Postal_ecole();
			
			
		}

		/*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/
		
		@Override
		public void keyReleased(KeyEvent e)
		{
			 Tester_Nom_Ecole();
			 Tester_Tele_Ecole();
			 Tester_Tel_Fixe_Ecole();
			 tester_Email_Ecole();
			 Tester_Code_Postal_ecole();
			
			 
		}
		
		/*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/

		@Override
		public void keyTyped(KeyEvent e) {}
		
		/*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/
		
		void Tester_Nom_Ecole()
		{
			if(this.txt_nom.getText().equals(""))
			{
				this.lbl_test_nom.setIcon(null);
				this.  lbl_test_nom.setText(" * ");
			}    
			else
			{
				  if(this.txt_nom.getText().matches("[A-Za-z ]*")==true)
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
			         
		}
		
		/*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/
		
		void Tester_Tele_Ecole()
		{
			if(this.txt_tel.getText().equals(""))
			{
				this.lbl_test_tel.setIcon(null);
				this.  lbl_test_tel.setText(" * ");
			}
			else
			   {
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
		}
		
		/*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/
		
		void Tester_Tel_Fixe_Ecole()
		{
			 if(this.txt_fixe.getText().equals(""))
			 {
				 this.lbl_test_fixe.setIcon(null);
				 this.  lbl_test_fixe.setText(" * ");
			 }
			 else
			 {
				 if((this.txt_fixe.getText().matches("[0-9 ]*")==true) && (this.txt_fixe.getText().length()==8))
				 {
					 this.  lbl_test_fixe.setText("");
				      this.lbl_test_fixe.setIcon(null);
				 }
                 else
                 {
            	    this.  lbl_test_fixe.setText("");
                    this.lbl_test_fixe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
                  }
			 }      	
	    }                                   
		
		/*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/
		
		void Tester_Code_Postal_ecole()
		{
			if(this.txt_code_postal.getText().equals(""))
			{
				 this.lbl_test_codepostal.setIcon(null);
				 this.  lbl_test_codepostal.setText(" * ");
			}
			else
			{
				 if((this.txt_code_postal.getText().matches("[0-9 ]*")==true) && (this.txt_code_postal.getText().length()==4))
				 {
					 this.  lbl_test_codepostal.setText("");
				      this.lbl_test_codepostal.setIcon(null);
				 }
	               else 
	               {
	            	   this.  lbl_test_codepostal.setText("");
	                   this.lbl_test_codepostal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png"))); 
	               }          
			}	      
		}
		
		/*========================================================================================================================*/
	   	/*=========================== 1)  Partie Action performenad  ================================================*/
	   	/*========================================================================================================================*/
		
		
		void tester_Email_Ecole()
		{
			if(this.txt_email.getText().equals(""))
			{
				this.lbl_test_email.setIcon(null);
				 this.  lbl_test_email.setText(" * ");
			}
			else
			{
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
			       
		}
		
   /*========================================================================================================================*/
   /*=========================== 1)  Partie Action performenad  ================================================*/
  /*========================================================================================================================*/
		
	 public boolean isValidEmailAddress(String email)
    {
	          String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}"
	          		+ "\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	          
	          java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	          java.util.regex.Matcher m = p.matcher(email);
	          return m.matches();
	   }
		  
	 /*========================================================================================================================*/
     /*=========================== 1)  Partie Action performenad  ================================================*/
    /*========================================================================================================================*/ 
			 
      boolean Tester_Formulaire()
     {

				 if(this.lbl_test_nom.getText().equals("")==false)
					 return false; 
				 if(this.lbl_test_codepostal.getText().equals("")==false)
					 return false; 
				 if(this.lbl_test_email.getText().equals("")==false)
					 return false; 
				 if(this.lbl_test_fixe.getText().equals("")==false)
					 return false; 
				 if(this.lbl_test_tel.getText().equals("")==false)
					 return false; 
				 
				 return true;
				 
	  }
      
	/*========================================================================================================================*/
	/*================================================ Fin  class  ===========================================================*/
	/*========================================================================================================================*/ 
      
      private DAOecole d;
 	  private  LinkedList<String>   list ;
 	  private Ecole  ecole;
 	 
      private javax.swing.JButton btn_enregistre;
      private javax.swing.JLabel lbl_test_codepostal;
      private javax.swing.JLabel lbl_test_email;
      private javax.swing.JLabel lbl_test_fixe;
      private javax.swing.JLabel lbl_test_nom;
      private javax.swing.JLabel lbl_test_tel;
      private javax.swing.JTextField txt_adress;
      private javax.swing.JTextField txt_code_postal;
      private javax.swing.JTextField txt_detail;
      private javax.swing.JTextField txt_email;
      private javax.swing.JTextField txt_fixe;
      private javax.swing.JTextField txt_nom;
      private javax.swing.JTextField txt_tel;


    	/*========================================================================================================================*/
    	/*================================================ Fin  class  ===========================================================*/
    	/*========================================================================================================================*/ 
      
	public Ecouteur_Ecole(Ecole ecole, JButton btn_enregistre, JLabel lbl_test_codepostal, JLabel lbl_test_email,
			JLabel lbl_test_fixe, JLabel lbl_test_nom, JLabel lbl_test_tel, JTextField txt_adress,
			JTextField txt_code_postal, JTextField txt_detail, JTextField txt_email, JTextField txt_fixe,
			JTextField txt_nom, JTextField txt_tel) 
	{
		super();
		this.ecole = ecole;
		this.btn_enregistre = btn_enregistre;
		this.lbl_test_codepostal = lbl_test_codepostal;
		this.lbl_test_email = lbl_test_email;
		this.lbl_test_fixe = lbl_test_fixe;
		this.lbl_test_nom = lbl_test_nom;
		this.lbl_test_tel = lbl_test_tel;
		this.txt_adress = txt_adress;
		this.txt_code_postal = txt_code_postal;
		this.txt_detail = txt_detail;
		this.txt_email = txt_email;
		this.txt_fixe = txt_fixe;
		this.txt_nom = txt_nom;
		this.txt_tel = txt_tel;
		d=new DAOecole();
	}

  	/*========================================================================================================================*/
  	/*================================================ Fin  class  ===========================================================*/
  	/*========================================================================================================================*/ 
   
}
