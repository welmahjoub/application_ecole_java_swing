package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import VUE.Fenetre_Absence;
import VUE.Fenetre_Bultin;
import VUE.Fenetre_Conseil;
import VUE.Fenetre_Eleve;
import VUE.Fenetre_EmploiClass;
import VUE.Fenetre_Emploi_Instit;
import VUE.Fenetre_Instituteur;
import VUE.Fenetre_Matiere;
import VUE.Fenetre_Note;
import VUE.Fenetre_classe;
import VUE.Fenetre_Salle;

public class Ecouteur_fen_Principale implements ActionListener{

	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btn_matiere)
		{
			Activer_Fenetre_matier();
			
		}
	
		if(e.getSource()==this.btn_classe)
		{
			Activer_Fenetre_Classe();
			
		}
		if(e.getSource()==this.btn_salle)
		{
			Activer_Fenetre_Salle();
			
		}
		if(e.getSource()==this.btn_eleve)
		{
			Activer_Fenetre_Eleve();
			
		}
		if(e.getSource()==this.btn_instituteur)
		{
			Activer_Fenetre_Instituteur();
			
		}
		if(e.getSource()==this.btn_emlpoi_classe)
		{
			Activer_Fenetre_EmploiClass();
			
		}
		if(e.getSource()==this.btn_note)
		{
			Activer_Fenetre_Note();
			
		}
		if(e.getSource()==this.btn_Biltin)
		{
			Activer_Fenetre_Bultin();
			
		}
		if(e.getSource()==this.btn_emlpoi_Inst)
		{
			Activer_Fenetre__EmploiInsituteur();
			
		}
		if(e.getSource()==this.btn_conseil)
		{
			Activer_Fenetre_Conseil();
			
		}
	
		if(e.getSource()==this.btn_absence)
		{
			Activer_Fenetre_Absence();
			
		}

	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void Activer_Fenetre_Conseil() 
	{
		
		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_Conseil fec=new Fenetre_Conseil();
		this.desk.add(fec);
		fec.show();
		
	}


	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	private void Activer_Fenetre__EmploiInsituteur()
	{
		
		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_Emploi_Instit fec=new Fenetre_Emploi_Instit();
		this.desk.add(fec);
		fec.show();
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void Activer_Fenetre_Bultin()
	{
		
		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_Bultin fec=new Fenetre_Bultin();
		this.desk.add(fec);
		fec.show();
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void Activer_Fenetre_Note() {
		
		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_Note fec=new Fenetre_Note();
		this.desk.add(fec);
		fec.show();
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void Activer_Fenetre_EmploiClass() {
		
		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_EmploiClass fec=new Fenetre_EmploiClass();
		this.desk.add(fec);
		fec.show();
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	private void Activer_Fenetre_Instituteur() {
		
		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_Instituteur fec=new Fenetre_Instituteur();
		this.desk.add(fec);
		fec.show();
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private void Activer_Fenetre_Salle() {

		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_Salle fec=new Fenetre_Salle();
		this.desk.add(fec);
		fec.show();
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	private void Activer_Fenetre_matier() 
	{
		
		this.desk.removeAll();
		this.desk.repaint();
		
		Fenetre_Matiere fec=new Fenetre_Matiere();
		this.desk.add(fec);
		fec.show();
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	  private void Activer_Fenetre_Classe() {
			
		  this.desk.removeAll();
		  this.desk.repaint();
			
			Fenetre_classe fec=new Fenetre_classe();
			this.desk.add(fec);
			fec.show();
			
		}
	  
	  /*========================================================================================================================*/
	  /*========================================= 2) fonction  ================================================*/
	   /*========================================================================================================================*/
	  
		  private void Activer_Fenetre_Absence() 
		  {
				
			  this.desk.removeAll();
			  this.desk.repaint();
				
				Fenetre_Absence fec=new Fenetre_Absence();
				this.desk.add(fec);
				fec.show();
				
			}
	  
	  /*========================================================================================================================*/
	   	/*========================================= 2) fonction  ================================================*/
	   	/*========================================================================================================================*/
		  
		  private void Activer_Fenetre_Eleve()
		  {
				
			  this.desk.removeAll();
			  this.desk.repaint();
				
				Fenetre_Eleve fec=new Fenetre_Eleve();
				this.desk.add(fec);
				fec.show();
				
			}
		  
	 /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
	
	private javax.swing.JButton btn_Biltin;
    private javax.swing.JButton btn_absence;
    private javax.swing.JButton btn_classe;
    private javax.swing.JButton btn_conseil;
    private javax.swing.JButton btn_eleve;
    private javax.swing.JButton btn_emlpoi_Inst;
    private javax.swing.JButton btn_emlpoi_classe;
    private javax.swing.JButton btn_instituteur;
    private javax.swing.JButton btn_matiere;
    private javax.swing.JButton btn_note;
    private javax.swing.JButton btn_salle;
    private  javax.swing.JDesktopPane desk;
    

    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
    
    
	public Ecouteur_fen_Principale (JButton btn_Biltin, JButton btn_absence, JButton btn_classe, JButton btn_conseil,
			JButton btn_eleve, JButton btn_emlpoi_Inst, JButton btn_emlpoi_classe, JButton btn_instituteur,
			JButton btn_matiere, JButton btn_note, JButton btn_salle, JButton btn_sedeconnecter, JDesktopPane desk)
	{
		super();
		this.btn_Biltin = btn_Biltin;
		this.btn_absence = btn_absence;
		this.btn_classe = btn_classe;
		this.btn_conseil = btn_conseil;
		this.btn_eleve = btn_eleve;
		this.btn_emlpoi_Inst = btn_emlpoi_Inst;
		this.btn_emlpoi_classe = btn_emlpoi_classe;
		this.btn_instituteur = btn_instituteur;
		this.btn_matiere = btn_matiere;
		this.btn_note = btn_note;
		this.btn_salle = btn_salle;
		this.desk = desk;
	}

	 /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
}
