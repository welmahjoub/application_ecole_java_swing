package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import MODEL.Seance;

public class DAOseance extends DAO<Seance>{
	
	String SQL;
	
	/*
	 ID
	CLASSE
	MATIERE
	SALLE
	CIN
	HORAIRE
	JOUR
	*/
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	@Override
	public void Ajouter(Seance e) {

		   SQL= "INSERT INTO SEANCE(CLASSE,MATIERE,SALLE,CIN,HORAIRE,JOUR) VALUES(?,?,?,?,?,?)";

		   try {
			   
	             DAO.ps=DAO.conn.prepareStatement(SQL);
	             DAO.ps.setInt(1,e.getCLASSE());
	             DAO.ps.setInt(2,e.getMATIERE());
	             DAO.ps.setInt(3,e.getSALLE());
	             DAO.ps.setInt(4,e.getCIN());
	             DAO.ps.setInt(5,e.getHORAIRE());
	             DAO.ps.setInt(6,e.getJOUR());
	             DAO.ps.execute();
 
	           } catch (SQLException ex) {   System.out.print(" erreur Au niveau ajout seance ");    }
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	@Override
	public void Modifier(Seance e) 
	{
		
		   SQL="Update SEANCE set  MATIERE =?, SALLE =?, CIN =?, HORAIRE =?, JOUR =?  where ID =?"; 
		   try {
			   
	              DAO.ps=DAO.conn.prepareStatement(SQL);
		          DAO.ps.setInt(1,e.getMATIERE());
		          DAO.ps.setInt(2,e.getSALLE());
		          DAO.ps.setInt(3,e.getCIN());
		          DAO.ps.setInt(4,e.getHORAIRE());
		          DAO.ps.setInt(5,e.getJOUR());
		          DAO.ps.setInt(6,e.getID());
		      
	              DAO.ps.execute();
		     
	            } catch (SQLException ex) {   System.out.print(" erreur Au niveau Modifier seance  ");    }
		
		
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	@Override
	public void Supprimer(int id)
	{
		
		 SQL="DELETE FROM SEANCE WHERE ID=?";
	        try {
			   
	              DAO.ps=DAO.conn.prepareStatement(SQL);
	              DAO.ps.setInt(1 ,id);
	              DAO.ps.execute();
	   
	           } catch (SQLException ex) {   System.out.print(" erreur supprimer seance ");    }
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	public ArrayList<Seance> getALL(int classe)
	{
		ArrayList<Seance> tab=new ArrayList<Seance>();
        SQL="select * from SEANCE where CLASSE=? ";
    	 
  	   try {
  		      DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1,classe);
              rs=DAO.ps.executeQuery();
             while(rs.next())
             {	
            	 Seance s =new Seance();
            	 s.setID(rs.getInt("ID"));
            	 s.setCLASSE(rs.getInt("CLASSE"));
            	 s.setMATIERE(rs.getInt("MATIERE"));
            	 s.setSALLE(rs.getInt("SALLE"));
            	 s.setCIN(rs.getInt("CIN"));
            	 s.setHORAIRE(rs.getInt("HORAIRE"));
            	 s.setJOUR(rs.getInt("JOUR"));
            	 
           	    tab.add(s);
             }
  	
            } catch (SQLException ex)  {   System.out.print(" erreur liset Seance    ");   return null;   }
		
		
		return tab;
		
	}

	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	public ArrayList<Seance> getALLInstituteur(int cin)
	{
		ArrayList<Seance> tab=new ArrayList<Seance>();
        SQL="select * from SEANCE where cin=? ";
    	 
  	   try {
  		      DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1,cin);
              rs=DAO.ps.executeQuery();
             while(rs.next())
             {	
            	 Seance s =new Seance();
            	 s.setID(rs.getInt("ID"));
            	 s.setCLASSE(rs.getInt("CLASSE"));
            	 s.setMATIERE(rs.getInt("MATIERE"));
            	 s.setSALLE(rs.getInt("SALLE"));
            	 s.setCIN(rs.getInt("CIN"));
            	 s.setHORAIRE(rs.getInt("HORAIRE"));
            	 s.setJOUR(rs.getInt("JOUR"));
            	 
           	    tab.add(s);
             }
  	
            } catch (SQLException ex)  {   System.out.print(" erreur liset Seance    ");   return null;   }
		
		
		return tab;
		
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	@Override
	public ResultSet getAll() {
		
		return null;
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	@Override
	public Seance getById(int id) {
		
		return null;
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	@Override
	public Seance getByNom(String nom) {
	
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
	public ArrayList<String> ListeDesJours()
	{
		
		ArrayList<String> tab=new ArrayList<String>();
         SQL="select nom from jour ";
     	 
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  tab.add(rs.getString("nom"));
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset jours    ");   return null;   }
		
		
		return tab;
	}
    
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	public int getidSeance(Seance s)
	{
		
	   SQL="SELECT ID  FROM seance WHERE (CLASSE=?) and (MATIERE=?) and (SALLE=?) and (CIN=?) and (HORAIRE=?) and (JOUR=?) ";

	   try {
	    	 
		      DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setInt(1, s.getCLASSE());
	          DAO.ps.setInt(2, s.getMATIERE());
	          DAO.ps.setInt(3, s.getSALLE());
	          DAO.ps.setInt(4, s.getCIN());
	          DAO.ps.setInt(5, s.getHORAIRE());
	          DAO.ps.setInt(6, s.getJOUR());
               rs=DAO.ps.executeQuery();
           
              if(rs.next())
              {
                   int id_seance=rs.getInt("ID");
          	       return id_seance;
              }
              else
                  return -1;
              
          } catch (SQLException ex) 
	                  {   System.out.print(" erreur Au niveau getidseance   ");   return -1;   }
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	public ArrayList<String> ListeDesHoraires()
	{
		
		ArrayList<String> tab=new ArrayList<String>();
         SQL="select nom from horaire ";
     	 
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  tab.add(rs.getString("nom"));
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset horaires    ");   return null;   }
		
		
		return tab;
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

	public Seance getSeanceInstituteur(int cin,int horaire,int jour)
	{
         Seance c=null;
         SQL="select * from SEANCE where  ( CIN=? ) and  ( HORAIRE = ? ) and  ( JOUR = ? ) ";
     	 
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setInt(1, cin);
	          DAO.ps.setInt(2, horaire);
	          DAO.ps.setInt(3, jour);
	       
              rs=DAO.ps.executeQuery();
              
              if(rs.next())
              {
            	 c=new Seance();
            	 c.setCIN(rs.getInt("CIN"));
            	 c.setCLASSE(rs.getInt("CLASSE"));
            	 c.setMATIERE(rs.getInt("MATIERE"));
            	 c.setJOUR(rs.getInt("JOUR"));
            	 c.setHORAIRE(rs.getInt("HORAIRE"));
            	 c.setSALLE(rs.getInt("SALLE"));
            	 c.setID(rs.getInt("ID"));
            	 
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur getSeance  insitiuteur  ");   return null;   }
		
		
		return c;
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

	public Seance getSeanceClasse(int classe,int horaire,int jour)
	{
         Seance c=null;
         SQL="select * from SEANCE where  ( CLASSE=? ) and  ( HORAIRE = ? ) and  ( JOUR = ? ) ";
     	 
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setInt(1, classe);
	          DAO.ps.setInt(2, horaire);
	          DAO.ps.setInt(3, jour);
	       
              rs=DAO.ps.executeQuery();
              
              if(rs.next())
              {
            	 c=new Seance();
            	 c.setCIN(rs.getInt("CIN"));
            	 c.setCLASSE(rs.getInt("CLASSE"));
            	 c.setMATIERE(rs.getInt("MATIERE"));
            	 c.setJOUR(rs.getInt("JOUR"));
            	 c.setHORAIRE(rs.getInt("HORAIRE"));
            	 c.setSALLE(rs.getInt("SALLE"));
            	 c.setID(rs.getInt("ID"));
            	 
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur getSeance  class  ");   return null;   }
		
		
		return c;
	}
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

	public Seance getSeanceSalle(int salle,int horaire,int jour)
	{
         Seance c=null;
         SQL="select * from SEANCE where  ( SALLE=? ) and  ( HORAIRE = ? ) and  ( JOUR = ? ) ";
     	 
   	   try {
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setInt(1, salle);
	          DAO.ps.setInt(2, horaire);
	          DAO.ps.setInt(3, jour);
	       
              rs=DAO.ps.executeQuery();
              
              if(rs.next())
              {
            	 c=new Seance();
            	 c.setCIN(rs.getInt("CIN"));
            	 c.setCLASSE(rs.getInt("CLASSE"));
            	 c.setMATIERE(rs.getInt("MATIERE"));
            	 c.setJOUR(rs.getInt("JOUR"));
            	 c.setHORAIRE(rs.getInt("HORAIRE"));
            	 c.setSALLE(rs.getInt("SALLE"));
            	 c.setID(rs.getInt("ID"));
            	 
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur getSeance  salle  ");   return null;   }
		
		
		return c;
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
}
