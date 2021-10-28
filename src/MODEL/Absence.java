package MODEL;

public class Absence {

	private int ID;
	private int NUM;
	private int CLASSE;
	private String  DATE;
	private String  VALEUR;
	private int  HORAIRE;
	
	
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	@Override
	public String toString() {
		return "Absence [ID=" + ID + ", NUM=" + NUM + ", CLASSE=" + CLASSE + ", DATE=" + DATE + ", VALEUR=" + VALEUR
				+ ", HORAIRE=" + HORAIRE + "]";
	}
	public int getHORAIRE() {
		return HORAIRE;
	}
	public String getVALEUR() {
		return VALEUR;
	}
	public void setVALEUR(String vALEUR) {
		VALEUR = vALEUR;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setHORAIRE(int hORAIRE) {
		HORAIRE = hORAIRE;
	}
	public int getNUM() {
		return NUM;
	}
	public void setNUM(int nUM) {
		NUM = nUM;
	}
	public int getCLASSE() {
		return CLASSE;
	}
	public void setCLASSE(int cLASSE) {
		CLASSE = cLASSE;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
}
