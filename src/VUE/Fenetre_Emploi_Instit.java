package VUE;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import CONTROLE.Ecouteur_Emploi_Inst;


public class Fenetre_Emploi_Instit extends javax.swing.JInternalFrame {

   
	private static final long serialVersionUID = -1641086640633963774L;
	
    public Fenetre_Emploi_Instit() {
        initComponents();
        setSize(1000, 480);
        evenement();
    }

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void evenement ()
    {
    	 Ecouteur_Emploi_Inst Myecouteur =new Ecouteur_Emploi_Inst(btn_impr, cmb_Instituteur, table_emploiClass);
    	 Myecouteur.Remplir_cmb_Instituteur();
    	 
    	 Myecouteur.UpdateTable();
    	
    	 
    	cmb_Instituteur.addItemListener( Myecouteur);
    	btn_impr.addActionListener(Myecouteur);
    	 btn_impr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png")));
    	 
    	 table_emploiClass.getTableHeader().setReorderingAllowed(false);
    	 table_emploiClass.getTableHeader().setResizingAllowed(false);
    	 table_emploiClass.setDefaultEditor(Object.class,null);
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

        cmb_Instituteur = new javax.swing.JComboBox<>();
        btn_impr = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_emploiClass = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_Instituteur.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(cmb_Instituteur, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 150, 40));

        btn_impr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_impr.setText("Imprimer");
        getContentPane().add(btn_impr, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 160, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Instituteur :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, 40));

 
        table_emploiClass.setRowHeight(50);
        table_emploiClass.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table_emploiClass.setSelectionForeground(new java.awt.Color(0, 51, 255));
        table_emploiClass.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_emploiClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_emploiClassMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_emploiClass);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 910, 280));

        pack();
    }// </editor-fold>                        

    private void table_emploiClassMouseClicked(java.awt.event.MouseEvent evt) {                                               

    }                                              


    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_impr;
    private javax.swing.JComboBox<String> cmb_Instituteur;
    private  javax.swing.JTable table_emploiClass;
    
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
