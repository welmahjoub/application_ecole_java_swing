package VUE;

import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Conseil;
public class Fenetre_Conseil extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = -206935255067298891L;
	
    public Fenetre_Conseil() {
        initComponents();
        setSize(1000, 480);
        evenement();
    }
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement ()
    {
    	txt_Date.setDateFormatString("dd-MM-yyyy"); 

    	btn_ajout.addActionListener( new Ecouteur_Conseil(this));
    	btn_mod.addActionListener( new Ecouteur_Conseil(this));
    	btn_clear.addActionListener( new Ecouteur_Conseil(this));
    	btn_sup.addActionListener( new Ecouteur_Conseil(this));
    	table_conseil.addMouseListener(new Ecouteur_Conseil(this));
    	cmb_niveau.addItemListener(new Ecouteur_Conseil(this));
    	cmb_class.addItemListener(new Ecouteur_Conseil(this));
    	txt_recherche.addKeyListener(new Ecouteur_Conseil(this));
    	
    	 new Ecouteur_Conseil(this).Remplir_cmb_Classe();
    	 new Ecouteur_Conseil(this).UpdateTable();
    	 new Ecouteur_Conseil(this).InitialiseDate();
    	 
    	 table_conseil.getTableHeader().setReorderingAllowed(false);
    	 table_conseil.getTableHeader().setResizingAllowed(false);
    	 table_conseil.setDefaultEditor(Object.class,null);
    	 
    	 btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mod.png"))); 
    	 btn_sup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sup.png"))); 
    	 btn_ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); 
    	 btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); 
    	 
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

        panel_conseil = new javax.swing.JPanel();
        lbl_nom = new javax.swing.JLabel();
        cmb_class = new javax.swing.JComboBox<>();
        txt_Date = new com.toedter.calendar.JDateChooser();
        lbl_titre = new javax.swing.JLabel();
        lbl_nom2 = new javax.swing.JLabel();
        cmb_niveau = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_conseil = new javax.swing.JTextArea();
        lbl_nom3 = new javax.swing.JLabel();
        panel_operation = new javax.swing.JPanel();
        btn_mod = new javax.swing.JButton();
        btn_sup = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_ajout = new javax.swing.JButton();
        panel_list_conseil = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_conseil = new javax.swing.JTable();
        txt_recherche = new javax.swing.JTextField();
        lbl_Image_recherche = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_conseil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_conseil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("classe :");
        panel_conseil.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 60, 30));

        cmb_class.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_conseil.add(cmb_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 150, 30));
        panel_conseil.add(txt_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 30));

        lbl_titre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_titre.setText("Saisir Une Conseil :");
        panel_conseil.add(lbl_titre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 170, 30));

        lbl_nom2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom2.setText("Niveau : ");
        panel_conseil.add(lbl_nom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 60, 30));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmb_niveau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ere Anne", "2eme Anne", "3eme Anne", "4eme Anne", "5ere Anne", "6eme Anne" }));
       
        panel_conseil.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 150, 30));

        txt_conseil.setColumns(20);
        txt_conseil.setRows(5);
        jScrollPane2.setViewportView(txt_conseil);

        panel_conseil.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 630, 180));

        lbl_nom3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom3.setText("Date :");
        panel_conseil.add(lbl_nom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        getContentPane().add(panel_conseil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 670, 310));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));
        panel_operation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_mod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
      
        btn_mod.setText("Modifier");
        panel_operation.add(btn_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 135, 50));

        btn_sup.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        
        btn_sup.setText("Supprimer");
        panel_operation.add(btn_sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 135, 50));

        btn_clear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        
        btn_clear.setText("Clear");
       
        panel_operation.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 135, 50));

        btn_ajout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        btn_ajout.setText("Ajouter");
        panel_operation.add(btn_ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 135, 50));

        getContentPane().add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 660, 100));

        panel_list_conseil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Conseils", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_conseil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_conseil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
         
            },
            new String [] {
                "Date ", "class", "text"
            }
        ));
        table_conseil.setRowHeight(20);
        table_conseil.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       
        jScrollPane1.setViewportView(table_conseil);

        panel_list_conseil.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 270, 330));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_list_conseil.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 30));

        lbl_Image_recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_list_conseil.add(lbl_Image_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 50, 30));

        getContentPane().add(panel_list_conseil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 430));

        pack();
    }// </editor-fold>                        
                                         


    // Variables declaration - do not modify                     
    public javax.swing.JButton btn_ajout;
    public javax.swing.JButton btn_clear;
    public javax.swing.JButton btn_mod;
    public javax.swing.JButton btn_sup;
    public javax.swing.JComboBox<String> cmb_class;
    public javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Image_recherche;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_nom2;
    private javax.swing.JLabel lbl_nom3;
    private javax.swing.JLabel lbl_titre;
    private javax.swing.JPanel panel_conseil;
    private javax.swing.JPanel panel_list_conseil;
    private javax.swing.JPanel panel_operation;
    public javax.swing.JTable table_conseil;
    public com.toedter.calendar.JDateChooser txt_Date;
    public javax.swing.JTextArea txt_conseil;
    public javax.swing.JTextField txt_recherche;
    // End of variables declaration                   
}
