package VUE;

import CONTROLE.Ecouteur_Login;

public class Fenetre_Login extends javax.swing.JFrame {

   
	private static final long serialVersionUID = 930259891377497441L;
	
	public Fenetre_Login() {
		
       initComponents();
       setSize(1000,600);
       setLocationRelativeTo(null);
       
       btn_cnx.addActionListener(new Ecouteur_Login(this));
    }
    
                         
    private void initComponents() {

        txt_login = new javax.swing.JTextField();
        btn_cnx = new javax.swing.JButton();
        txt_pass = new javax.swing.JPasswordField();
        lbl1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 220, 35));

        btn_cnx.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_cnx.setText("Connexion");
        getContentPane().add(btn_cnx, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 366, 220, 43));
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 299, 220, 35));

        lbl1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(102, 102, 255));
        lbl1.setText("Identification ");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Password :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 100, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Username :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 100, 40));

     

        pack();
    }// </editor-fold>                        

    
    public static void main(String args[]) {
       
       Fenetre_Principal.look();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    public javax.swing.JButton btn_cnx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel lbl1;
    public javax.swing.JTextField txt_login;
    public javax.swing.JPasswordField txt_pass;
    // End of variables declaration                   
}
