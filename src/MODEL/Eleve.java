package MODEL;

import java.sql.Blob;


public class Eleve {
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private int num;
	private String date_insc;
	private String nom;
	private String prenom;
	private String date_nais;
	private String lieu_nais;
	private String sexe;
	private String adress;
	private String cin_pere;
	private String nom_pere;
	private String adress_pere;
	private String tel_pere;
	private String cin_mere;
	private String nom_mere;
	private String adress_mere;
	private String tel_mere;
	private String path;
	private Blob image;
	private int NIVEAU;
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public Eleve(){
		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDate_insc() {
		return date_insc;
	}
	public void setDate_insc(String date_insc) {
		this.date_insc = date_insc;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDate_nais() {
		return date_nais;
	}
	public void setDate_nais(String date_nais) {
		this.date_nais = date_nais;
	}
	public String getLieu_nais() {
		return lieu_nais;
	}
	public void setLieu_nais(String lieu_nais) {
		this.lieu_nais = lieu_nais;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCin_pere() {
		return cin_pere;
	}
	public void setCin_pere(String cin_pere) {
		this.cin_pere = cin_pere;
	}
	public String getNom_pere() {
		return nom_pere;
	}
	public void setNom_pere(String nom_pere) {
		this.nom_pere = nom_pere;
	}
	public String getAdress_pere() {
		return adress_pere;
	}
	public void setAdress_pere(String adress_pere) {
		this.adress_pere = adress_pere;
	}
	public String getTel_pere() {
		return tel_pere;
	}
	public void setTel_pere(String tel_pere) {
		this.tel_pere = tel_pere;
	}
	public String getCin_mere() {
		return cin_mere;
	}
	public void setCin_mere(String cin_mere) {
		this.cin_mere = cin_mere;
	}
	public String getNom_mere() {
		return nom_mere;
	}
	public void setNom_mere(String nom_mere) {
		this.nom_mere = nom_mere;
	}
	public String getAdress_mere() {
		return adress_mere;
	}
	public void setAdress_mere(String adress_mere) {
		this.adress_mere = adress_mere;
	}
	public String getTel_mere() {
		return tel_mere;
	}
	public void setTel_mere(String tel_mere) {
		this.tel_mere = tel_mere;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public int getNIVEAU() {
		return NIVEAU;
	}
	public void setNIVEAU(int nIVEAU) {
		NIVEAU = nIVEAU;
	}


	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

}
