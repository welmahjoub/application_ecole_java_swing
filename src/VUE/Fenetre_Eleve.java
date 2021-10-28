package VUE;

import javax.swing.JRootPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Eleve;

public class Fenetre_Eleve extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = -6490979115239159244L;
	
    public Fenetre_Eleve() {
        initComponents();
        setSize(1000, 480);
        Evenement();
    }
    
    Ecouteur_Eleve MyEcouteur;
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void Evenement()
	{
    	         MyEcouteur=new Ecouteur_Eleve(txt_adres, txt_adres_mere, txt_adres_pere
    			, txt_cin_mere, txt_cin_pere, txt_dat_nais, txt_date_insc, txt_lieu_nais,
    			txt_nom, txt_nom_mere, txt_nom_pere, txt_num, txt_prenom, txt_recherche,
    			txt_tel_mere, txt_tel_pere,Jtable, btn_Ajout, btn_clear, btn_Modifier,
    			btn_parcouri, btn_Suprimer, cmb_niveau, cmb_sexe, lbl_photo_elev,
    			lbl_test_cin_mere, lbl_test_cin_pere, lbl_test_dat_nais, lbl_test_date_insc, 
    			lbl_test_nom, lbl_test_nom_mere, lbl_test_nom_pere, lbl_test_num, lbl_test_prenom,
    			lbl_test_tel_mere, lbl_test_tel_pere, liste_eleve, panel_info_eleve, panel_list_elev, path);
		   
    			liste_eleve.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	
	        liste_eleve.getTableHeader().setReorderingAllowed(false);
	        liste_eleve.getTableHeader().setResizingAllowed(false);
	        liste_eleve.setDefaultEditor(Object.class,null);
	        
	       btn_Modifier.addActionListener(MyEcouteur);
	       btn_parcouri.addActionListener(MyEcouteur);
	       btn_Ajout.addActionListener(MyEcouteur);
	       btn_Suprimer.addActionListener(MyEcouteur);
	       btn_clear.addActionListener(MyEcouteur);

	       txt_nom.addKeyListener(MyEcouteur);        
	       txt_recherche.addKeyListener(MyEcouteur);
	       txt_num.addKeyListener(MyEcouteur);
	       txt_cin_mere.addKeyListener(MyEcouteur);
	       txt_cin_pere.addKeyListener(MyEcouteur);
	       txt_tel_mere.addKeyListener(MyEcouteur);
	       txt_nom.addKeyListener(MyEcouteur);
	       txt_prenom.addKeyListener(MyEcouteur);
	       txt_dat_nais.addKeyListener(MyEcouteur);
	       txt_date_insc.addKeyListener(MyEcouteur);
	       
	       txt_lieu_nais.addKeyListener(MyEcouteur);
	      
	       txt_adres.addKeyListener(MyEcouteur);
	        txt_nom_mere.addKeyListener(MyEcouteur);
	        txt_nom_pere.addKeyListener(MyEcouteur);
	       
	       txt_tel_pere.addKeyListener(MyEcouteur);
	       
	       liste_eleve.addMouseListener(MyEcouteur);
	       
	       txt_date_insc.setDateFormatString("dd-MM-yyyy"); 
	       txt_dat_nais.setDateFormatString("dd-MM-yyyy");
	       
	       /*  met image par default */
	        
	        path="C:\\Users\\pc mahjoub\\Downloads\\Mahjoub\\photo java\\eleve.png";

	        lbl_photo_elev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eleve.png")));
	        
	        /*  met image par default */

	        remove_title();
	        MyEcouteur.UpdateTable();
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

        panel_list_elev = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liste_eleve = new javax.swing.JTable();
        txt_recherche = new javax.swing.JTextField();
        lbl_Image_recherche = new javax.swing.JLabel();
        panel_operation = new javax.swing.JPanel();
        btn_Modifier = new javax.swing.JButton();
        btn_Suprimer = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_Ajout = new javax.swing.JButton();
        Jtable = new javax.swing.JTabbedPane();
        panel_info_eleve = new javax.swing.JPanel();
        txt_prenom = new javax.swing.JTextField();
        lbl_date_nais = new javax.swing.JLabel();
        txt_num = new javax.swing.JTextField();
        txt_dat_nais = new com.toedter.calendar.JDateChooser();
        txt_date_insc = new com.toedter.calendar.JDateChooser();
        lbl_nom = new javax.swing.JLabel();
        lbl_insc = new javax.swing.JLabel();
        lbl_date_insc = new javax.swing.JLabel();
        lbl_sexe = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        cmb_sexe = new javax.swing.JComboBox<>();
        lbl_niveau = new javax.swing.JLabel();
        txt_lieu_nais = new javax.swing.JTextField();
        txt_adres = new javax.swing.JTextField();
        lbl_photo_elev = new javax.swing.JLabel();
        cmb_niveau = new javax.swing.JComboBox<>();
        lbl_test_date_insc = new javax.swing.JLabel();
        lbl_test_nom = new javax.swing.JLabel();
        lbl_test_prenom = new javax.swing.JLabel();
        lbl_test_dat_nais = new javax.swing.JLabel();
        lbl_test_num = new javax.swing.JLabel();
        lbl_lieu_nais = new javax.swing.JLabel();
        lbl_adress = new javax.swing.JLabel();
        lbl_prenom = new javax.swing.JLabel();
        btn_parcouri = new javax.swing.JButton();
        panel_parents = new javax.swing.JPanel();
        txt_nom_mere = new javax.swing.JTextField();
        txt_tel_pere = new javax.swing.JTextField();
        txt_adres_pere = new javax.swing.JTextField();
        txt_nom_pere = new javax.swing.JTextField();
        lbl_tel_mere = new javax.swing.JLabel();
        lbl_adress_mere = new javax.swing.JLabel();
        lbl_cin_mere = new javax.swing.JLabel();
        lbl_mere = new javax.swing.JLabel();
        lbl_pere = new javax.swing.JLabel();
        lbl_test_tel_pere = new javax.swing.JLabel();
        lbl_test_nom_mere = new javax.swing.JLabel();
        lbl_cin_pere = new javax.swing.JLabel();
        lbl_nom_mere = new javax.swing.JLabel();
        txt_cin_pere = new javax.swing.JTextField();
        lbl_nom_pere = new javax.swing.JLabel();
        lbl_test_cin_pere = new javax.swing.JLabel();
        txt_tel_mere = new javax.swing.JTextField();
        txt_adres_mere = new javax.swing.JTextField();
        txt_cin_mere = new javax.swing.JTextField();
        lbl_tel_pere = new javax.swing.JLabel();
        lbl_adres_pere = new javax.swing.JLabel();
        lbl_test_nom_pere = new javax.swing.JLabel();
        lbl_test_tel_mere = new javax.swing.JLabel();
        lbl_adres_mere = new javax.swing.JLabel();
        lbl_test_cin_mere = new javax.swing.JLabel();
        lbl_adress_pere = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_list_elev.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Eleves  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_elev.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        liste_eleve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Num", "Nom", "Niveau"
            }
        ));
        liste_eleve.setRowHeight(20);
        liste_eleve.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       
        jScrollPane1.setViewportView(liste_eleve);

        panel_list_elev.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, 330));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_list_elev.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 30));

        lbl_Image_recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_list_elev.add(lbl_Image_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 50, 30));

        getContentPane().add(panel_list_elev, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 430));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));
        panel_operation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Modifier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mod.png"))); // NOI18N
        btn_Modifier.setText("Modifier");
        panel_operation.add(btn_Modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 135, 50));

        btn_Suprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Suprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sup.png"))); // NOI18N
        btn_Suprimer.setText("Supprimer");
        panel_operation.add(btn_Suprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 135, 50));

        btn_clear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        btn_clear.setText("Clear");
       
        panel_operation.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 135, 50));

        btn_Ajout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        btn_Ajout.setText("Ajouter");
        panel_operation.add(btn_Ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 135, 50));

        getContentPane().add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 630, 90));

        panel_info_eleve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_prenom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_info_eleve.add(txt_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 150, 30));

        lbl_date_nais.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_date_nais.setText("Date Naissance :");
        panel_info_eleve.add(lbl_date_nais, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 30));

        txt_num.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_info_eleve.add(txt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 150, 30));
        panel_info_eleve.add(txt_dat_nais, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 150, 30));
        panel_info_eleve.add(txt_date_insc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 150, 30));

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("Nom :");
        panel_info_eleve.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 30));

        lbl_insc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_insc.setText("N° Inscription :");
        panel_info_eleve.add(lbl_insc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        lbl_date_insc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_date_insc.setText("Date Inscription :");
        panel_info_eleve.add(lbl_date_insc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        lbl_sexe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_sexe.setText("Sexe : ");
        panel_info_eleve.add(lbl_sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 60, 30));

        txt_nom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_info_eleve.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 150, 30));

        cmb_sexe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmb_sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garçon", "Fille" }));
        panel_info_eleve.add(cmb_sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 150, 30));

        lbl_niveau.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_niveau.setText("Niveau : ");
        panel_info_eleve.add(lbl_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 60, 30));

        txt_lieu_nais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_info_eleve.add(txt_lieu_nais, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 150, 30));

        txt_adres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_info_eleve.add(txt_adres, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 150, 30));

        lbl_photo_elev.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_info_eleve.add(lbl_photo_elev, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 150, 110));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmb_niveau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ere Anne", "2eme Anne", "3eme Anne", "4eme Anne", "5eme Anne", "6eme Anne" }));
        panel_info_eleve.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 150, 30));

        lbl_test_date_insc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_info_eleve.add(lbl_test_date_insc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 40, 30));

        lbl_test_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_info_eleve.add(lbl_test_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 40, 30));

        lbl_test_prenom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_info_eleve.add(lbl_test_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 40, 30));

        lbl_test_dat_nais.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_info_eleve.add(lbl_test_dat_nais, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 40, 30));

        lbl_test_num.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_info_eleve.add(lbl_test_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 40, 30));

        lbl_lieu_nais.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_lieu_nais.setText("Lieu  Naissance :");
        panel_info_eleve.add(lbl_lieu_nais, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 110, 30));

        lbl_adress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_adress.setText("Adress :");
        panel_info_eleve.add(lbl_adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 60, 30));

        lbl_prenom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_prenom.setText("Prenom :");
        panel_info_eleve.add(lbl_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 30));

        btn_parcouri.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_parcouri.setText("Parcourir");
        panel_info_eleve.add(btn_parcouri, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 150, 30));

        Jtable.addTab("    Information Personnel  ", panel_info_eleve);

        panel_parents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nom_mere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_nom_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 150, 30));

        txt_tel_pere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_tel_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 150, 30));

        txt_adres_pere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_adres_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 150, 30));

        txt_nom_pere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_nom_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 150, 30));

        lbl_tel_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_tel_mere.setText("Telephone : ");
        panel_parents.add(lbl_tel_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 80, 30));

        lbl_adress_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_adress_mere.setText("Adress :");
        panel_parents.add(lbl_adress_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 60, 30));

        lbl_cin_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_cin_mere.setText("Cin : ");
        panel_parents.add(lbl_cin_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 50, 30));

        lbl_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_mere.setText("Mere :");
        panel_parents.add(lbl_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, 30));

        lbl_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_pere.setText("Pere :");
        panel_parents.add(lbl_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 30));

        lbl_test_tel_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        
        panel_parents.add(lbl_test_tel_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, 30));

        lbl_test_nom_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
     
        panel_parents.add(lbl_test_nom_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 30, 30));

        lbl_cin_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_cin_pere.setText("Cin : ");
        panel_parents.add(lbl_cin_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 30));

        lbl_nom_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom_mere.setText("Nom :");
        panel_parents.add(lbl_nom_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 50, 30));

        txt_cin_pere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_cin_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 150, 30));

        lbl_nom_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom_pere.setText("Nom :");
        panel_parents.add(lbl_nom_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 30));

        lbl_test_cin_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
       
        panel_parents.add(lbl_test_cin_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 30, 30));

        txt_tel_mere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_tel_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 150, 30));

        txt_adres_mere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_adres_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 150, 30));

        txt_cin_mere.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parents.add(txt_cin_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 150, 30));

        lbl_tel_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_tel_pere.setText("Telephone : ");
        panel_parents.add(lbl_tel_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, 30));

        lbl_adres_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
       
        panel_parents.add(lbl_adres_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, 30));

        lbl_test_nom_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
   
        panel_parents.add(lbl_test_nom_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 30, 30));

        lbl_test_tel_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        
        panel_parents.add(lbl_test_tel_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 30, 30));

        lbl_adres_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
      
        panel_parents.add(lbl_adres_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 30, 30));

        lbl_test_cin_mere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
     
        panel_parents.add(lbl_test_cin_mere, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 30, 30));

        lbl_adress_pere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_adress_pere.setText("Adress :");
        panel_parents.add(lbl_adress_pere, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 60, 30));

        Jtable.addTab("   Parents    ", panel_parents);

        getContentPane().add(Jtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 630, 340));

        pack();
    }// </editor-fold>                        

// Variables declaration - do not modify 
    
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
    private javax.swing.JTabbedPane Jtable;
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
    private javax.swing.JPanel panel_info_eleve;
    private javax.swing.JPanel panel_list_elev;
    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Image_recherche;
    private javax.swing.JLabel lbl_adres_mere;
    private javax.swing.JLabel lbl_adres_pere;
    private javax.swing.JLabel lbl_adress;
    private javax.swing.JLabel lbl_adress_mere;
    private javax.swing.JLabel lbl_adress_pere;
    private javax.swing.JLabel lbl_cin_mere;
    private javax.swing.JLabel lbl_cin_pere;
    private javax.swing.JLabel lbl_date_insc;
    private javax.swing.JLabel lbl_date_nais;
    private javax.swing.JLabel lbl_insc;
    private javax.swing.JLabel lbl_lieu_nais;
    private javax.swing.JLabel lbl_mere;
    private javax.swing.JLabel lbl_niveau;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_nom_mere;
    private javax.swing.JLabel lbl_nom_pere;
    private javax.swing.JLabel lbl_pere;
   
    private javax.swing.JLabel lbl_prenom;
    private javax.swing.JLabel lbl_sexe;
    private javax.swing.JLabel lbl_tel_mere;
    private javax.swing.JLabel lbl_tel_pere;
   
    private javax.swing.JPanel panel_operation;
    private javax.swing.JPanel panel_parents;
  
    
    // End of variables declaration         
}
