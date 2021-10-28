package CONTROLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.DAOinstituteur;
import DAO.DAOmatier;
import DAO.DAOsalle;
import DAO.DAOseance;
import MODEL.Instituteur;
import MODEL.Matiere;
import MODEL.Salle;
import MODEL.Seance;

public class Ecouteur_Emploi_Inst implements ItemListener,ActionListener {
	
	

	private javax.swing.JButton btn_impr;
	private javax.swing.JComboBox<String> cmb_Instituteur;
	private  javax.swing.JTable table_emploiClass;
	    
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	public Ecouteur_Emploi_Inst(JButton btn_impr, JComboBox<String> cmb_Instituteur, JTable table_emploiClass) {
		super();
		this.btn_impr = btn_impr;
		this.cmb_Instituteur = cmb_Instituteur;
		this.table_emploiClass = table_emploiClass;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	
		if(e.getSource()==this.cmb_Instituteur)
		{
			UpdateTable();
		}
	}
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	
	public void UpdateTable()
	{
		String cas;
		int ligne,colone;
		int cin=getId_Instituteur_select();
		
		ArrayList<Seance> tab=new DAOseance().getALLInstituteur(cin);
		
		 setModel_TableEmploi_ParDesfault();
		    
		 DefaultTableModel model = (DefaultTableModel) this.table_emploiClass.getModel();
		    
		for (Seance s : tab) {
			
			ligne=s.getHORAIRE()-1;
			colone=s.getJOUR();
			cas=ConcatenerSeance(s);
			
			model.setValueAt(cas, ligne, colone);
		}	
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	int getId_Instituteur_select()
	{
		Instituteur m=null;
		String nomInst="",prenomInst="",Inst;
		int i;
		if(this.cmb_Instituteur.getItemCount()>0)
		{
			
			Inst=this.cmb_Instituteur.getSelectedItem().toString();
			i=Inst.length();
			nomInst=Inst.substring(0, Inst.indexOf("-"));
			prenomInst=Inst.substring(Inst.indexOf("-")+1,i);

			m=new DAOinstituteur().getByNomPrenom(nomInst, prenomInst);
			if(m!=null)
				return m.getCIN();
		}
		    return -1;
	}
		

	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	
	private String ConcatenerSeance(Seance s) 
	{
		
		String nomInst,nomMatier,Cas,nomSale;
		
		nomInst=getNomPrenom_Insitituteur(s.getCIN());
		nomMatier=getNom_Matiere(s.getMATIERE());
		nomSale=getNom_Salle(s.getSALLE());

		Cas= nomInst +"&" + nomMatier + "&" + nomSale;
		
		return Cas;
	}
	
	
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/

	private String getNom_Salle(int num) 
	{
		
      Salle c=new DAOsalle().getById(num);
		
		if(c!=null)
		{
			return c.getNOM();
		}
		return null;
	}

	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	public String  getNom_Matiere(int num)
	{
		Matiere m=new DAOmatier().getById(num);
		
		if(m!=null)
		{
			return m.getNOM();
		}
		return null;
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	
	String getNomPrenom_Insitituteur(int cin)
	{
		
		Instituteur inst=new DAOinstituteur().getById(cin);
		String nom,prenom,NomPrenom;
		
		if(inst!=null)
		{
			nom=inst.getNOM();
			prenom=inst.getPRENOM();
			NomPrenom=nom+"-"+prenom;
			return NomPrenom;
		}
		return null;
		
	}
	/*========================================================================================================================*/
   	/*================================== 2)  Partie Mouse listener   =========================================================*/
   	/*========================================================================================================================*/
	
	public void setModel_TableEmploi_ParDesfault() {

		
		this.table_emploiClass.setModel(new javax.swing.table.DefaultTableModel(
     		   new Object [][] {
             	   {"     8H-10h", " ", " ", " ", " ", " ", " "},
                   {"    10H-12h",  " ", " ", " ", " ", " ", " "},
                   {"    12H-13h", " ", " ", " ", " ", " ", " "},
                   {"    14H-16h",  " ", " ", " ", " ", " ", " "},
                   {"    16H-18h",  " ", " ", " ", " ", " ", " "}},
             new String [] {"", "Lundi", "Mardi", "Mecredi", "Jeudi", "Vendredi", "Samedi"}));
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public void Remplir_cmb_Instituteur()
	{
		DAOinstituteur d=new DAOinstituteur();
		ArrayList<String> tab;
		
		if(this.cmb_Instituteur.getItemCount()>0)
			this.cmb_Instituteur.removeAllItems();
		
		tab=d.ListeDesInstituteur();
		if(tab!=null)
		{
	 		for (String c : tab) 
			{
				this.cmb_Instituteur.addItem(c);
			}
		}
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn_impr)
		{
			int cin=getId_Instituteur_select();
			String nomPrenom=getNomPrenom_Insitituteur(cin);
			Imprimer_emploi_Inst.Imprimer(nomPrenom, cin);
			
			
		}
		
	}
	
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

}
