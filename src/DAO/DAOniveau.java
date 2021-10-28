package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Niveau;

public class DAOniveau extends DAO<Niveau> {

	Niveau N=null;
	String SQL;
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	  public Niveau getById(int id)
	    {
	 
	   	     SQL="SELECT * FROM CLASSE WHERE ID=?";

	 	     try {
	 	    	 
	 		      DAO.ps=DAO.conn.prepareStatement(SQL);
	 	          DAO.ps.setInt(1, id);
	              rs=DAO.ps.executeQuery();
	            
	            if(rs.next())
	            {
	           	    N=new Niveau()   ;
	           	    N.setID(rs.getInt("ID"));
	           	    N.setNOM(rs.getString("NOM"));
	           	    return N;
                 }
	            else
	                 return null;
	 	
	           } catch (SQLException ex) 
	 	                  {   System.out.print(" erreur Au niveau get by id   ");   return null;   }
	     }
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/ 
	@Override
	public ResultSet getAll() {
		
		String requete="SELECT * FROM Niveau order by id";
	 	   
	 	   try {
	 		       DAO.ps=DAO.conn.prepareStatement(requete);
	               rs=DAO.ps.executeQuery();
	            
	             return rs;    
	            
	           } catch (SQLException ex) 
	 	   {   System.out.print(" erruer getALL niveau  ");   return null;   }
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public Niveau getByNom(String nom) 
	{
		  SQL="SELECT * FROM NIVEAU WHERE nom=? ";
		  try {
		    	 
			      DAO.ps=DAO.conn.prepareStatement(SQL);
		          DAO.ps.setString(1, nom);
	              rs=DAO.ps.executeQuery();
		           if(rs.next())
		           {
		          	    N=new Niveau()   ;
		          	    N.setID(rs.getInt("ID"));
		          	    N.setNOM(rs.getString("NOM"));
		          	    return N;
		           }
		           else
		                return null;
		
	          } catch (SQLException ex) { System.out.print(" erreur getbynom (string)  ");   return null;   }
     }
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public ArrayList<String> ListeDesNiveau()
	{
		
		ArrayList<String> tab=new ArrayList<String>();
         SQL="select nom from niveau ";
     	 
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  tab.add(rs.getString("nom"));
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset Niveau    ");   return null;   }
		
		
		return tab;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Ajouter(Niveau o) {}
	@Override
	public void Modifier(Niveau o) {}
	@Override
	public void Supprimer(int id) {}
	@Override
	public ResultSet Find_ById(int id) {return null;}
	@Override
	public ResultSet Find_ByNom(String nom) {	return null;}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
}
