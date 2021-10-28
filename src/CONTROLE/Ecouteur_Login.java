package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.DAOlogin;

import VUE.Fenetre_Login;
import VUE.Fenetre_Principal;

public class Ecouteur_Login implements ActionListener {

	   private Fenetre_Login fen;
	   private DAOlogin d;
	   
	    /*========================================================================================================================*/
	   	/*========================================= 2) fonction  ================================================*/
	   	/*========================================================================================================================*/
	
	public Ecouteur_Login(Fenetre_Login fen)
	{
		this.fen=fen;
		d=new DAOlogin();
	}
	
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		seconnecter();
		
	}
	
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	void seconnecter()
	{

		@SuppressWarnings("deprecation")
		boolean test= d.seconnectez(fen.txt_login.getText(), fen.txt_pass.getText());
		
		if(test==true)
		{
			     
			  Fenetre_Principal fe=new Fenetre_Principal();
			  fe.setVisible(true);
		      fen.dispose();
		      
		}
		else
		{
			JOptionPane.showMessageDialog(null, "   Mot  de passe ou username incorrect ");
		}
			
	}
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

}
