package VUE;

import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Bulltin;
public class Fenetre_Bultin extends javax.swing.JInternalFrame {

	
	private static final long serialVersionUID = -626121161870099496L;
	Ecouteur_Bulltin Myecout;
	public Fenetre_Bultin() {
        initComponents();
        setSize(1000, 480);
        evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement ()
    {
    	Myecout= new Ecouteur_Bulltin(btn_imprimer, cmb_class, cmb_eleve, cmb_niveau,
    			cmb_simestre, table_bultin, txt_decision, txt_moy_general);
    	
    	Myecout.Remplir_cmb_Classe();
    	Myecout.Remplir_cmb_Eleve();
    	Myecout.Update_Table();
    	
    	 table_bultin.getTableHeader().setReorderingAllowed(false);
    	 table_bultin.getTableHeader().setResizingAllowed(false);
    	 table_bultin.setDefaultEditor(Object.class,null);
    	 
    	 btn_imprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png"))); 
    	
    	 cmb_class.addItemListener(Myecout);
    	 cmb_eleve.addItemListener(Myecout);
    	 cmb_simestre.addItemListener(Myecout);
    	 cmb_niveau.addItemListener(Myecout);
    	 btn_imprimer.addActionListener(Myecout);
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

        panel_parametre = new javax.swing.JPanel();
        cmb_class = new javax.swing.JComboBox<>();
        cmb_niveau = new javax.swing.JComboBox<>();
        lbl_niv = new javax.swing.JLabel();
        lbl_clas = new javax.swing.JLabel();
        lbl_eleve = new javax.swing.JLabel();
        cmb_eleve = new javax.swing.JComboBox<>();
        cmb_simestre = new javax.swing.JComboBox<>();
        lbl_sis = new javax.swing.JLabel();
        btn_imprimer = new javax.swing.JButton();
        txt_moy_general = new javax.swing.JLabel();
        lbl_moyGene = new javax.swing.JLabel();
        lbl_decision = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_bultin = new javax.swing.JTable();
        txt_decision = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_parametre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_parametre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_class.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parametre.add(cmb_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 150, 30));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmb_niveau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ere Anne", "2eme Anne", "3eme Anne", "4eme Anne", "5ere Anne", "6eme Anne" }));
        panel_parametre.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 150, 30));

        lbl_niv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_niv.setText("Niveau : ");
        panel_parametre.add(lbl_niv, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 60, 20));

        lbl_clas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_clas.setText("Classe : ");
        panel_parametre.add(lbl_clas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 60, 20));

        lbl_eleve.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_eleve.setText("Eleve :");
        panel_parametre.add(lbl_eleve, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 60, 20));

        cmb_eleve.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parametre.add(cmb_eleve, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 230, 30));

        cmb_simestre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmb_simestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simestre1", "Simestre2", "Simestre3" }));
        panel_parametre.add(cmb_simestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        lbl_sis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_sis.setText("Simetre :");
        panel_parametre.add(lbl_sis, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 20));

        btn_imprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_imprimer.setText("Imprimer");
        panel_parametre.add(btn_imprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 160, 50));

        getContentPane().add(panel_parametre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 80));

        txt_moy_general.setBackground(new java.awt.Color(255, 255, 255));
        txt_moy_general.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_moy_general.setForeground(new java.awt.Color(102, 102, 255));
        txt_moy_general.setOpaque(true);
        getContentPane().add(txt_moy_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 170, 30));

        lbl_moyGene.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_moyGene.setText("Moy General :");
        getContentPane().add(lbl_moyGene, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 100, 30));

        lbl_decision.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_decision.setText("Decision :");
        getContentPane().add(lbl_decision, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 70, 30));

        table_bultin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Matiere", "Note orale ", "Note Devoir1", "Note Devoir2", "Moyen :", "Observations"
            }
        ));
        table_bultin.setRowHeight(30);
        table_bultin.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_bultin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bultinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_bultin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 890, 240));

        txt_decision.setBackground(new java.awt.Color(255, 255, 255));
        txt_decision.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_decision.setForeground(new java.awt.Color(102, 102, 255));
        txt_decision.setOpaque(true);
        getContentPane().add(txt_decision, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 170, 30));

        pack();
    }// </editor-fold>                        

    private void table_bultinMouseClicked(java.awt.event.MouseEvent evt) {                                          

    }                                         


    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_imprimer;
    private javax.swing.JComboBox<String> cmb_class;
    private javax.swing.JComboBox<String> cmb_eleve;
    private javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JComboBox<String> cmb_simestre;
    private javax.swing.JTable table_bultin;
    private javax.swing.JLabel txt_decision;
    private javax.swing.JLabel txt_moy_general;
    
    private javax.swing.JPanel panel_parametre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_clas;
    private javax.swing.JLabel lbl_decision;
    private javax.swing.JLabel lbl_eleve;
    private javax.swing.JLabel lbl_moyGene;
    private javax.swing.JLabel lbl_niv;
    private javax.swing.JLabel lbl_sis;
    
    // End of variables declaration                   
}
