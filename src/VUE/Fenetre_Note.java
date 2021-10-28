package VUE;

import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Note;


public class Fenetre_Note extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = -2768567081429648324L;
	
	Ecouteur_Note Myecouteur;
    public Fenetre_Note() {
        initComponents();
        setSize(1000, 480);
        evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement ()
    {
    
    	Myecouteur=new Ecouteur_Note(btn_enregistrer, cmb_class, cmb_matier, cmb_niveau, 
    			cmb_simestre, label_Titre_matiere, table_note);
    	
    	Myecouteur.Remplir_cmb_Niveau();
    	Myecouteur.RemplirCmbClasse();
    	Myecouteur.RemplirCmbMatiere();
    	Myecouteur.UpdateTable();
    	Myecouteur.UpdateTitreMatiere(); 
    	 
    	 cmb_niveau.addItemListener(Myecouteur);
    	 cmb_class.addItemListener(Myecouteur);
    	 cmb_matier.addItemListener(Myecouteur); 
    	 cmb_simestre.addItemListener(Myecouteur); 
    	 btn_enregistrer.addActionListener(Myecouteur);
    	 
    	 btn_enregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png")));
    	 
    
    	 table_note.setSelectionBackground(new java.awt.Color(255, 255, 255));

    	 table_note.setSelectionForeground(new java.awt.Color(51, 51, 255));
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

        panel_matiere = new javax.swing.JPanel();
        cmb_class = new javax.swing.JComboBox<>();
        cmb_simestre = new javax.swing.JComboBox<>();
        cmb_niveau = new javax.swing.JComboBox<>();
        cmb_matier = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_enregistrer = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        panel_list_emlpoi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_note = new javax.swing.JTable();
        label_Titre_matiere = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_matiere.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_matiere.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_class.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_matiere.add(cmb_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 150, 30));

        cmb_simestre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmb_simestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simestre1", "Simestre2", "Simestre3" }));
        panel_matiere.add(cmb_simestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 150, 30));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        panel_matiere.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        cmb_matier.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_matiere.add(cmb_matier, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 150, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Simetre :");
        panel_matiere.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 70, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Niveau : ");
        panel_matiere.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 60, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Classe : ");
        panel_matiere.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 60, 20));

        btn_enregistrer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_enregistrer.setText("Enresgitrer");
        panel_matiere.add(btn_enregistrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 160, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Matiere :");
        panel_matiere.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 60, 20));

        getContentPane().add(panel_matiere, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 960, 80));

        panel_list_emlpoi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_emlpoi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        this. table_note.setModel(new javax.swing.table.DefaultTableModel(new Object [][] { },
	            new String [] {" Numero  "," Nom Prenom ", " Note Orale  ", " Note Devoir1 " ," Note Devoir2 " ," Observations "}));
        table_note.setRowHeight(30);
        table_note.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_note.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_noteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_note);

        panel_list_emlpoi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 910, 280));

        label_Titre_matiere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label_Titre_matiere.setText("Saisir les Note du Matiere : Francais  ");
        panel_list_emlpoi.add(label_Titre_matiere, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 290, 30));

        getContentPane().add(panel_list_emlpoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 960, 340));

        pack();
    }// </editor-fold>                        

    private void table_noteMouseClicked(java.awt.event.MouseEvent evt) {                                        

    }                                       


    // Variables declaration - do not modify         
    
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JComboBox<String> cmb_class;
    private javax.swing.JComboBox<String> cmb_matier;
    private javax.swing.JComboBox<String> cmb_niveau;
    private  javax.swing.JComboBox<String> cmb_simestre;
    private javax.swing.JLabel label_Titre_matiere;
    private javax.swing.JTable table_note;
    
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_list_emlpoi;
    private javax.swing.JPanel panel_matiere;
   
    // End of variables declaration                   
}
