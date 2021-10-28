
package VUE;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import CONTROLE.Ecouteur_Ecole;
import CONTROLE.Ecouteur_fen_Principale;
import DAO.DAOecole;
import MODEL.Ecole;


public class Fenetre_Principal extends javax.swing.JFrame implements Observer{

   
	private static final long serialVersionUID = -9146177104918930198L;
	Ecouteur_fen_Principale Myecouteur;
	
    public Fenetre_Principal() {
        
   	 setSize(1000,600);
   	 initComponents();
   	 setLocationRelativeTo(null);
        Evenement();
        this.setDefaultCloseOperation(3);
    }
  

        
    private void initComponents() {

        panel_ecole = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btn_salle = new javax.swing.JButton();
        btn_instituteur = new javax.swing.JButton();
        btn_sedeconnecter = new javax.swing.JButton();
        btn_ecole = new javax.swing.JButton();
        panelScolarite = new javax.swing.JPanel();
        btn_eleve = new javax.swing.JButton();
        btn_absence = new javax.swing.JButton();
        btn_matiere = new javax.swing.JButton();
        btn_classe = new javax.swing.JButton();
        panelAutre = new javax.swing.JPanel();
        btn_emlpoi_classe = new javax.swing.JButton();
        btn_emlpoi_Inst = new javax.swing.JButton();
        btn_note = new javax.swing.JButton();
        btn_conseil = new javax.swing.JButton();
        btn_Biltin = new javax.swing.JButton();
        desk = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_ecole.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_salle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_salle.setText("Salle");
        jPanel1.add(btn_salle, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 12, 170, 70));

        btn_instituteur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_instituteur.setText("Instituteur");
        jPanel1.add(btn_instituteur, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 12, 170, 70));

        btn_sedeconnecter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_sedeconnecter.setText("Sedeconnecter");
        jPanel1.add(btn_sedeconnecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 12, 170, 70));

        btn_ecole.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ecole.setText("Ecole");
        jPanel1.add(btn_ecole, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, 170, 70));

        panel_ecole.addTab("Ecole", jPanel1);

        panelScolarite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_eleve.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_eleve.setText("Eleve");
        panelScolarite.add(btn_eleve, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, 170, 70));

        btn_absence.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_absence.setText("Absence");
        panelScolarite.add(btn_absence, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 12, 170, 70));

        btn_matiere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_matiere.setText("Matiere");
        panelScolarite.add(btn_matiere, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 12, 170, 70));

        btn_classe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_classe.setText("Classe");
        panelScolarite.add(btn_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 12, 170, 70));

        panel_ecole.addTab("Scolarite", panelScolarite);

        panelAutre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_emlpoi_classe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_emlpoi_classe.setText("Emploi Class");
        panelAutre.add(btn_emlpoi_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, 170, 70));

        btn_emlpoi_Inst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_emlpoi_Inst.setText("Emploi Instituteur");
        panelAutre.add(btn_emlpoi_Inst, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 12, 170, 70));

        btn_note.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_note.setText("Note");
        panelAutre.add(btn_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 12, 170, 70));

        btn_conseil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_conseil.setText("Conseil");
        panelAutre.add(btn_conseil, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 170, 70));

        btn_Biltin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_Biltin.setText("bulletin ");
        panelAutre.add(btn_Biltin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 12, 170, 70));

        panel_ecole.addTab("Emploi ", panelAutre);

        getContentPane().add(panel_ecole, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 120));

        desk.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1000, 480));

        pack();
    }// </editor-fold>                        

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void Evenement()
    {
    	
    	Myecouteur=new Ecouteur_fen_Principale(btn_Biltin, btn_absence, btn_classe, btn_conseil,
    			btn_eleve, btn_emlpoi_Inst, btn_emlpoi_classe, btn_instituteur, btn_matiere, btn_note, 
    			btn_salle, btn_sedeconnecter, desk);
    	 	
    	btn_Biltin.addActionListener(Myecouteur);
        btn_matiere.addActionListener(Myecouteur);
        btn_classe.addActionListener(Myecouteur);
        btn_instituteur.addActionListener(Myecouteur);
        btn_emlpoi_classe.addActionListener(Myecouteur);
        btn_emlpoi_Inst.addActionListener(Myecouteur);
        btn_salle.addActionListener(Myecouteur);
        btn_absence.addActionListener(Myecouteur);
        btn_note.addActionListener(Myecouteur);
        btn_eleve.addActionListener(Myecouteur);
        btn_conseil.addActionListener(Myecouteur);
        btn_sedeconnecter.addActionListener(Myecouteur);
        setTitle_Fenetre();
        
        btn_sedeconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	dispose();
            	new Fenetre_Login().setVisible(true);
            } 
          });
        
        btn_ecole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	Activer_Fenetre_ecole();
            }
            });
        
        btn_ecole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ecole.png")));
        btn_classe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/classe.png")));
        btn_eleve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/student.png")));
        btn_instituteur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teacher.png")));
        btn_emlpoi_Inst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/emploi.png")));
        btn_emlpoi_classe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/emploi.png")));
        btn_Biltin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bultin.png")));
        btn_note.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/note.png")));
        btn_conseil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/conseil.png")));
        btn_absence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/absence.png")));
        btn_matiere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/matiere.png")));
        btn_sedeconnecter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png")));
        btn_salle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salle.png")));
    }
   
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void Activer_Fenetre_ecole()
    {

   	 Ecole    ecole=new Ecole();
   	 Fenetre_Ecole fen_ecole=new Fenetre_Ecole();
   	 
   	 Ecouteur_Ecole EcouteurEcole=new Ecouteur_Ecole(ecole, fen_ecole.getBtn_enregistre(), fen_ecole.getLbl_test_codepostal(),
   			fen_ecole.getLbl_test_email(),fen_ecole.getLbl_test_fixe(),fen_ecole.getLbl_test_nom(),fen_ecole.getLbl_test_tel(),
   			fen_ecole.getTxt_adress(), fen_ecole.getTxt_code_postal(), fen_ecole.getTxt_detail(), 
   			fen_ecole.getTxt_email(), fen_ecole.getTxt_fixe(), fen_ecole.getTxt_nom(), fen_ecole.getTxt_tel());
   	 
      	
     	fen_ecole.getBtn_enregistre().addActionListener(EcouteurEcole);
     	fen_ecole.getTxt_nom().addKeyListener(EcouteurEcole);
     	fen_ecole.getTxt_email().addKeyListener(EcouteurEcole);
     	fen_ecole.getTxt_tel().addKeyListener(EcouteurEcole);
     	fen_ecole.getTxt_code_postal().addKeyListener(EcouteurEcole);
     	fen_ecole.getTxt_fixe().addKeyListener(EcouteurEcole);
     	
    	desk.removeAll();
   	    desk.repaint();
    	desk.add(fen_ecole);
		fen_ecole.show();
		ecole.addObserver(this);
		
		
		EcouteurEcole.RemplirLesChamps();
    }
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void setTitle_Fenetre()
    {
      LinkedList<String> list = new DAOecole(). recuperer_info_from_base_donne();
 
    	this.setTitle(list.get(0));
    }
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    void InitialiseEcole(Ecole ecole)
    {
    	
    	LinkedList<String> list = new DAOecole(). recuperer_info_from_base_donne();

    	ecole.setNom(list.get(0));
    	ecole.setAdres(list.get(1));
    	ecole.setTel(list.get(2));
    	ecole.setCodepost(list.get(3));
    	ecole.setFixe(list.get(4));
    	ecole.setEmail(list.get(5));
    	ecole.setDetail(list.get(6));
    	
    }
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/  
    
	@Override
	public void update(Observable o, Object arg) {
		
		Ecole ec=(Ecole)o;
		
		this.setTitle(ec.getNom());
	}
	
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/                  
   
    public static void main(String args[]) {
      
    	look();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	try {
            		 new Fenetre_Principal().setVisible(true);
				} catch (Exception e) {
					System.out.println(" exception");
				}
               
            }
        });
    }
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
    static void look()
    {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    }
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_Biltin;
    private javax.swing.JButton btn_absence;
    private javax.swing.JButton btn_classe;
    private javax.swing.JButton btn_conseil;
    private javax.swing.JButton btn_ecole;
    private javax.swing.JButton btn_eleve;
    private javax.swing.JButton btn_emlpoi_Inst;
    private javax.swing.JButton btn_emlpoi_classe;
    private javax.swing.JButton btn_instituteur;
    private javax.swing.JButton btn_matiere;
    private javax.swing.JButton btn_note;
    private javax.swing.JButton btn_salle;
    private javax.swing.JButton btn_sedeconnecter;
    private  javax.swing.JDesktopPane desk;
    
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelAutre;
    private javax.swing.JPanel panelScolarite;
    private javax.swing.JTabbedPane panel_ecole;
    // End of variables declaration                   

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/  
}
