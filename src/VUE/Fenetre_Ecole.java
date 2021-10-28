package VUE;

import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import CONTROLE.Ecouteur_Ecole;

public class Fenetre_Ecole extends javax.swing.JInternalFrame {

    
	private static final long serialVersionUID = -7935490706097498285L;
	
	Ecouteur_Ecole Myecouteur;
	
	  /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public Fenetre_Ecole() 
	{
		
        initComponents();
        setSize(1000, 480);
      
        evenement();
    }
	
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement()
    {
           
          txt_nom.setFont(new java.awt.Font("Arial", 0, 14)); 
          txt_adress.setFont(new java.awt.Font("Arial", 0, 14)); 
          txt_code_postal.setFont(new java.awt.Font("Arial",0, 14)); 
          txt_detail.setFont(new java.awt.Font("Arial", 0, 14)); 
          txt_tel.setFont(new java.awt.Font("Arial", 0, 14));        
          txt_fixe.setFont(new java.awt.Font("Arial", 0, 14)); 
          txt_email.setFont(new java.awt.Font("Arial", 0, 14)); 
          btn_enregistre.setBackground(new java.awt.Color(204, 204, 255));
          btn_enregistre.setFont(new java.awt.Font("Arial", 0, 14));
          remove_title();
    }
    

 	/*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/ 
    
    void remove_title()
    {

       putClientProperty("fenetre_eleve.isPalette",Boolean.TRUE);
       getRootPane().setWindowDecorationStyle(JRootPane.NONE);
       ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
       this.setBorder(null);
    }
    
    /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/                        
    private void initComponents() {

        panel_ecole = new javax.swing.JPanel();
        lbl_adres = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        lbl_test_codepostal = new javax.swing.JLabel();
        btn_enregistre = new javax.swing.JButton();
        txt_fixe = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_detail = new javax.swing.JTextField();
        txt_code_postal = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_adress = new javax.swing.JTextField();
        lbl_nom = new javax.swing.JLabel();
        lbl_fixe = new javax.swing.JLabel();
        lbl_details = new javax.swing.JLabel();
        lbl_code_postal = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_tel = new javax.swing.JLabel();
        lbl_test_nom = new javax.swing.JLabel();
        lbl_test_tel = new javax.swing.JLabel();
        lbl_test_fixe = new javax.swing.JLabel();
        lbl_test_email = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_ecole.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "    Information Ecole  ", 
        		javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 14))); 
        panel_ecole.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_adres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_adres.setText("Adress : ");
        panel_ecole.add(lbl_adres, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 80, 30));

        txt_tel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_ecole.add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 320, 30));

        lbl_test_codepostal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_ecole.add(lbl_test_codepostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 40, 30));

        btn_enregistre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_enregistre.setText("Enregistrer");
        panel_ecole.add(btn_enregistre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 210, 50));

        txt_fixe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_ecole.add(txt_fixe, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 320, 30));

        txt_email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_ecole.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 320, 30));

        txt_detail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_ecole.add(txt_detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 320, 30));

        txt_code_postal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_ecole.add(txt_code_postal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 320, 30));

        txt_nom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_ecole.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 320, 30));

        txt_adress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_ecole.add(txt_adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 320, 30));

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("Nom :");
        panel_ecole.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 80, 30));

        lbl_fixe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_fixe.setText("Tel Fixe : ");
        panel_ecole.add(lbl_fixe, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 80, 30));

        lbl_details.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_details.setText("Details :");
        panel_ecole.add(lbl_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 80, 30));

        lbl_code_postal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_code_postal.setText("Code Postal :");
        panel_ecole.add(lbl_code_postal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 90, 30));

        lbl_email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_email.setText("Email :");
        panel_ecole.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 80, 30));

        lbl_tel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_tel.setText("Telephone :");
        panel_ecole.add(lbl_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 80, 30));

        lbl_test_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_ecole.add(lbl_test_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 40, 30));

        lbl_test_tel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_ecole.add(lbl_test_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 40, 30));

        lbl_test_fixe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_ecole.add(lbl_test_fixe, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 40, 30));

        lbl_test_email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_ecole.add(lbl_test_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 40, 30));

        getContentPane().add(panel_ecole, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 950, 420));

        pack();
    }                     
  
    /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/  

    public javax.swing.JButton getBtn_enregistre() {
  		return btn_enregistre;
  	}

	public javax.swing.JLabel getLbl_test_codepostal() {
		return lbl_test_codepostal;
	}

	public javax.swing.JLabel getLbl_test_email() {
		return lbl_test_email;
	}
    
	public javax.swing.JLabel getLbl_test_fixe() {
		return lbl_test_fixe;
	}

	public javax.swing.JLabel getLbl_test_nom() {
		return lbl_test_nom;
	}

	public javax.swing.JLabel getLbl_test_tel() {
		return lbl_test_tel;
	}

	public javax.swing.JTextField getTxt_adress() {
		return txt_adress;
	}

	public javax.swing.JTextField getTxt_code_postal() {
		return txt_code_postal;
	}

	public javax.swing.JTextField getTxt_detail() {
		return txt_detail;
	}

	public javax.swing.JTextField getTxt_email() {
		return txt_email;
	}

	public javax.swing.JTextField getTxt_fixe() {
		return txt_fixe;
	}


	public javax.swing.JTextField getTxt_nom() {
		return txt_nom;
	}

	public javax.swing.JTextField getTxt_tel() {
		return txt_tel;
	}
	
	public javax.swing.JLabel getLbl_adres() {
		return lbl_adres;
	}

	public javax.swing.JLabel getLbl_code_postal() {
		return lbl_code_postal;
	}

	public javax.swing.JLabel getLbl_details() {
		return lbl_details;
	}


	public javax.swing.JLabel getLbl_email() {
		return lbl_email;
	}

	public javax.swing.JLabel getLbl_fixe() {
		return lbl_fixe;
	}


	public javax.swing.JLabel getLbl_nom() {
		return lbl_nom;
	}

	public javax.swing.JLabel getLbl_tel() {
		return lbl_tel;
	}

	public javax.swing.JPanel getPanel_ecole() {
		return panel_ecole;
	}

    /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/  
	
	// Variables declaration - do not modify                     
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
    
    private javax.swing.JLabel lbl_adres;
    private javax.swing.JLabel lbl_code_postal;
    private javax.swing.JLabel lbl_details;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_fixe;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JPanel panel_ecole;

    // End of variables declaration  
    /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/  
}
