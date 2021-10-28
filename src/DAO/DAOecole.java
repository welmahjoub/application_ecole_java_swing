package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import MODEL.Ecole;

public class DAOecole {  

      private  ResultSet rs=null;
     
     /*========================================================================================================================*/
     /*========================================= 2) fonction  ================================================*/
     /*========================================================================================================================*/
	
	public  void enregistre_info(Ecole e)
	 {
		 
		 String requete="Update ECOLE  set NOM =?,ADRESS = ?,TEL  =?,CODE_POSTAL =? ,FIXE =?,EMAIL =?,DETAILS =? where id_ecole =1";

        try {
        	
	            DAO.ps=DAO.conn.prepareStatement(requete);
	            DAO.ps.setString(1,e.getNom());
	            DAO.ps.setString(2,e.getAdres());
	            DAO.ps.setString(3,e.getTel());
	            DAO.ps.setString(4,e.getCodepost());
	            DAO.ps.setString(5,e.getFixe());
	            DAO.ps.setString(6,e.getEmail());
	            DAO.ps.setString(7,e.getDetail());
	            DAO.ps.execute();
	            
	           } catch (SQLException ex) {   System.out.print(" erreur de la connection ");    } 
	 }
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	 public    LinkedList<String>    recuperer_info_from_base_donne()
	 {
		 LinkedList<String>  tab = new LinkedList<String>();
		 
		 String requete="select nom,ADRESS,tel,CODE_POSTAL,FIXE,email,DETAILS from ECOLE  where ID_Ecole =1";
		 
		try {

	            DAO.ps=DAO.conn.prepareStatement(requete);
	            rs=DAO.ps.executeQuery();

	            if(rs.next())
	            {    	
	                tab.add(rs.getString("NOM"));
	    			tab.add(rs.getString("ADRESS"));
	    			tab.add(rs.getString("TEL"));
	    			tab.add(rs.getString("CODE_POSTAL"));
	    			tab.add(rs.getString("FIXE"));
	    		    tab.add(rs.getString("EMAIL"));
	    		    tab.add(rs.getString("DETAILS"));
	    		    return tab;
	            }
	            else
	            	 return null;

	    		} catch (SQLException e) { System.out.println("  erreru recupere info from table ecole "); return null;}
	 }
	 
	 /*========================================================================================================================*/
	 /*========================================= 2) fonction  ================================================*/
	 /*========================================================================================================================*/ 

}
