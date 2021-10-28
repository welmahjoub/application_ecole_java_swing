package MODEL;

public class Matiere {
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	private int ID;
	private String NOM;
	private int  NIVEAU;
	private String COEF ;
	private int Has_Note_Orale; //=1 si oui ,sinon=-1
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	


	public int getHas_Note_Orale() {
		return Has_Note_Orale;
	}

	public void setHas_Note_Orale(int has_Note_Orale) {
		Has_Note_Orale = has_Note_Orale;
	}

	public Matiere()
	{
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNOM() {
		return NOM;
	}

	public void setNOM(String nOM) {
		NOM = nOM;
	}

	public int getNIVEAU() {
		return NIVEAU;
	}

	public String getCOEF() {
		return COEF;
	}

	public void setCOEF(String cOEF) {
		COEF = cOEF;
	}

	public void setNIVEAU(int nIVEAU) {
		NIVEAU = nIVEAU;
	}
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

}
