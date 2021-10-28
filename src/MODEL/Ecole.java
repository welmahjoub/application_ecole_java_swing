package MODEL;

import java.util.Observable;

public class Ecole extends Observable {

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	    private String  Nom;
	    private  String adres;
	    private  String codepost;
	    private  String detail;
	    private  String email;
	    private String  fixe;
	    private String  tel;
	   
	    /*========================================================================================================================*/
	   	/*========================================= 2) fonction  ================================================*/
	   	/*========================================================================================================================*/
	    
		public Ecole() {
			super();
		}

		public Ecole(String nom, String adres, String tel ,String codepost, String fixe,String email,String detail) {
			super();
			Nom = nom;
			this.adres = adres;
			this.codepost = codepost;
			this.detail = detail;
			this.email = email;
			this.fixe = fixe;
			this.tel = tel;
		
		} 
	    
		public String getNom() {
			return Nom;
		}

		public void setNom(String nom) {
			Nom = nom;
			setChanged();
			notifyObservers();
			
		}

		public String getAdres() {
			return adres;
		}

		public void setAdres(String adres) {
			this.adres = adres;
		}

		public String getCodepost() {
			return codepost;
		}

		public void setCodepost(String codepost) {
			this.codepost = codepost;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFixe() {
			return fixe;
		}

		public void setFixe(String fixe) {
			this.fixe = fixe;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}
		
		/*========================================================================================================================*/
	   	/*========================================= 2) fonction  ================================================*/
	   	/*========================================================================================================================*/
	   
}
