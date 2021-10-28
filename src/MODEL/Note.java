package MODEL;

public class Note {
	
	private int ID;
	private int NUM;
	private int CLASS;
	private int MATIERE;
	private int SIMESTRE;
	private String ORALE;
	private String DS1;
	private String DS2;
	private String OBSERVATION;
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	@Override
	public String toString() {
		return "Note [ID=" + ID + ", NUM=" + NUM + ", CLASS=" + CLASS + ", MATIERE=" + MATIERE + ", SIMESTRE="
				+ SIMESTRE + ", ORALE=" + ORALE + ", DS1=" + DS1 + ", DS2=" + DS2 + "]";
	}

	
	public String getOBSERVATION() {
		return OBSERVATION;
	}


	public void setOBSERVATION(String oBSERVATION) {
		OBSERVATION = oBSERVATION;
	}


	public Note()
	{
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getNUM() {
		return NUM;
	}

	public void setNUM(int nUM) {
		NUM = nUM;
	}

	public int getCLASS() {
		return CLASS;
	}

	public void setCLASS(int cLASS) {
		CLASS = cLASS;
	}

	public int getMATIERE() {
		return MATIERE;
	}

	public void setMATIERE(int mATIERE) {
		MATIERE = mATIERE;
	}

	public int getSIMESTRE() {
		return SIMESTRE;
	}

	public void setSIMESTRE(int sIMESTRE) {
		SIMESTRE = sIMESTRE;
	}

	public String getORALE() {
		return ORALE;
	}

	public void setORALE(String oRALE) {
		ORALE = oRALE;
	}

	public String getDS1() {
		return DS1;
	}

	public void setDS1(String dS1) {
		DS1 = dS1;
	}

	public String getDS2() {
		return DS2;
	}

	public void setDS2(String dS2) {
		DS2 = dS2;
	}

	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

}
