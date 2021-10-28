package VUE;
import javax.swing.JRootPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import CONTROLE.Ecouteur_Matiere;

public class Fenetre_Matiere extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = 453095422496646020L;
	public Fenetre_Matiere() {
        initComponents();
        setSize(1000, 480);
        evenement();
    }

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement ()
    {
    	Ecouteur_Matiere Myecouter=new Ecouteur_Matiere(btn_ajout, btn_clear, btn_mod, btn_sup, cmb_niveau, lbl_test_coef, 
    			lbl_test_nom, table_matiere, txt_coef, txt_nom, txt_recherche);
    	
    	
    	Myecouter.Remplir_cmb_Niveau();
    	Myecouter.UpdateTable();
    	
    	btn_ajout.addActionListener(Myecouter);
    	btn_clear.addActionListener(Myecouter);
    	btn_mod.addActionListener(Myecouter);
    	btn_sup.addActionListener(Myecouter);
    	
    	txt_recherche.addKeyListener(Myecouter);
    	txt_nom.addKeyListener(Myecouter);
    	txt_coef.addKeyListener(Myecouter);
    	
    	table_matiere.addMouseListener(Myecouter);
    	
    	 table_matiere.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	 table_matiere.getTableHeader().setReorderingAllowed(false);
    	 table_matiere.getTableHeader().setResizingAllowed(false);
    	 table_matiere.setDefaultEditor(Object.class,null);
    	 
    	 remove_title();
    }
    
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

        panel_matiere = new javax.swing.JPanel();
        lbl_niveau = new javax.swing.JLabel();
        lbl_nom = new javax.swing.JLabel();
        txt_coef = new javax.swing.JTextField();
        cmb_niveau = new javax.swing.JComboBox<>();
        lbl_test_nom = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        lbl_coef = new javax.swing.JLabel();
        lbl_test_coef = new javax.swing.JLabel();
        panel_operation = new javax.swing.JPanel();
        btn_mod = new javax.swing.JButton();
        btn_sup = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_ajout = new javax.swing.JButton();
        panel_list_matier = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_matiere = new javax.swing.JTable();
        txt_recherche = new javax.swing.JTextField();
        lbl_Image_recherche = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_matiere.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Matiere", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_matiere.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_niveau.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_niveau.setText("Niveau : ");
        panel_matiere.add(lbl_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 60, 30));

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("Nom :");
        panel_matiere.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 50, 30));

        txt_coef.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_matiere.add(txt_coef, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 150, 30));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        panel_matiere.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 150, 30));

        lbl_test_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_matiere.add(lbl_test_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 40, 30));

        txt_nom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_matiere.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 150, 30));

        lbl_coef.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_coef.setText("Coefficient :");
        panel_matiere.add(lbl_coef, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 80, 30));

        lbl_test_coef.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_matiere.add(lbl_test_coef, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 40, 30));

        getContentPane().add(panel_matiere, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 600, 290));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder("  Operation "));
        panel_operation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_mod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mod.png"))); // NOI18N
        btn_mod.setText("Modifier");
        panel_operation.add(btn_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 135, 50));

        btn_sup.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_sup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sup.png"))); // NOI18N
        btn_sup.setText("Supprimer");
        panel_operation.add(btn_sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 135, 50));

        btn_clear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        btn_clear.setText("Clear");
      
        panel_operation.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 135, 50));

        btn_ajout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        btn_ajout.setText("Ajouter");
        panel_operation.add(btn_ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 135, 50));

        getContentPane().add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 600, 110));

        panel_list_matier.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Matieres", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_matier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_matiere.setModel(new javax.swing.table.DefaultTableModel(
        		 new Object [][] {  },
				 new String [] {   "Matiere", "Niveau", "Coefficient" }));
        
        table_matiere.setRowHeight(20);
        table_matiere.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        jScrollPane1.setViewportView(table_matiere);

        panel_list_matier.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, 330));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_list_matier.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 30));

        lbl_Image_recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_list_matier.add(lbl_Image_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 50, 30));

        getContentPane().add(panel_list_matier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 430));

        pack();
    }// </editor-fold>                        

                                           


    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_ajout;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_sup;
    private javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JLabel lbl_test_coef;
    private javax.swing.JLabel lbl_test_nom;
    private javax.swing.JPanel panel_list_matier;
    private javax.swing.JTable table_matiere;
    private javax.swing.JTextField txt_coef;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_recherche;
    
    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Image_recherche;
    private javax.swing.JLabel lbl_coef;
    private javax.swing.JLabel lbl_niveau;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JPanel panel_matiere;
    private javax.swing.JPanel panel_operation;
  
    
    // End of variables declaration                   
}
