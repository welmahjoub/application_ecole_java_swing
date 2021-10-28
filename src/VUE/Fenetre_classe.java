
package VUE;
import javax.swing.JRootPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Affectation;
import CONTROLE.Ecouteur_Class;
public class Fenetre_classe extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = 1268976611148454851L;
	
	Ecouteur_Class MyecouteurClass;
	Ecouteur_Affectation MyecouteurAffect;
	
    public Fenetre_classe() {
        initComponents();
        
         setSize(1000, 480);
         Evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void Evenement()
    {
    	     
    	    MyecouteurClass=new Ecouteur_Class(btn_ajout, btn_clear, btn_mod, 
    	    btn_sup, cmb_niveau, table_class, txt_nom, txt_recherche, lbl_test_nom);
    	     
    	    MyecouteurAffect=new Ecouteur_Affectation(btn_affecter, btn_sup_consulter, txt_recherche_affectation,
    	    txt_recherche_consulter, table__affectation, table_consulter, cmb_niveau_affectation,
    	    cmb_niveau_consulter, cmb_class__affectation, cmb_class_consulter, btn_imprimer__affectation, btn_imprimer_consulter);
	       
    	    
    	    MyecouteurClass.Remplir_cmb_Niveau();
	        MyecouteurClass .UpdateTable();
	    	btn_ajout.addActionListener(MyecouteurClass);
	    	btn_clear.addActionListener(MyecouteurClass);
	    	btn_mod.addActionListener(MyecouteurClass);
	    	btn_sup.addActionListener(MyecouteurClass);
	    	txt_recherche.addKeyListener(MyecouteurClass);
	    	txt_nom.addKeyListener(MyecouteurClass);
	    	table_class.addMouseListener(MyecouteurClass);
	    	 
	    	 MyecouteurAffect.Remplir_cmb_Niveau_consulter();
	    	 MyecouteurAffect.Remplir_cmb_Niveau_affect();
	    	 
	     	 MyecouteurAffect.Remplir_Cmb_Affectation();
	         MyecouteurAffect.Remplir_cmb_Consulter(); 
	    	 
	         MyecouteurAffect.UpdateTableAffectation();
	     	 MyecouteurAffect.UpdateTableConsulter();
	    	 table__affectation.addMouseListener(MyecouteurAffect);
		     table_consulter.addMouseListener(MyecouteurAffect);
	    	 btn_imprimer_consulter.addActionListener(MyecouteurAffect);
	    	 txt_recherche_affectation.addKeyListener(MyecouteurAffect);
	    	 txt_recherche_consulter.addKeyListener(MyecouteurAffect);
	    	 btn_affecter.addActionListener(MyecouteurAffect);	    	 
	    	 btn_imprimer__affectation.addActionListener(MyecouteurAffect);
	    	 btn_imprimer__affectation.addActionListener(MyecouteurAffect);
	    	 btn_sup_consulter.addActionListener(MyecouteurAffect);
	    	 cmb_class__affectation.addItemListener(MyecouteurAffect);
	    	 cmb_class_consulter.addItemListener(MyecouteurAffect);
	    	 cmb_niveau_affectation.addItemListener(MyecouteurAffect);
		     cmb_niveau_consulter.addItemListener(MyecouteurAffect);
		     
		     table_class.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    	 table_class.getTableHeader().setReorderingAllowed(false);
	    	 table_class.getTableHeader().setResizingAllowed(false);
	    	 table_class.setDefaultEditor(Object.class,null);
	    	 
	    	 table_consulter.getTableHeader().setReorderingAllowed(false);
	    	 table_consulter.getTableHeader().setResizingAllowed(false);
	    	 table_consulter.setDefaultEditor(Object.class,null);

	    	 table__affectation.getTableHeader().setReorderingAllowed(false);
	    	 table__affectation.getTableHeader().setResizingAllowed(false);
	    	 table__affectation.setDefaultEditor(Object.class,null);
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

        jtable = new javax.swing.JTabbedPane();
        panel_gere_class = new javax.swing.JPanel();
        panel_class = new javax.swing.JPanel();
        lbl_niveau = new javax.swing.JLabel();
        lbl_nom = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        cmb_niveau = new javax.swing.JComboBox<>();
        lbl_test_nom = new javax.swing.JLabel();
        panel_operation = new javax.swing.JPanel();
        btn_mod = new javax.swing.JButton();
        btn_sup = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_ajout = new javax.swing.JButton();
        panel_list_class = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_class = new javax.swing.JTable();
        txt_recherche = new javax.swing.JTextField();
        lbl_Image_recherche = new javax.swing.JLabel();
        panel_consulter_listeEleve = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_consulter = new javax.swing.JTable();
        panel_operation_consulter = new javax.swing.JPanel();
        btn_sup_consulter = new javax.swing.JButton();
        btn_imprimer_consulter = new javax.swing.JButton();
        txt_recherche_consulter = new javax.swing.JTextField();
        lbl_Image_recherche_consulter = new javax.swing.JLabel();
        cmb_class_consulter = new javax.swing.JComboBox<>();
        cmb_niveau_consulter = new javax.swing.JComboBox<>();
        panel_affectation = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table__affectation = new javax.swing.JTable();
        panel_operation_affceter = new javax.swing.JPanel();
        btn_affecter = new javax.swing.JButton();
        btn_imprimer__affectation = new javax.swing.JButton();
        cmb_niveau_affectation = new javax.swing.JComboBox<>();
        cmb_class__affectation = new javax.swing.JComboBox<>();
        lbl_Image_recherche_affectation = new javax.swing.JLabel();
        txt_recherche_affectation = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        panel_gere_class.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_class.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Classe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        panel_class.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_niveau.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_niveau.setText("Niveau : ");
        panel_class.add(lbl_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, 30));

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("Nom :");
        panel_class.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 80, 30));

        txt_nom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_class.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 150, 30));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        panel_class.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 150, 30));

        lbl_test_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_class.add(lbl_test_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 110, 30));

        panel_gere_class.add(panel_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 600, 290));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Operation ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
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

        panel_gere_class.add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 600, 110));

        panel_list_class.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Classes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_class.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_list_class.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_class.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "classe", "niveau"
            }
        ));
        table_class.setRowHeight(20);
        table_class.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        jScrollPane1.setViewportView(table_class);

        panel_list_class.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, 320));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_list_class.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 30));

        lbl_Image_recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_list_class.add(lbl_Image_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 50, 30));

        panel_gere_class.add(panel_list_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 390));

        jtable.addTab("        Gerer Classe  ", panel_gere_class);

        panel_consulter_listeEleve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_consulter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "   Num Inscription", " Nom", "Prenom"
            }
        ));
        table_consulter.setRowHeight(20);
        table_consulter.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
     
        jScrollPane2.setViewportView(table_consulter);

        panel_consulter_listeEleve.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 800, 290));

        panel_operation_consulter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Operation ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        panel_operation_consulter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_sup_consulter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_sup_consulter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sup.png"))); // NOI18N
        btn_sup_consulter.setText("Supprimer");
        panel_operation_consulter.add(btn_sup_consulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 135, 50));

        btn_imprimer_consulter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_imprimer_consulter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png"))); // NOI18N
        btn_imprimer_consulter.setText("Imprimer");
        
        panel_operation_consulter.add(btn_imprimer_consulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 135, 50));

        panel_consulter_listeEleve.add(panel_operation_consulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 330, 80));

        txt_recherche_consulter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_consulter_listeEleve.add(txt_recherche_consulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, 30));

        lbl_Image_recherche_consulter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_consulter_listeEleve.add(lbl_Image_recherche_consulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 50, 30));

        cmb_class_consulter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        panel_consulter_listeEleve.add(cmb_class_consulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 150, 30));

        cmb_niveau_consulter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
       
        panel_consulter_listeEleve.add(cmb_niveau_consulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 150, 30));

        jtable.addTab("      Consulter Liste des Eleves       ", panel_consulter_listeEleve);

        panel_affectation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table__affectation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
                "   Num Inscription", "Nom", "Prenom"
            }
        ));
        table__affectation.setRowHeight(20);
        table__affectation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       
        jScrollPane3.setViewportView(table__affectation);

        panel_affectation.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 800, 290));

        panel_operation_affceter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Operation ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        panel_operation_affceter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_affecter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_affecter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        btn_affecter.setText("Affectuer");
        panel_operation_affceter.add(btn_affecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 135, 50));

        btn_imprimer__affectation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_imprimer__affectation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png"))); // NOI18N
        btn_imprimer__affectation.setText("Imprimer");
       
        panel_operation_affceter.add(btn_imprimer__affectation, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 135, 50));

        panel_affectation.add(panel_operation_affceter, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 330, 80));

        cmb_niveau_affectation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
      
        panel_affectation.add(cmb_niveau_affectation, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 150, 30));

        cmb_class__affectation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        
        panel_affectation.add(cmb_class__affectation, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 150, 30));

        lbl_Image_recherche_affectation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_affectation.add(lbl_Image_recherche_affectation, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 50, 30));

        txt_recherche_affectation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_affectation.add(txt_recherche_affectation, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, 30));

        jtable.addTab("             Affectation               ", panel_affectation);

        getContentPane().add(jtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 1, 990, 450));

        pack();
    }// </editor-fold>                        

    

    // Variables declaration - do not modify                     
   
    private javax.swing.JButton btn_ajout;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_sup;
    private javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JTable table_class;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_recherche;
    private javax.swing.JLabel lbl_test_nom;
    
    
    private javax.swing.JButton btn_affecter;
    private javax.swing.JButton btn_sup_consulter;
    private javax.swing.JTextField txt_recherche_affectation;
    private javax.swing.JTextField txt_recherche_consulter;
    private javax.swing.JTable table__affectation;
    private javax.swing.JTable table_consulter;
    private javax.swing.JComboBox<String> cmb_niveau_affectation;
    private javax.swing.JComboBox<String> cmb_niveau_consulter;
    private javax.swing.JComboBox<String> cmb_class__affectation;
    private javax.swing.JComboBox<String> cmb_class_consulter;
    private javax.swing.JButton btn_imprimer__affectation;
    private javax.swing.JButton btn_imprimer_consulter;
    
    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jtable;
    private javax.swing.JLabel lbl_Image_recherche;
    private javax.swing.JLabel lbl_Image_recherche_affectation;
    private javax.swing.JLabel lbl_Image_recherche_consulter;
    private javax.swing.JLabel lbl_niveau;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JPanel panel_affectation;
    private javax.swing.JPanel panel_class;
    private javax.swing.JPanel panel_consulter_listeEleve;
    private javax.swing.JPanel panel_gere_class;
    private javax.swing.JPanel panel_list_class;
    private javax.swing.JPanel panel_operation;
    private javax.swing.JPanel panel_operation_affceter;
    private javax.swing.JPanel panel_operation_consulter;

    // End of variables declaration                   
}
