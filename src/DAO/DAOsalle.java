package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Salle;


public class DAOsalle extends DAO<Salle> {

     ResultSet rs=null;
     String SQL;
     Salle s;
     /*========================================================================================================================*/
    /*=========================================  les colonnes du table salle ================================================*/
     /*========================================================================================================================*/
     
     /* 
        ID
        NOM
        TYPE
        CAPACITE
     */
     
     /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
     
 	@Override
 	public void Ajouter(Salle e)
 	{
 		
 		   String requete= "INSERT INTO salle( NOM,TYPE,CAPACITE) VALUES(?,?,?)";
 		   
		   try {
			   
	             DAO.ps=DAO.conn.prepareStatement(requete);
	             DAO.ps.setString(1,e.getNOM());
	             DAO.ps.setString(2, e.getTYPE());
	             DAO.ps.setString(3, e.getCAPACITE());
	             DAO.ps.execute();
   
	           } catch (SQLException ex) {   System.out.print(" erreur Au niveau ajout Sall ");    }
 	}

    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
   /*========================================================================================================================*/
 	
 	@Override
 	public void Modifier(Salle e) 
 	{
 		SQL="Update salle set NOM =? ,TYPE =?,CAPACITE=? where ID =?"; 
  	   try {
  		 
              DAO.ps=DAO.conn.prepareStatement(SQL);
  	          DAO.ps.setString(1,e.getNOM());
  	          DAO.ps.setString(2, e.getTYPE());
  	          DAO.ps.setString(3, e.getCAPACITE());
  	          DAO.ps.setInt(4, e.getID());
              DAO.ps.execute();
  	     
            } catch (SQLException ex) {   System.out.print(" erreur Au niveau Modife salle ");    }
 		
 	}

    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
   /*========================================================================================================================*/
 	
 	@Override
 	public void Supprimer(int id)
 	{
 		SQL="DELETE FROM salle WHERE ID=?";
 	    
        try {
		   
              DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1 ,id);
              DAO.ps.execute();
   
           } catch (SQLException ex) {   System.out.print(" erreur supprimer  salle");    }
        
 	}

    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
   /*========================================================================================================================*/
 	
 	@Override
 	public ResultSet getAll() 
 	{
 		 SQL="SELECT  NOM,TYPE,CAPACITE from salle  order by ID";
   	   
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
              rs=DAO.ps.executeQuery();
              return rs;    
              
             } catch (SQLException ex) {   System.out.print(" erreur Au niveau get all salle ");   return null;   }
 	
 	}

    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
   /*========================================================================================================================*/
 	@Override
 	public Salle getByNom(String nom) 
 	{
 		
 		SQL="SELECT * FROM salle WHERE nom=?";
        
       try {
  	 
		      DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setString(1, nom);
	          rs=DAO.ps.executeQuery();
	     
		     if(rs.next())
		     {
		    	    s=new Salle()   ;
		    	    s.setID(rs.getInt("ID"));
		    	    s.setNOM(rs.getString("NOM"));
		    	    s.setTYPE(rs.getString("TYPE"));
		    	    s.setCAPACITE(rs.getString("CAPACITE"));
		    	    return s;	
		     }
		     else
		          return null;

          } catch (SQLException ex) {   System.out.print(" erreur Au niveau get by nom  salle   ");   return null;   }
       
 	}
    
    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
   /*========================================================================================================================*/

 	@Override
 	public ResultSet Find_ById(int id)
 	{  
 	  	  String n=String.valueOf(id); 		   
 		  n=n+"%";
 		  SQL="SELECT  NOM,TYPE,CAPACITE FROM salle where to_char(ID)like ?"; 
 		  
 	  	   try {
 	  		      DAO.ps=DAO.conn.prepareStatement(SQL);
 	  		      DAO.ps.setString(1, n);
 	              rs=DAO.ps.executeQuery();
 	             
 	              return rs;    
 	             
 	            } catch (SQLException ex) {   System.out.print(" erreur get salle(id) ");   return null;   }	  	   
 	}
 	
 	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/

 	 	public ResultSet Find_ByCapacite(int capacite)
 	 	{  
 	 	  	  String n=String.valueOf(capacite); 		   
 	 		  n=n+"%";
 	 		  
 	 		  SQL="SELECT  NOM,TYPE,CAPACITE FROM salle where to_char(CAPACITE) like  ?"; 
 	 		  
 	 	  	   try {
 	 	  		      DAO.ps=DAO.conn.prepareStatement(SQL);
 	 	  		      DAO.ps.setString(1, n);
 	 	              rs=DAO.ps.executeQuery();
 	 	             
 	 	              return rs;    
 	 	             
 	 	            } catch (SQLException ex) {   System.out.print(" erreur Find_ByCapacite(capa) ");   return null;   }	  	   
 	 	}
 	 	
 	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
   /*========================================================================================================================*/
 	
 	public ResultSet Find_ByType(String type)
 	{
 		  SQL="SELECT  NOM,TYPE,CAPACITE FROM salle where LOWER(TYPE) = ?";  
 		  
 	  	   try {
 	  		   
 	  		   DAO.ps=DAO.conn.prepareStatement(SQL);
 	  		   DAO.ps.setString(1, type);
 	           rs=DAO.ps.executeQuery();
 	             
 	           return rs;    
 	             
 	        } catch (SQLException ex)  {   System.out.print(" erreur Find_ByType  (nom) ");   return null;   }
 	}
 	
    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
   /*========================================================================================================================*/
 	
 	@Override
 	public ResultSet Find_ByNom(String nom)
 	{
 		  nom=nom+"%";
 		  SQL="SELECT  NOM,TYPE,CAPACITE FROM salle where NOM like ?";  
 		  
 	  	   try {
 	  		   
 	  		   DAO.ps=DAO.conn.prepareStatement(SQL);
 	  		   DAO.ps.setString(1, nom);
 	           rs=DAO.ps.executeQuery();
 	             
 	           return rs;    
 	             
 	        } catch (SQLException ex)  {   System.out.print(" erreur Au niveau get salle (nom) ");   return null;   }
 	  	   
 	}
 	
     /*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

     public Salle getById(int id)
     {
    	
    	 SQL="SELECT * FROM salle WHERE ID=?";
    	 
  	     try {
  	    	 
  		      DAO.ps=DAO.conn.prepareStatement(SQL);
  	          DAO.ps.setInt(1, id);
              rs=DAO.ps.executeQuery();
             
             if(rs.next())
             {
            	    s=new Salle()   ;
            	    s.setID(rs.getInt("ID"));
            	    s.setNOM(rs.getString("NOM"));
            	    s.setTYPE(rs.getString("TYPE"));
            	    s.setCAPACITE(rs.getString("CAPACITE"));
            	    
            	    return s;
             }
             else
                  return null;
  	
            } catch (SQLException ex)   {   System.out.print(" erreur Au niveau get by id  salle   ");   return null;   }
  	     
      }
 	
 	/*========================================================================================================================*/
    /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
     
 	public ArrayList<String> ListeDesSalles()
 	{
 		
 		ArrayList<String> tab=new ArrayList<String>();
          SQL="select nom from salle ";
      	 
    	   try {
    		      DAO.ps=DAO.conn.prepareStatement(SQL);
                 rs=DAO.ps.executeQuery();
               
               while(rs.next())
               {
             	  tab.add(rs.getString("nom"));
               }
    	
              } catch (SQLException ex)  {   System.out.print(" erreur liset DES salles    ");   return null;   }
 		
 		
 		return tab;
 	}
 	
     /*========================================================================================================================*/
     /*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/    
}
