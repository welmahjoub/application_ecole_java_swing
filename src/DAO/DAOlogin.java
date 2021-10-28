package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOlogin {
	
    private ResultSet rs=null;
 
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	   public  boolean  seconnectez(String user_name,String password ) 
	   {                                           
		    String requete="select * from LOGIN_TABLE where LOGIN =? and PASSWORD =? ";

	        try {
	        	
	            DAO.ps=DAO.conn.prepareStatement(requete);
	            DAO.ps.setString(1,user_name);
	            DAO.ps.setString(2,password);
	            rs=DAO.ps.executeQuery();
	            
	            if(rs.next())
	                return true;
	            else
	               return false ;

	                 } catch (SQLException ex) {System.out.println(" ererue seconecter ");return false;   }
      }
	   
	  /*========================================================================================================================*/
   	 /*========================================= 2) fonction  ================================================*/
	 /*========================================================================================================================*/
}

