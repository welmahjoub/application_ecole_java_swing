package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Instituteur;

public class DAOinstituteur extends DAO<Instituteur> {

	 private String SQL;
	 private  Instituteur inst=null;
	 
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
      
	@Override
	public void Ajouter(Instituteur e)
	{
		
		 SQL=" INSERT INTO INSTITUTEUR VALUES (?,?,?,?,?,?,?,?)";

		 try {
			   
	          DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setString(1, String.valueOf(e.getCIN()));
	          DAO.ps.setString(2,e.getNOM());
	          DAO.ps.setString(3,e.getPRENOM());
	          DAO.ps.setString(4,e.getTEL());
	          DAO.ps.setString(5,e.getEMAIL());
	          DAO.ps.setString(6,e.getADRESS());
	          DAO.ps.setString(7,e.getDESCRIPTION());
	          DAO.ps.setString(8,e.getSPECIAL());
	          DAO.ps.execute();
   
	         } catch (SQLException ex) {   System.out.print(" erreur ajouter Instituteur ");    }	
	}
	
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public void Modifier(Instituteur e) 
	{
		 SQL="Update Instituteur set  NOM =? , PRENOM =?  ,  TEL = ? , EMAIL =? ,"
		 	   	+ " ADRESS =? , DESCRIPTION =? ,SPECIAL =? where  CIN =?";
		 		 
		 		 
		  try {
		              DAO.ps=DAO.conn.prepareStatement(SQL);             
			          DAO.ps.setString(1,e.getNOM());
			          DAO.ps.setString(2,e.getPRENOM());
			          DAO.ps.setString(3,e.getTEL());
			          DAO.ps.setString(4,e.getEMAIL());
			          DAO.ps.setString(5,e.getADRESS());
			          DAO.ps.setString(6,e.getDESCRIPTION());
			          DAO.ps.setString(7,e.getSPECIAL());
			          DAO.ps.setString(8, String.valueOf(e.getCIN()));
		              DAO.ps.execute();  
		             
		    } catch (SQLException ex) {   System.out.print(" erreur Modifier Instituteur  ");    }
		
	}
	
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public void Supprimer(int cin) 
	{
		SQL="DELETE FROM Instituteur WHERE cin=?";
 	    
        try {
		   
              DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1 ,cin);
              DAO.ps.execute();
   
           } catch (SQLException ex) {   System.out.print(" erreur supprimer instituteur  ");    }
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public ResultSet getAll() 
	{
		  SQL="SELECT  CIN,NOM,PRENOM FROM INSTITUTEUR order by cin";
	 	   
	 	  try {
	 		  
	 		   DAO.ps=DAO.conn.prepareStatement(SQL);
	           rs=DAO.ps.executeQuery();
	           return rs;    
	            
	         } catch (SQLException ex)  {   System.out.print(" erreur get all instituteur  ");   return null;   }
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public ResultSet Find_ById(int cin) 
	{
		String n=String.valueOf(cin);
	 	n=n+"%";
	 	
		SQL="SELECT  cin,NOM,PRENOM FROM Instituteur where to_char(cin) like ?";

	   try {
		   
	 		   DAO.ps=DAO.conn.prepareStatement(SQL);
	 		   DAO.ps.setString(1, n);
	           rs=DAO.ps.executeQuery();
	            
	           return rs;    
	            
	           } catch (SQLException ex) {   System.out.print(" erreur Find By id (int cin) ");   return null;   }
	}

	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	
	@Override
	public ResultSet Find_ByNom(String nom)
	{
		nom=nom+"%";
		
	     SQL="SELECT  cin,NOM,PRENOM FROM Instituteur where NOM like ? or PRENOM like ?";
	 	   
	      try {
	 		 
		 		  DAO.ps=DAO.conn.prepareStatement(SQL);
		 		  DAO.ps.setString(1, nom);
		 		  DAO.ps.setString(2, nom);
		          rs=DAO.ps.executeQuery();
	            
	              return rs;    
	            
	          } catch (SQLException ex)  {   System.out.print(" erreur find by nom instituteur  ");   return null;   }
	}
      
	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/


    public ResultSet getAllInstituteur_Impression()
    {
 	   
 	   SQL="SELECT  CIN,NOM,PRENOM ,TEL , SPECIAL FROM INSTITUTEUR order by cin";
 	   
 	   try {
 		   
 		    DAO.ps=DAO.conn.prepareStatement(SQL);
            rs=DAO.ps.executeQuery();
            
            return rs;    
            
           } catch (SQLException ex)  {   System.out.print(" erreur de la connection ");   return null;   }
    }
    
   	/*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
      
    public Instituteur getById(int cin)
    {
   
     	 SQL="select * from Instituteur where cin=?";
     	 
   	     try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
   	          DAO.ps.setInt(1, cin);
              rs=DAO.ps.executeQuery();
              
              if(rs.next())
              {
            	  inst=new Instituteur();
            	  inst.setCIN(rs.getInt("cin"));
            	  inst.setNOM(rs.getString("NOM"));
            	  inst.setPRENOM(rs.getString("PRENOM"));
            	  inst.setTEL(rs.getString("TEL"));
            	  inst.setEMAIL(rs.getString("EMAIL"));
            	  inst.setADRESS(rs.getString("ADRESS"));
            	  inst.setDESCRIPTION(rs.getString("DESCRIPTION"));
            	  inst.setSPECIAL(rs.getString("SPECIAL"));   
             	  return inst;
              }
              else
                   return null;
   	
             } catch (SQLException ex)  {   System.out.print(" erreur get by id Instituteur   ");   return null;   }
       }
      
    /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/

    public Instituteur getByNomPrenom(String nom,String prenom)
    {
   
        SQL="select * from Instituteur where nom=? and prenom=?";
     	 
   	    try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
   	          DAO.ps.setString(1, nom);
   	          DAO.ps.setString(2, prenom);
              rs=DAO.ps.executeQuery();
              
              if(rs.next())
              {
            	  inst=new Instituteur()   ;
            	  inst.setCIN(rs.getInt("cin"));
            	  inst.setNOM(rs.getString("NOM"));
            	  inst.setPRENOM(rs.getString("PRENOM"));
            	  inst.setTEL(rs.getString("TEL"));
            	  inst.setEMAIL(rs.getString("EMAIL"));
            	  inst.setADRESS(rs.getString("ADRESS"));
            	  inst.setDESCRIPTION(rs.getString("DESCRIPTION"));
            	  inst.setSPECIAL(rs.getString("SPECIAL"));   

             	  return inst;
              }
              else
                   return null;
   	
             } catch (SQLException ex) {   System.out.print(" erreur au niveau get by nom  prenom instituteur   ");   return null;   }
       }
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
    
	public ArrayList<String> ListeDesInstituteur()
	{
		
		ArrayList<String> tab=new ArrayList<String>();
         SQL="select nom || '-'|| PRENOM as  nom from Instituteur ";
     	 
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  tab.add(rs.getString("NOM"));
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset Instituteurs    ");   return null;   }
		
		
		return tab;
	}
      
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
  	
  	@Override
  	public Instituteur getByNom(String nom) {
  		
  		return null;
  	}
  	
    /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
}
