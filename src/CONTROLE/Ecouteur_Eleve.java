package CONTROLE;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import DAO.DAOeleve;
import MODEL.Eleve;
import net.proteanit.sql.DbUtils;

public class Ecouteur_Eleve extends Ecouteur implements  ActionListener,KeyListener,MouseListener {

	DAOeleve d;
	Eleve e;
	ResultSet rs;
	
	
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	
	/*========================================================================================================================*/
   	/*=========================== 1)  Partie Action performenad  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		
		if(arg.getSource()==btn_parcouri)
		{
			Evenment_Parcourir_Image();
		}
		
		if(arg.getSource()==btn_Ajout)
		{
			Ajouter();

		}

		if(arg.getSource()==btn_clear)
		{
			clear();
			
		}

		if(arg.getSource()==btn_Modifier)
	     {
			Modifier();
	     }
		if(arg.getSource()==btn_Suprimer)
		{
			Supprimer();
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
	   		 JOptionPane.showInternalMessageDialog(null, " Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
	   	 }
				 
	     else  if(Tester_formlaire()==false)
	   	 {
	   		 JOptionPane.showMessageDialog(null, " Veuillez Saisir Des Informations Correct  ", " Error", JOptionPane.WARNING_MESSAGE); 
	   	 }
	    	 else  {
			    		int num=Integer.parseInt(txt_num.getText());
						if(d.getById(num)!=null)
						{
							 JOptionPane.showMessageDialog(null, " Eleve Existe", "Erreur", JOptionPane.WARNING_MESSAGE); 	
						}
						else if(JOptionPane.showConfirmDialog(null, " Voulez vous Ajouter  cette eleve  ? ")==0)
							{
							
				 		        e=Create();
				                d.Ajouter(e);
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
			 JOptionPane.showMessageDialog(null, " Veuillez saisi des informations Correct slvp ", " Erreur "
					 , JOptionPane.WARNING_MESSAGE); 
		 }
		 else 
		 {
	    	 
	    	 int num=Integer.parseInt(txt_num.getText());
	    	 Eleve test=d.getById(num);
	    	 
	    	 if(test==null)
	    	 {
	    		 JOptionPane.showMessageDialog(null, " Eleve N' existe pas ", "Erreur", JOptionPane.WARNING_MESSAGE); 
	    	 }
	    	 else  if(JOptionPane.showConfirmDialog(null, " Voulez vous Modifier   cette eleve  ? ")==0)
					{  
		 		        e=Create();
						d.Modifier(e);
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
        int  num;
		if(All_champs_is_empty()==true)
        {
  	       JOptionPane.showInternalMessageDialog(null, "Veuillez Remplir les champs ", "Champs Vide ", JOptionPane.WARNING_MESSAGE); 
        }
	     else  if(Tester_formlaire()==false)
			 JOptionPane.showMessageDialog(null, "Veuillez saisi des informations Correct slvp", "Champs Vide "
					 , JOptionPane.WARNING_MESSAGE); 
		     else
		    	 {
			    	 num=Integer.parseInt(txt_num.getText());
			    	 Eleve test=d.getById(num);
			    	 
			    	 if(test==null)
			    		 JOptionPane.showMessageDialog(null, " Eleve N'existe pas ", "Erreur", JOptionPane.WARNING_MESSAGE); 
			    	 
			    	 else if(JOptionPane.showConfirmDialog(null, " Voulez vous supprimer   cette eleve  ? ")==0)
				        {
					         d.Supprimer(num); 
					         UpdateTable();
					         clear();
				         }  	    	 
	    	 }
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@SuppressWarnings("deprecation")
	@Override
	public void Consulter()
	{

		   txt_num.setText(String.valueOf(e.getNum()));
		   txt_num.enable(false);
		   txt_nom.setText(e.getNom());
		   txt_prenom.setText(e.getPrenom());
		   txt_lieu_nais.setText(e.getLieu_nais());
		   txt_adres.setText(e.getAdress());
		   txt_cin_pere.setText(e.getCin_pere());
		   txt_nom_pere.setText(e.getNom_pere());
		   txt_adres_pere.setText(e.getAdress_pere());
		   txt_tel_pere.setText(e.getTel_pere());
		   txt_cin_mere.setText(e.getCin_mere());
		   txt_nom_mere.setText(e.getNom_mere());
		   txt_adres_mere.setText(e.getAdress_mere());
		   txt_tel_mere.setText(e.getTel_mere());
		   cmb_niveau.setSelectedIndex(e.getNIVEAU()-1);
		  
		  if(e.getSexe().equals("Garçon"))
			   cmb_sexe.setSelectedIndex(0);
		  else
			 cmb_sexe.setSelectedIndex(1);
		  
		    if((e.getDate_insc().equals("")==false) &&( e.getDate_nais().equals("")==false))
	        {
		           SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		        try {
	
		        		java.util.Date datnais = formatter.parse(e.getDate_nais());
		 	            java.util.Date datinsc = formatter.parse(e.getDate_insc());
	
		 	            txt_date_insc.setDate(datinsc);
		 	             txt_dat_nais.setDate(datnais);
	  
		            } catch (ParseException d) {
		               System.out.println(" erreur convertion date  ");
	
		          }
	        }
		  
		  if(e.getImage()!=null)
		  {
			  try {
			    	
			    	int blobLength = (int) e.getImage().length();  
			    	byte[] blobAsBytes = e.getImage().getBytes(1, blobLength);
			    	e.getImage().free();
					ImageIcon m=new ImageIcon(blobAsBytes);
					Image img=m.getImage();
		        	Image newImage=img.getScaledInstance(lbl_photo_elev.getWidth(),lbl_photo_elev.getHeight(),Image.SCALE_SMOOTH);
		        	ImageIcon iconFinal=new ImageIcon(newImage);
		        	lbl_photo_elev.setIcon(iconFinal);
		
				} catch (Exception e1) {
					System.out.println(" erreur au convertion imgae  ");
				}
			     
		  }
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void UpdateTable() 
	{
		
		 rs=new DAOeleve().getAll();	
		 if(rs!=null)
         liste_eleve.setModel(DbUtils.resultSetToTableModel(rs));
	}

	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Recherche() 
	{
		int num;
		String nom;

		if(txt_recherche.getText().equals("")==false)
		{
			nom=txt_recherche.getText();
			
			if(nom.matches("[A-Za-z ]*")==true)
			{
				rs =new DAOeleve().Find_ByNom(nom);
			}
			if(nom.matches("[0-9 ]*")==true)
			{
			    num=Integer.parseInt(txt_recherche.getText()); 
				rs =new DAOeleve().Find_ById(num);		
			}
				
		     if(rs!=null)	
			 liste_eleve.setModel(DbUtils.resultSetToTableModel(rs));
			   else
			  {
				 liste_eleve.setModel(new javax.swing.table.DefaultTableModel(
				   new Object [][] { },new String [] {"Num", "Nom", "Niveau" } )); }
		}
		else
		{
			UpdateTable();
		}
		
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	public Eleve Create()
	{
		
		int niveau=cmb_niveau.getSelectedIndex()+1;
		
		e=new Eleve();
	    e.setNum(Integer.parseInt(txt_num.getText())); 
	    e.setDate_insc(((JTextField)txt_date_insc.getDateEditor()).getText());
  	    e.setNom(txt_nom.getText());
  	    e.setPrenom(txt_prenom.getText());
  	    e.setDate_nais(((JTextField)txt_dat_nais.getDateEditor()).getText());
  	    e.setLieu_nais(txt_lieu_nais.getText());
  	    e.setSexe(cmb_sexe.getSelectedItem().toString());
  	    e.setAdress(txt_adres.getText());
  	    e.setCin_pere(txt_cin_pere.getText());
  	    e.setNom_pere(txt_nom_pere.getText());
  	    e.setAdress_pere(txt_adres_pere.getText());
  	    e.setTel_pere(txt_tel_pere.getText());
  	    e.setCin_mere(txt_cin_mere.getText());
  	    e.setNom_mere(txt_nom_mere.getText());
  	    e.setAdress_mere(txt_adres_mere.getText());
  	    e.setTel_mere(txt_tel_mere.getText());
  	    e.setNIVEAU(niveau);
  	    e.setPath(path);

			
		return e;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public void  Evenment_Parcourir_Image()
    {
  	  JFileChooser file=new JFileChooser ();
  	  FileNameExtensionFilter filter=new FileNameExtensionFilter ("IMAGE","jpg","png","gif");
  	  file.setCurrentDirectory(new File("C:\\Users\\pc mahjoub\\Downloads\\Mahjoub\\photo java"));
  	  file.setApproveButtonText("ajouter une image");
  	  file.setApproveButtonText("ajouter une image");
  	  file.addChoosableFileFilter(filter);
  	  
  	  int r=  file.showOpenDialog(null);

  	  if(r==0)
  	  {
  		  File f=file.getSelectedFile();
      	  
      	  path=f.getAbsolutePath();
      	
      	  
      	  ImageIcon m=new ImageIcon(path);
      	  
      	  Image img=m.getImage();
      	  Image newImage=img.getScaledInstance(lbl_photo_elev.getWidth(),lbl_photo_elev.getHeight(),Image.SCALE_SMOOTH);

      	  ImageIcon iconFinal=new ImageIcon(newImage);
      	  
      	  
      	  lbl_photo_elev.setIcon(iconFinal);
  	  }
  	
  	
     }

	/*========================================================================================================================*/
   	/*================================ 2) Partie Mouse Listener sur tableau   ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void mouseClicked(MouseEvent arg)
	{
		int row =liste_eleve.getSelectedRow();
		if(row!=-1)
		{
			String  num=  liste_eleve.getModel().getValueAt(row, 0).toString();
			
			int n=Integer.parseInt(num);
		
		    e=d.getById(n);
		     Consulter();
		}

		
	}

	/*========================================================================================================================*/
   	/*==============================================  4 ) Partie Key listener ================================================*/
   	/*========================================================================================================================*/
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource()!=txt_recherche)
		{
			tester_nom_eleve();
		    tester_num_eleve();
		    tester_prenom_eleve();
		    tester_tel_Pere();
		    tester_cin_Pere();
		    tester_tel_Mere();
		    tester_cin_Mere();
		    test_date_nais();
		    test_date_inscription();
		    test_date_nais();
		    tester_nom_mere();
		    tester_nom_pere();
		}
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getSource()==txt_recherche)
		{
			Recherche();
		}
		
		if(arg0.getSource()!=txt_recherche)
		{
			tester_nom_eleve();
		    tester_num_eleve();
		    tester_prenom_eleve();
		    tester_tel_Pere();
		    tester_cin_Pere();
		    tester_tel_Mere();
		    tester_cin_Mere();
		    test_date_nais();
		    test_date_inscription();
		    test_date_nais();
		    tester_nom_mere();
		    tester_nom_pere();
		}
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void keyTyped(KeyEvent arg0) {}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@SuppressWarnings("deprecation")
	@Override
	public void clear() 
	{
		
		txt_num.enable(true);
    	txt_num.setText("");
    	txt_nom.setText("");
    	txt_prenom.setText("");
        txt_dat_nais.setDate(null);
	    txt_date_insc.setDate(null);
    	txt_lieu_nais.setText("");
    	txt_adres.setText("");
    	txt_cin_pere.setText("");
    	txt_nom_pere.setText("");
    	txt_adres_pere.setText("");
    	txt_tel_pere.setText("");
    	txt_cin_mere.setText("");
    	txt_nom_mere.setText("");
    	txt_tel_mere.setText("");
    	txt_adres_mere.setText("");
    	
    	lbl_test_cin_mere.setText("");
    	lbl_test_cin_mere.setText("");
    	lbl_test_cin_pere.setText("");
    	lbl_test_nom_pere.setText("");
    	lbl_test_nom_mere.setText("");
    	lbl_test_cin_mere.setText("");
    	lbl_test_dat_nais.setText("");
    	lbl_test_num.setText("");
    	lbl_test_nom.setText("");
    	lbl_test_date_insc.setText("");
    	lbl_test_prenom.setText(""); 
    	
    	cmb_niveau.setSelectedIndex(0);
    	
         path="C:\\Users\\pc mahjoub\\Downloads\\Mahjoub\\photo java\\eleve.png";
        lbl_photo_elev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eleve.png")));

	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public boolean Tester_formlaire() 
	{
		
		if(lbl_test_cin_mere.getText().equals("")  ==false)
			return false;
		if(lbl_test_cin_pere.getText().equals("")   ==false)
			return false;
		if(lbl_test_nom_mere.getText().equals("")   ==false)
			return false;
		if(lbl_test_nom_mere.getText().equals("")   ==false)
			return false;
		if(lbl_test_tel_mere.getText().equals("")   ==false)
			return false;
		if(lbl_test_tel_pere.getText().equals("")   ==false)
			return false;
		if(lbl_test_nom.getText().equals("")   ==false)
			return false;
		if(lbl_test_num.getText().equals("")   ==false)
			return false;
		if(lbl_test_prenom.getText().equals("")   ==false)
			return false;
		
		if(txt_nom.getText().equals(""))
			return false;
		if(txt_num.getText().equals(""))
			return false;
		if(txt_prenom.getText().equals(""))
			return false;
	
		
		String Dateinsc=((JTextField)txt_date_insc.getDateEditor()).getText();
		String Datenais=((JTextField)txt_dat_nais.getDateEditor()).getText();
		
		if(date_valide(Datenais)==false)
			return false;
		
		if(date_valide(Dateinsc)==false)
			return false;
		
			return true;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public boolean All_champs_is_empty() {
		
		
		if(txt_nom.getText().equals("") && txt_num.getText().equals("") && txt_prenom.getText().equals(""))
			return true;
			else
				return false;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void tester_nom_eleve()
	{
		
		if(txt_nom.getText().equals(""))
		{
			lbl_test_nom.setIcon(null);
			 lbl_test_nom.setText(" * ");
		}	
		else{ 
			     if(txt_nom.getText().matches("[A-Za-z]*")==true)
			     {
			          lbl_test_nom.setText("");
			        lbl_test_nom.setIcon(null);
			     }
	            else 
	             {
	                   lbl_test_nom.setText("");
	                 lbl_test_nom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	              }
		}        	
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void tester_prenom_eleve()
	{
		if(txt_prenom.getText().equals(""))
		{
			lbl_test_prenom.setIcon(null);
			 lbl_test_prenom.setText(" * ");
		}	
		else {
			     if(txt_prenom.getText().matches("[A-Za-z ]*")==true)
			     {
			          lbl_test_prenom.setText("");
			         lbl_test_prenom.setIcon(null);
			     }
	            else 
	             {
	                  lbl_test_prenom.setText("");
	                 lbl_test_prenom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	              }
		  }
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void tester_nom_pere()
	{
		if(txt_nom_pere.getText().equals(""))
		{
			lbl_test_nom_pere.setIcon(null);
			  lbl_test_nom_pere.setText("");
		}	
		else{
		
			if(txt_nom_pere.getText().matches("[A-Za-z ]*")==true)
		     {
		          lbl_test_nom_pere.setText("");
		         lbl_test_nom_pere.setIcon(null);
		     }
           else 
            {
                  lbl_test_nom_pere.setText("");
               lbl_test_nom_pere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
             }
		}
		     
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void tester_nom_mere()
	{
		if(txt_nom_mere.getText().equals(""))
		{
			lbl_test_nom_mere.setIcon(null);
			    lbl_test_nom_mere.setText("");
		}	
		else {
			if(txt_nom_mere.getText().matches("[A-Za-z ]*")==true)
		     {
		           lbl_test_nom_mere.setText("");
		         lbl_test_nom_mere.setIcon(null);
		     }
           else 
            {
                 lbl_test_nom_mere.setText("");
                lbl_test_nom_mere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
             }
		}
		     
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void tester_num_eleve()
	{
		
		if(txt_num.getText().equals(""))
		{
			lbl_test_num.setIcon(null);
			 lbl_test_num.setText(" * ");
		}	
		else  {
			if(txt_num.getText().matches("[0-9 ]*")==true)
		     {
		           lbl_test_num.setText("");
		       lbl_test_num.setIcon(null);
		     }
           else 
            {
                 lbl_test_num.setText("");
                lbl_test_num.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
             }
		}
		     
		
	}
	
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void tester_tel_Pere()
	{
		if(txt_tel_pere.getText().equals(""))
		{
			lbl_test_tel_pere.setIcon(null);
			  lbl_test_tel_pere.setText("");
		}	
		else {
			 if((txt_tel_pere.getText().matches("[0-9 ]*")==true) && (txt_tel_pere.getText().length()==8))
		     {
		           lbl_test_tel_pere.setText("");
		         lbl_test_tel_pere.setIcon(null);
		     }
	        else 
	         {
	               lbl_test_tel_pere.setText("");
	             lbl_test_tel_pere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	          }
		}
		    
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

 
	void tester_cin_Pere()
	{
		if(txt_cin_pere.getText().equals(""))
		{
			lbl_test_cin_pere.setIcon(null);
			  lbl_test_cin_pere.setText("");
		}	
		else {
		     if((txt_cin_pere.getText().matches("[0-9 ]*")==true) && (txt_cin_pere.getText().length()==8))
		     {
		        lbl_test_cin_pere.setText("");
		       lbl_test_cin_pere.setIcon(null);
		     }
	        else 
	         {
	             lbl_test_cin_pere.setText("");
	             lbl_test_cin_pere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	          }
		}
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	
	void tester_cin_Mere()
	{
		if(txt_cin_mere.getText().equals(""))
		{
			lbl_test_cin_mere.setIcon(null);
			 lbl_test_cin_mere.setText("");
		}	
		else {
			 if((txt_cin_mere.getText().matches("[0-9 ]*")==true) && (txt_cin_mere.getText().length()==8))
		     {
		       lbl_test_cin_mere.setText("");
		         lbl_test_cin_mere.setIcon(null);
		     }
	        else 
	         {
	            lbl_test_cin_mere.setText("");
	            lbl_test_cin_mere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	          }
		  }
		    
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	void tester_tel_Mere()
	{
		if(txt_tel_mere.getText().equals(""))
		{
			lbl_test_tel_mere.setIcon(null);
			lbl_test_tel_mere.setText("");
		}	
		else {
			
			 if((txt_tel_mere.getText().matches("[0-9 ]*")==true) && (txt_tel_mere.getText().length()==8))
		     {
		        lbl_test_tel_mere.setText("");
		        lbl_test_tel_mere.setIcon(null);
		     }
	        else 
	         {
	            lbl_test_tel_mere.setText("");
	             lbl_test_tel_mere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png")));
	          }
		}	    
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	void test_date_inscription()
	{
	
		String Dateinsc=((JTextField)txt_date_insc.getDateEditor()).getText();

		if(Dateinsc.equals(""))
		{
			 lbl_test_date_insc.setText("  * ");
			lbl_test_date_insc.setIcon(null);
		}
		else {
			  if(date_valide(Dateinsc)==true) 
			  {
				 lbl_test_date_insc.setText("");
			     lbl_test_date_insc.setIcon(null);
			  }	  
	           else 
	               {
	        	       lbl_test_date_insc.setText("");
		              lbl_test_date_insc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png"))); 
	               }  
		  }			 
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	void test_date_nais()
	{
		String Date_nais=((JTextField)txt_dat_nais.getDateEditor()).getText();
		
		if(Date_nais.equals(""))
		{
			 lbl_test_dat_nais.setText("  * ");
			lbl_test_dat_nais.setIcon(null);
		}	
		else{
			  if(date_valide(Date_nais)==true) 
			  {
				 lbl_test_dat_nais.setText("");
			  }	  
	           else {
	        	      lbl_test_dat_nais.setText("");
		               lbl_test_dat_nais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/er.png"))); 
	                 }	
			}		     	 
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	boolean date_valide(String date)
	{
		String DATE_FORMAT="dd-MM-yyyy";
		
		try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {    return false; }
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	

	/* "1ere Anne", "2eme Anne", "3eme Anne", "4eme Anne", "5eme Anne", "6eme Anne"*/
	String Niveau(int id_niv)
	{
		if(id_niv==1)
			return "1ere Anne";
		if(id_niv==2)
			return "2eme Anne";
		if(id_niv==3)
			return "3eme Anne";
		if(id_niv==4)
			return "4eme Anne";
		if(id_niv==5)
			return "5eme Anne";
		if(id_niv==6)
			return "6eme Anne";
		
			return "1ere Anne";
		
	}
	/*========================================================================================================================*/
   	/*========================================= fin                           ================================================*/
   	/*========================================================================================================================*/
	
    private String path;
    private javax.swing.JTextField txt_adres;
    private javax.swing.JTextField txt_adres_mere;
    private javax.swing.JTextField txt_adres_pere;
    private javax.swing.JTextField txt_cin_mere;
    private javax.swing.JTextField txt_cin_pere;
    private com.toedter.calendar.JDateChooser txt_dat_nais;
    private com.toedter.calendar.JDateChooser txt_date_insc;
    private javax.swing.JTextField txt_lieu_nais;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_nom_mere;
    private javax.swing.JTextField txt_nom_pere;
    private javax.swing.JTextField txt_num;
    private javax.swing.JTextField txt_prenom;
    private javax.swing.JTextField txt_recherche;
    private javax.swing.JTextField txt_tel_mere;
    private javax.swing.JTextField txt_tel_pere;
    private javax.swing.JButton btn_Ajout;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_Modifier;
    private javax.swing.JButton btn_parcouri;
    private javax.swing.JButton btn_Suprimer;
    private javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JComboBox<String> cmb_sexe;
    private javax.swing.JLabel lbl_photo_elev;
    private javax.swing.JLabel lbl_test_cin_mere;
    private javax.swing.JLabel lbl_test_cin_pere;
    private javax.swing.JLabel lbl_test_dat_nais;
    private javax.swing.JLabel lbl_test_date_insc;
    private javax.swing.JLabel lbl_test_nom;
    private javax.swing.JLabel lbl_test_nom_mere;
    private javax.swing.JLabel lbl_test_nom_pere;
    private javax.swing.JLabel lbl_test_num;
    private javax.swing.JLabel lbl_test_prenom;
    private javax.swing.JLabel lbl_test_tel_mere;
    private javax.swing.JLabel lbl_test_tel_pere;
    private javax.swing.JTable liste_eleve;

		/*========================================================================================================================*/
	   	/*========================================= fin                           ================================================*/
	   	/*========================================================================================================================*/

		public Ecouteur_Eleve(JTextField txt_adres, JTextField txt_adres_mere, JTextField txt_adres_pere,
				JTextField txt_cin_mere, JTextField txt_cin_pere, JDateChooser txt_dat_nais, JDateChooser txt_date_insc,
				JTextField txt_lieu_nais, JTextField txt_nom, JTextField txt_nom_mere, JTextField txt_nom_pere,
				JTextField txt_num, JTextField txt_prenom, JTextField txt_recherche, JTextField txt_tel_mere,
				JTextField txt_tel_pere, JTabbedPane jtable, JButton btn_Ajout, JButton btn_clear, JButton btn_Modifier,
				JButton btn_parcouri, JButton btn_Suprimer, JComboBox<String> cmb_niveau, JComboBox<String> cmb_sexe,
				JLabel lbl_photo_elev, JLabel lbl_test_cin_mere, JLabel lbl_test_cin_pere, JLabel lbl_test_dat_nais,
				JLabel lbl_test_date_insc, JLabel lbl_test_nom, JLabel lbl_test_nom_mere, JLabel lbl_test_nom_pere,
				JLabel lbl_test_num, JLabel lbl_test_prenom, JLabel lbl_test_tel_mere, JLabel lbl_test_tel_pere,
				JTable liste_eleve, JPanel panel_info_eleve, JPanel panel_list_elev, String path) {
			super();
			this.txt_adres = txt_adres;
			this.txt_adres_mere = txt_adres_mere;
			this.txt_adres_pere = txt_adres_pere;
			this.txt_cin_mere = txt_cin_mere;
			this.txt_cin_pere = txt_cin_pere;
			this.txt_dat_nais = txt_dat_nais;
			this.txt_date_insc = txt_date_insc;
			this.txt_lieu_nais = txt_lieu_nais;
			this.txt_nom = txt_nom;
			this.txt_nom_mere = txt_nom_mere;
			this.txt_nom_pere = txt_nom_pere;
			this.txt_num = txt_num;
			this.txt_prenom = txt_prenom;
			this.txt_recherche = txt_recherche;
			this.txt_tel_mere = txt_tel_mere;
			this.txt_tel_pere = txt_tel_pere;
			this.btn_Ajout = btn_Ajout;
			this.btn_clear = btn_clear;
			this.btn_Modifier = btn_Modifier;
			this.btn_parcouri = btn_parcouri;
			this.btn_Suprimer = btn_Suprimer;
			this.cmb_niveau = cmb_niveau;
			this.cmb_sexe = cmb_sexe;
			this.lbl_photo_elev = lbl_photo_elev;
			this.lbl_test_cin_mere = lbl_test_cin_mere;
			this.lbl_test_cin_pere = lbl_test_cin_pere;
			this.lbl_test_dat_nais = lbl_test_dat_nais;
			this.lbl_test_date_insc = lbl_test_date_insc;
			this.lbl_test_nom = lbl_test_nom;
			this.lbl_test_nom_mere = lbl_test_nom_mere;
			this.lbl_test_nom_pere = lbl_test_nom_pere;
			this.lbl_test_num = lbl_test_num;
			this.lbl_test_prenom = lbl_test_prenom;
			this.lbl_test_tel_mere = lbl_test_tel_mere;
			this.lbl_test_tel_pere = lbl_test_tel_pere;
			this.liste_eleve = liste_eleve;
			
			this.path = path;
			
			  d=new DAOeleve();
				e=new Eleve();
		}
		/*========================================================================================================================*/
	   	/*========================================= fin                           ================================================*/
	   	/*========================================================================================================================*/
}
