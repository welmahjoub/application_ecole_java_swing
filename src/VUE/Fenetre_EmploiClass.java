package VUE;

import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Emploi_Class;
public class Fenetre_EmploiClass extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = -6331047487586942486L;
	
    public Fenetre_EmploiClass() {
        initComponents();
        setSize(1000, 480);
        evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement ()
    {
    	
    	
    	Ecouteur_Emploi_Class MyEcouteur=new Ecouteur_Emploi_Class(btn_ajout, btn_impr, btn_modifier,
    			btn_suprimer, cmb_class, cmb_date, cmb_horair, cmb_institiuteur, cmb_matier, cmb_niveau, cmb_salle, table_emploiClass);
    	
    	MyEcouteur.setModel_TableEmploi_ParDesfault();
    	MyEcouteur.Remplir_cmb_Niveau();
    	MyEcouteur.Remplir_cmb_Classe();
    	MyEcouteur.Remplir_cmb_Matiere();
    	MyEcouteur.Remplir_cmb_Salle();
    	MyEcouteur.Remplir_cmb_Instituteur();
    	MyEcouteur.Remplir_cmb_date();
    	MyEcouteur.Remplir_cmb_Horaire();
    	MyEcouteur.UpdateTable();
    	
    	btn_ajout.addActionListener(MyEcouteur);
    	btn_impr.addActionListener(MyEcouteur);
    	btn_modifier.addActionListener(MyEcouteur);
    	btn_suprimer.addActionListener(MyEcouteur);
    	
    	table_emploiClass.addMouseListener(MyEcouteur);
    	cmb_class.addItemListener(MyEcouteur);
    	cmb_niveau.addItemListener(MyEcouteur);
    
    	table_emploiClass.getTableHeader().setReorderingAllowed(false);
        table_emploiClass.getTableHeader().setResizingAllowed(false);
    	table_emploiClass.setDefaultEditor(Object.class,null);
    	 
    	btn_modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mod.png"))); 
    	btn_suprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sup.png"))); 
    	btn_ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); 
    	btn_impr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png"))); 
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

        panel_parametrage = new javax.swing.JPanel();
        cmb_class = new javax.swing.JComboBox<>();
        btn_impr = new javax.swing.JButton();
        cmb_salle = new javax.swing.JComboBox<>();
        cmb_niveau = new javax.swing.JComboBox<>();
        cmb_date = new javax.swing.JComboBox<>();
        cmb_institiuteur = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb_horair = new javax.swing.JComboBox<>();
        btn_modifier = new javax.swing.JButton();
        btn_suprimer = new javax.swing.JButton();
        btn_ajout = new javax.swing.JButton();
        cmb_matier = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        panel_list_emlpoi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_emploiClass = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_parametrage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_parametrage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_class.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parametrage.add(cmb_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, 30));

        btn_impr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_impr.setText("Imprimer");
        panel_parametrage.add(btn_impr, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 160, 40));

        cmb_salle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parametrage.add(cmb_salle, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 150, 30));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        panel_parametrage.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 150, 30));

        cmb_date.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        panel_parametrage.add(cmb_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 150, 30));

        cmb_institiuteur.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
       
        panel_parametrage.add(cmb_institiuteur, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 150, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Classe : ");
        panel_parametrage.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Horaire : ");
        panel_parametrage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 60, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Instituteur :");
        panel_parametrage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 70, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Niveau : ");
        panel_parametrage.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Date :");
        panel_parametrage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 40, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Matiere :");
        panel_parametrage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 60, 30));

        cmb_horair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
       
        panel_parametrage.add(cmb_horair, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 150, 30));

        btn_modifier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_modifier.setText("Modifier");
        panel_parametrage.add(btn_modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 160, 40));

        btn_suprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_suprimer.setText("Supprimer");
        panel_parametrage.add(btn_suprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 160, 40));

        btn_ajout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ajout.setText("Ajouter ");
        panel_parametrage.add(btn_ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 40));

        cmb_matier.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_parametrage.add(cmb_matier, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 150, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Salle :");
        panel_parametrage.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 50, 30));

        getContentPane().add(panel_parametrage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 960, 160));

        panel_list_emlpoi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panel_list_emlpoi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

     
        table_emploiClass.setGridColor(new java.awt.Color(0, 0, 0));
        table_emploiClass.setRowHeight(50);
        table_emploiClass.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table_emploiClass.setSelectionForeground(new java.awt.Color(51, 102, 255));
        table_emploiClass.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      
        jScrollPane1.setViewportView(table_emploiClass);

        panel_list_emlpoi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 280));

        getContentPane().add(panel_list_emlpoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 960, 290));

        pack();
    }// </editor-fold>                        

  

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_ajout;
    private javax.swing.JButton btn_impr;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_suprimer;
    private javax.swing.JComboBox<String> cmb_class;
    private javax.swing.JComboBox<String> cmb_date;
    private javax.swing.JComboBox<String> cmb_horair;
    private javax.swing.JComboBox<String> cmb_institiuteur;
    private javax.swing.JComboBox<String> cmb_matier;
    private javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JComboBox<String> cmb_salle;
    private javax.swing.JTable table_emploiClass;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_list_emlpoi;
    private javax.swing.JPanel panel_parametrage;

    // End of variables declaration                   
}
