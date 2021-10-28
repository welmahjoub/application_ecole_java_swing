package MODEL;

public class Seance {
	
	private int ID;
	private int CLASSE;
	private int MATIERE;
	private int SALLE;
	private int CIN;
	private int HORAIRE;
	private int JOUR;
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	@Override
	public String toString() {
		return "Seance [ID=" + ID + ", CLASS=" + CLASSE + ", MATIERE=" + MATIERE + ", SALLE=" + SALLE + ", CIN=" + CIN
				+ ", HORAIRE=" + HORAIRE + ", JOUR=" + JOUR + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCLASSE() {
		return CLASSE;
	}
	public void setCLASSE(int cLASS) {
		CLASSE = cLASS;
	}
	public int getMATIERE() {
		return MATIERE;
	}
	public void setMATIERE(int mATIERE) {
		MATIERE = mATIERE;
	}
	public int getSALLE() {
		return SALLE;
	}
	public void setSALLE(int sALLE) {
		SALLE = sALLE;
	}
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	public int getHORAIRE() {
		return HORAIRE;
	}
	public void setHORAIRE(int hORAIRE) {
		HORAIRE = hORAIRE;
	}
	public int getJOUR() {
		return JOUR;
	}
	public void setJOUR(int jOUR) {
		JOUR = jOUR;
	}
	
	
}
