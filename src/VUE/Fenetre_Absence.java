
package VUE;

import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Absence;


public class Fenetre_Absence extends javax.swing.JInternalFrame {

    
	private static final long serialVersionUID = 9138329426599754388L;
	
    public Fenetre_Absence() {
        initComponents();
        
         setSize(1000, 480);
         evenement();
    }

   
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement ()
    {
    	
    	 txt_date.setDateFormatString("dd-MM-yyyy"); 
    	 Ecouteur_Absence myEcouteur=new Ecouteur_Absence(btn_ajout, btn_imprimer, btn_modifer, btn_supprimer,
    			 cmb_class, cmb_niveau, table__absenceEleve, table_absenceClass, txt_date, txt_recherche);
    	 
    	 myEcouteur.Remplir_cmb_Niveau();
    	 myEcouteur.Remplir_cmb_Classe();
    	 myEcouteur.InitialiseDate();
    	 myEcouteur.UpdateTable();
    	
    	 txt_recherche.addKeyListener(myEcouteur);
    	 btn_ajout.addActionListener(myEcouteur);
    	 btn_supprimer.addActionListener(myEcouteur);
    	 btn_modifer.addActionListener(myEcouteur);
    	 btn_imprimer.addActionListener(myEcouteur);
    	 txt_date.addPropertyChangeListener(myEcouteur);
    	 cmb_class.addItemListener(myEcouteur);
    	 cmb_niveau.addItemListener(myEcouteur);
    	 
    	 table_absenceClass.getTableHeader().setReorderingAllowed(false);
    	 table_absenceClass.getTableHeader().setResizingAllowed(false);
    	 btn_modifer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mod.png"))); 
    	 btn_supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sup.png"))); 
    	 btn_ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ajout.png"))); 
    	 btn_imprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png"))); 
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

        table = new javax.swing.JTabbedPane();
        panel_AbsenceClass = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_absenceClass = new javax.swing.JTable();
        panel_operation = new javax.swing.JPanel();
        btn_supprimer = new javax.swing.JButton();
        btn_imprimer = new javax.swing.JButton();
        cmb_niveau = new javax.swing.JComboBox<>();
        cmb_class = new javax.swing.JComboBox<>();
        btn_ajout = new javax.swing.JButton();
        btn_modifer = new javax.swing.JButton();
        txt_date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_absenceEleve = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table__absenceEleve = new javax.swing.JTable();
        lbl_Image_recherche_affectation = new javax.swing.JLabel();
        txt_recherche = new javax.swing.JTextField();
        lbl_num = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        panel_AbsenceClass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_absenceClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {    },
            new String [] { "NUM", "Nom Prenom", "8h - 10h", "10 h -  12h", "12 h -  13h", "14 h -  16h", "16 h -  18h" }));
        
        table_absenceClass.setRowHeight(30);
        table_absenceClass.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table_absenceClass.setSelectionForeground(new java.awt.Color(0, 0, 255));
        table_absenceClass.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_absenceClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_absenceClassMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_absenceClass);
        if (table_absenceClass.getColumnModel().getColumnCount() > 0) {
            table_absenceClass.getColumnModel().getColumn(6).setResizable(false);
        }

        panel_AbsenceClass.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 850, 260));

        panel_operation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        panel_operation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_supprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
       
        btn_supprimer.setText("Supprimer");
        panel_operation.add(btn_supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 135, 50));

        btn_imprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
     
        btn_imprimer.setText("Imprimer");
        btn_imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimerActionPerformed(evt);
            }
        });
        panel_operation.add(btn_imprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 135, 50));

        cmb_niveau.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        panel_operation.add(cmb_niveau, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 150, 30));

        cmb_class.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
     
        cmb_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_class_consulterActionPerformed(evt);
            }
        });
        panel_operation.add(cmb_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 150, 30));

        btn_ajout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
      
        btn_ajout.setText("Ajouter");
        panel_operation.add(btn_ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 135, 50));

        btn_modifer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        
        btn_modifer.setText("Modifier");
        panel_operation.add(btn_modifer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 135, 50));
        panel_operation.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Niveau :");
        panel_operation.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Classe :");
        panel_operation.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 50, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date :");
        panel_operation.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, 30));

        panel_AbsenceClass.add(panel_operation, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 950, 110));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("        Present ( P )  /   Absent ( A )");
        panel_AbsenceClass.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, 30));

        table.addTab("     Gerer Les Absences Des classe       ", panel_AbsenceClass);

        panel_absenceEleve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table__absenceEleve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
             
            },
            new String [] {
                "Date   D'absence", "Horaire"
            }
        ));
        table__absenceEleve.setRowHeight(20);
        table__absenceEleve.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table__absenceEleve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table__absenceEleveMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table__absenceEleve);

        panel_absenceEleve.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 380, 320));

        lbl_Image_recherche_affectation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/r.png"))); // NOI18N
        panel_absenceEleve.add(lbl_Image_recherche_affectation, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 40, 30));

        txt_recherche.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_absenceEleve.add(txt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 150, 30));

        lbl_num.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_num.setText("Numero Inscription  :");
        panel_absenceEleve.add(lbl_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 140, 30));

        table.addTab("      Consulter Absence Des Eleves ", panel_absenceEleve);

        getContentPane().add(table, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 1, 990, 450));

        pack();
    }// </editor-fold>                        

    private void table__absenceEleveMouseClicked(java.awt.event.MouseEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void cmb_class_consulterActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void btn_imprimerActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void table_absenceClassMouseClicked(java.awt.event.MouseEvent evt) {                                                
        // TODO add your handling code here:
    }                                               


    // Variables declaration - do not modify                     
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Image_recherche_affectation;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JPanel panel_AbsenceClass;
    private javax.swing.JPanel panel_absenceEleve;
    private javax.swing.JPanel panel_operation;
    private javax.swing.JTabbedPane table;
    
    private  javax.swing.JButton btn_ajout;
    private javax.swing.JButton btn_imprimer;
    public javax.swing.JButton btn_modifer;
    private javax.swing.JButton btn_supprimer;
    private  javax.swing.JComboBox<String> cmb_class;
    private  javax.swing.JComboBox<String> cmb_niveau;
    private javax.swing.JTable table__absenceEleve;
    private javax.swing.JTable table_absenceClass;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_recherche;
    
    // End of variables declaration                   
}
