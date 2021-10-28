package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import MODEL.Conseil;

public class DAOconseil extends DAO<Conseil>{

	Conseil c=null;
	String SQL;
	
	/*
	 * ID
TEXT
DAT
CLASS*/
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Ajouter(Conseil e) 
	{
	
		SQL= "INSERT INTO CONSEIL(TEXT,DAT,CLASS) VALUES(?,?,?)";

		   try {
			   
	             DAO.ps=DAO.conn.prepareStatement(SQL);
	             DAO.ps.setString(1,e.getTEXT());
	             DAO.ps.setString(2, e.getDATE());
	             DAO.ps.setInt(3, e.getCLASS());
	             
	             DAO.ps.execute();

	           } catch (SQLException ex) {   System.out.print(" erreur Au niveau ajout conseil ");}
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Modifier(Conseil e) 
	{
		  SQL="Update CONSEIL set TEXT =? ,DAT =?,CLASS=? where ID =?"; 
		   try {
			   
	              DAO.ps=DAO.conn.prepareStatement(SQL);
		          DAO.ps.setString(1,e.getTEXT());
		          DAO.ps.setString(2, e.getDATE());
		          DAO.ps.setInt(3, e.getCLASS());
		          DAO.ps.setInt(4, e.getID());
		          
	              DAO.ps.execute();
		     
	            } catch (SQLException ex) {   System.out.print(" erreur Au niveau Modifier conseil ");    }	
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Supprimer(int id) 
	{
		
		 SQL="DELETE FROM CONSEIL WHERE ID=?";
	        try {
			   
	              DAO.ps=DAO.conn.prepareStatement(SQL);
	              DAO.ps.setInt(1 ,id);
	              DAO.ps.execute();
	   
	           } catch (SQLException ex) {   System.out.print(" erreur supprimer conseil ");    }
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public ResultSet getAll() 
	{
		String requete="SELECT con.DAT,c.nom,con.TEXT from CONSEIL con,CLASSE c "
				+ " where c.id=con.class";
	 	   
	 	   try {
	 		     DAO.ps=DAO.conn.prepareStatement(requete);
	             rs=DAO.ps.executeQuery();
	            
	             return rs;    
	            
	           } catch (SQLException ex) 
	 	   {   System.out.print(" erruer getALL conseil  ");   return null;   }	
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	public ResultSet getAll_ByClass(int classe) 
	{
		String requete="SELECT con.DAT,c.nom,con.TEXT from CONSEIL con,CLASSE c "
				+ " where ( c.id=con.class ) and (con.class=?)";
	 	   
	 	   try {
	 		      DAO.ps=DAO.conn.prepareStatement(requete);
	 		      DAO.ps.setInt(1, classe);
	              rs=DAO.ps.executeQuery();
	            
	             return rs;    
	            
	           } catch (SQLException ex) 
	 	   {   System.out.print(" erruer getALL conseil by class  ");   return null;   }	
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public Conseil getById(int id)
	{
		
		SQL="SELECT * FROM CONSEIL WHERE ID=?";

	     try {
	    	 
		      DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setInt(1, id);
             rs=DAO.ps.executeQuery();
           
           if(rs.next())
           {
          	    c=new Conseil() ;
          	    c.setID(rs.getInt("ID"));
          	    c.setTEXT(rs.getString("TEXT"));
          	    c.setDATE(rs.getString("DAT"));
          	    c.setCLASS(rs.getInt("class"));
          	    
          	    return c;

           }
           else
                return null;
	
          } catch (SQLException ex) 
	                  {   System.out.print(" erreur Au niveau get by id   ");   return null;   }
	     
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public Conseil getConseil(String date,int classe)
	{
		SQL="SELECT * FROM CONSEIL WHERE (CLASS=?) and (DAT=?)";

	     try {
	    	 
		      DAO.ps=DAO.conn.prepareStatement(SQL);
		      DAO.ps.setInt(1, classe);
	          DAO.ps.setString(2, date);
              rs=DAO.ps.executeQuery();
          
          if(rs.next())
          {
         	    c=new Conseil() ;
         	    c.setID(rs.getInt("ID"));
         	    c.setTEXT(rs.getString("TEXT"));
         	    c.setDATE(rs.getString("DAT"));
         	    c.setCLASS(rs.getInt("CLASS"));
         	    
         	    return c;

          }
          else
               return null;
	
         } catch (SQLException ex) 
	                  {   System.out.print(" erreur Au niveau getconseil   ");   return null;   }
	}
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public Conseil getByNom(String nom) {
		
		return null;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public ResultSet Find_ById(int id) {
		
		return null;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public ResultSet Find_ByNom(String nom) {
		
		
		return null;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
}
