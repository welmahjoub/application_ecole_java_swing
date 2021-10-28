package VUE;

import javax.swing.JRootPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Instituteur;
public class Fenetre_Instituteur extends javax.swing.JInternalFrame {


	
	private static final long serialVersionUID = 3427688418016759265L;
	Ecouteur_Instituteur Myecouteur;
	
	public Fenetre_Instituteur()
	{
        initComponents();
        setSize(1000, 480);
        Evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void Evenement()
    {
    	   Myecouteur=new Ecouteur_Instituteur(btn_Ajout_inst, btn_Mod_inst, btn_Sup_inst, btn_clear,
    	   lbl_test_cin, lbl_test_email, lbl_test_nom, lbl_test_prenom, lbl_test_tel, liste_inst,
    	   txt_adress, txt_cin, txt_desc, txt_email, txt_nom, txt_prenom, txt_recherche, txt_special, txt_tel);
    	
    	   Myecouteur.UpdateTable();
           btn_Ajout_inst.addActionListener(Myecouteur);
           btn_Mod_inst.addActionListener(Myecouteur);
           btn_Sup_inst.addActionListener(Myecouteur);
           btn_clear.addActionListener(Myecouteur);
           
           txt_cin.addKeyListener(Myecouteur);
           txt_nom.addKeyListener(Myecouteur);
           txt_prenom.addKeyListener(Myecouteur);
           txt_tel.addKeyListener(Myecouteur);          
           txt_email.addKeyListener(Myecouteur);
           txt_recherche.addKeyListener(Myecouteur);
           liste_inst.addMouseListener(Myecouteur);

           liste_inst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           liste_inst.getTableHeader().setReorderingAllowed(false);
           liste_inst.getTableHeader().setResizingAllowed(false);
           liste_inst.setDefaultEditor(Object.class,null);
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
                             
    private void initComponents() {

        panel_isnt = new javax.swing.JPanel();
        lbl_sepec = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        txt_special = new javax.swing.JTextField();
        lbl_cin = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        txt_desc = new javax.swing.JTextField();
        txt_adress = new javax.swing.JTextField();
        txt_cin = new javax.swing.JTextField();
        lbl_nom = new javax.swing.JLabel();
        lbl_prenom = new javax.swing.JLabel();
        lbl_tel = new javax.swing.JLabel();
        lbl_desc = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_prenom = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_adress = new javax.swing.JLabel();
        lbl_test_nom = new javax.swing.JLabel();
        lbl_test_prenom = new javax.swing.JLabel();
        lbl_test_email = new javax.swing.JLabel();
        lbl_test_cin = new javax.swing.JLabel();
        lbl_test_tel = new javax.swing.JLabel();
        panel_list_isnt = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liste_inst = new javax.swing.JTable();
        txt_recherche = new javax.swing.JTextField();
        lbl_Image_recherche = new javax.swing.JLabel();
        panel_operation = new javax.swing.JPanel();
        btn_Mod_inst = new javax.swing.JButton();
        btn_Sup_inst = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_Ajout_inst = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_isnt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_isnt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_sepec.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_sepec.setText("Specialite :");
        panel_isnt.add(lbl_sepec, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 70, 30));

        lbl_email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_email.setText("Email :");
        panel_isnt.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 50, 30));

        txt_special.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_special, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 150, 30));

        lbl_cin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_cin.setText("CIN :");
        panel_isnt.add(lbl_cin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 40, 30));

        txt_tel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 150, 30));

        txt_desc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 150, 30));

        txt_adress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 150, 30));

        txt_cin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_cin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 30));

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("Nom :");
        panel_isnt.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 40, 30));

        lbl_prenom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_prenom.setText("Prenom :");
        panel_isnt.add(lbl_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 60, 30));

        lbl_tel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_tel.setText("Tele :");
        panel_isnt.add(lbl_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 50, 30));

        lbl_desc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_desc.setText("Description :");
        panel_isnt.add(lbl_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 80, 30));

        txt_nom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 150, 30));

        txt_prenom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 150, 30));

        txt_email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_isnt.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, 30));

        lbl_adress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_adress.setText("Adress :");
        panel_isnt.add(lbl_adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 60, 30));

        lbl_test_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_isnt.add(lbl_test_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 30, 30));

        lbl_test_prenom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_isnt.add(lbl_test_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 30, 30));

        lbl_test_email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_isnt.add(lbl_test_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 30, 30));

        lbl_test_cin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_isnt.add(lbl_test_cin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 30, 30));

        lbl_test_tel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_isnt.add(lbl_test_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 30, 30));

        getContentPane().add(panel_isnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 630, 320));

        panel_list_isnt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Instituteurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_isnt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        liste_inst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIN", "Nom", "Prenom"
            }
        ));
        liste_inst.setRowHeight(20);
        liste_inst.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        jScrollPane1.setViewportView(liste_inst);

        panel_list_isnt.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, 330));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_list_isnt.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 30));

        lbl_Image_recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_list_isnt.add(lbl_Image_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 50, 30));

        getContentPane().add(panel_list_isnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 430));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));
        panel_operation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Mod_inst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Mod_inst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mod.png"))); // NOI18N
        btn_Mod_inst.setText("Modifier");
        panel_operation.add(btn_Mod_inst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 135, 50));

        btn_Sup_inst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Sup_inst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sup.png"))); // NOI18N
        btn_Sup_inst.setText("Supprimer");
        panel_operation.add(btn_Sup_inst, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 135, 50));

        btn_clear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        btn_clear.setText("Clear");
       
        panel_operation.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 135, 50));

        btn_Ajout_inst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Ajout_inst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        btn_Ajout_inst.setText("Ajouter");
        panel_operation.add(btn_Ajout_inst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 135, 50));

        getContentPane().add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 630, 90));

        pack();
    }// </editor-fold>                        

                                     


 // Variables declaration - do not modify                     
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
    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Image_recherche;
    private javax.swing.JLabel lbl_adress;
    private javax.swing.JLabel lbl_cin;
    private javax.swing.JLabel lbl_desc;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_prenom;
    private javax.swing.JLabel lbl_sepec;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JPanel panel_isnt;
    private javax.swing.JPanel panel_list_isnt;
    private javax.swing.JPanel panel_operation;

    // End of variables declaration                  
}
