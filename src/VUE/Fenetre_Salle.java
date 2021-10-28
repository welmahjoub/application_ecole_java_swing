package VUE;

import javax.swing.JRootPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import CONTROLE.Ecouteur_Salle;
public class Fenetre_Salle extends javax.swing.JInternalFrame {


	private static final long serialVersionUID = -8655863798292187346L;
	
	Ecouteur_Salle Myecouteur;
    public Fenetre_Salle() {
        initComponents();
        setSize(1000, 480);
        Evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void Evenement()
    {
    	
    	Myecouteur = new Ecouteur_Salle(btn_ajout, btn_clear, btn_mod, btn_sup, 
    	txt_capa, txt_nom, txt_recherche, cmb_type, lbl_test_capa, lbl_test_nom, table_salle);
    	
    	Myecouteur.UpdateTable();
    	btn_ajout.addActionListener(Myecouteur);
    	btn_clear.addActionListener(Myecouteur);
    	btn_mod.addActionListener(Myecouteur);
    	btn_sup.addActionListener(Myecouteur);
    	txt_recherche.addKeyListener(Myecouteur);
    	txt_nom.addKeyListener(Myecouteur);
    	txt_capa.addKeyListener(Myecouteur);
    	table_salle.addMouseListener(Myecouteur);
    	
    	table_salle	.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	table_salle.getTableHeader().setReorderingAllowed(false);
    	table_salle.getTableHeader().setResizingAllowed(false);
    	table_salle.setDefaultEditor(Object.class,null);
    	
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

        panel_salle = new javax.swing.JPanel();
        lbl_type = new javax.swing.JLabel();
        lbl_capa = new javax.swing.JLabel();
        txt_capa = new javax.swing.JTextField();
        cmb_type = new javax.swing.JComboBox<>();
        lbl_test_capa = new javax.swing.JLabel();
        lbl_nom = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        lbl_test_nom = new javax.swing.JLabel();
        panel_operation = new javax.swing.JPanel();
        btn_mod = new javax.swing.JButton();
        btn_sup = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_ajout = new javax.swing.JButton();
        panel_list_salle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_salle = new javax.swing.JTable();
        txt_recherche = new javax.swing.JTextField();
        lbl_Image_recherche = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_salle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "   Salle  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_salle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_type.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_type.setText("Type :");
        panel_salle.add(lbl_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, 30));

        lbl_capa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_capa.setText("Capacite :");
        panel_salle.add(lbl_capa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 80, 30));

        txt_capa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_salle.add(txt_capa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 150, 30));

        cmb_type.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cour", "TP" }));
        panel_salle.add(cmb_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 150, 30));

        lbl_test_capa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_salle.add(lbl_test_capa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 110, 30));

        lbl_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_nom.setText("Nom :");
        panel_salle.add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 80, 30));

        txt_nom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_salle.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 150, 30));

        lbl_test_nom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panel_salle.add(lbl_test_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 110, 30));

        getContentPane().add(panel_salle, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 600, 290));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder("Operation"));
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
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        panel_operation.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 135, 50));

        btn_ajout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); // NOI18N
        btn_ajout.setText("Ajouter");
        panel_operation.add(btn_ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 135, 50));

        getContentPane().add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 600, 110));

        panel_list_salle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Sales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_salle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_list_salle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_salle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N° Insc", "Nom", "Niveau"
            }
        ));
        table_salle.setRowHeight(20);
        table_salle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_salle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_salleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_salle);

        panel_list_salle.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, 330));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_list_salle.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 30));

        lbl_Image_recherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_list_salle.add(lbl_Image_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 50, 30));

        getContentPane().add(panel_list_salle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 430));

        pack();
    }// </editor-fold>                        

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void table_salleMouseClicked(java.awt.event.MouseEvent evt) {                                         

    }                                        

    // Variables declaration - do not modify                     
    private  javax.swing.JButton btn_ajout;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_sup;
    private javax.swing.JTextField txt_capa;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_recherche;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JLabel lbl_test_capa;
    private javax.swing.JLabel lbl_test_nom;
    private javax.swing.JTable table_salle;
    
    private javax.swing.JLabel lbl_Image_recherche;
    private javax.swing.JLabel lbl_capa;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_type;
    private javax.swing.JPanel panel_list_salle;
    private javax.swing.JPanel panel_operation;
    private javax.swing.JPanel panel_salle;
    private javax.swing.JScrollPane jScrollPane1;
    
  
    
    // End of variables declaration                    
}
