package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import MODEL.Absence;

public class DAOabsence extends DAO<Absence> {
	
	 private  String SQL;
	 
	 /*
	  * ID
	NUM
	CLASSE
	DAT
	HORAIRE
	VALEUR
    */
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Ajouter(Absence e) {
		
	      SQL= "INSERT INTO absence (NUM,CLASSE,DAT,HORAIRE,VALEUR) VALUES(?,?,?,?,?)";

			   try {
				   
		             DAO.ps=DAO.conn.prepareStatement(SQL);
		             DAO.ps.setInt(1,e.getNUM());
		             DAO.ps.setInt(2,e.getCLASSE());
		             DAO.ps.setString(3,e.getDATE());
		             DAO.ps.setInt(4,e.getHORAIRE());
		             DAO.ps.setString(5,e.getVALEUR());
		             DAO.ps.execute();
	 
		           } catch (SQLException ex) {   System.out.print(" erreur Au niveau ajout absence ");    }
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Modifier(Absence e) {
		
		 SQL="Update ABSENCE set  VALEUR = ? where ID =?"; 
		   try {
			   
	              DAO.ps=DAO.conn.prepareStatement(SQL);
		          DAO.ps.setString(1,e.getVALEUR());
		          DAO.ps.setInt(2,e.getID());
	              DAO.ps.execute();
		     
	            } catch (SQLException ex) {   System.out.print(" erreur Au niveau Modifier absence  ");    }
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public void Supprimer(int id) {
		
		SQL="DELETE FROM ABSENCE WHERE ID=?";
        try {
		   
              DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1 ,id);
              DAO.ps.execute();
   
           } catch (SQLException ex) {   System.out.print(" erreur supprimer absence ");    }
        
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
	public Absence getById(int id) {
		
		return null;
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	@Override
	public Absence getByNom(String nom) {
		
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
	
	public ArrayList<Absence> getAll(int num,int classe,String Date)
	{
		ArrayList<Absence> tab=new ArrayList<Absence>();
 		
        SQL="select * from ABSENCE   where  (NUM = ?) and  (CLASSE = ?)  and  (DAT = ?)  order by HORAIRE";
     	 
   	try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
   		      DAO.ps.setInt(1, num);
   		      DAO.ps.setInt(2, classe);
   		      DAO.ps.setString(3, Date);
   		     
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  Absence c=new Absence();
            	  c.setID(rs.getInt("ID"));
            	  c.setNUM(rs.getInt("NUM"));
            	  c.setDATE(rs.getString("DAT"));
            	  c.setCLASSE(rs.getInt("CLASSE"));
            	  c.setHORAIRE(rs.getInt("HORAIRE"));
            	  c.setVALEUR(rs.getString("VALEUR"));
            	  
            	 tab.add(c);
              }
           } catch (SQLException ex)  {   System.out.print(" erreur liset des absences      ");   return null;   }
		return tab;
	}

	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public Boolean  Absence_class_DejaSaisir(int classe,String  Dat)
	{
		
		  SQL="select * from ABSENCE  where classe=? and DAT=? ";
	
		 try {
			      DAO.ps=DAO.conn.prepareStatement(SQL);
		          DAO.ps.setInt(1, classe);
		          DAO.ps.setString(2, Dat);
	              rs=DAO.ps.executeQuery();
	           
	           if(rs.next())
	           {
	          	    return true;
	           }
	           else
	                return false;
		
	          } catch (SQLException ex) 
		                  {   System.out.print(" erreur Absence deja saisir ");   return false;   }
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public int getidAbsence(Absence s)
	{
		
	   SQL="SELECT ID  FROM   ABSENCE  WHERE (NUM=?) and (CLASSE=?) and (DAT=?) and (HORAIRE=?) ";

	   try {
	    	 
		      DAO.ps=DAO.conn.prepareStatement(SQL);
	          DAO.ps.setInt(1, s.getNUM());
	          DAO.ps.setInt(2, s.getCLASSE());
	          DAO.ps.setString(3, s.getDATE());
	          DAO.ps.setInt(4, s.getHORAIRE());
              rs=DAO.ps.executeQuery();
           
              if(rs.next())
              {
                   int id_absence=rs.getInt("ID");
          	       return id_absence;
              }
              else
                  return -1;
              
          } catch (SQLException ex) {   System.out.print(" erreur Au niveau getid Absence    ");   return -1;   }
	   
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public ArrayList<String> ListeDesAbsence_ByEleve(int num)
	{
		
		ArrayList<String> tab=new ArrayList<String>();
         SQL="select a.DAT DAT,h.nom  HORAIRE from ABSENCE a,HORAIRE h where( NUM = ? ) and (h.id=a.horaire ) and ( a.valeur like ?) ";
     	 
   	   try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(SQL);
   		      DAO.ps.setInt(1, num);
   		      DAO.ps.setString(2, "%a%");
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  String dat=rs.getString("DAT");
            	  String h=rs.getString("HORAIRE");
            	  
            	  tab.add(dat + "/" + h);
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset Absence by eleve ");   return null;   }
   	   
		return tab;
	}
	
	
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public void SupprimerListeAbsence(String Dat)
	{
		SQL="DELETE FROM ABSENCE WHERE DAT=?";
        try {
		   
              DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setString(1, Dat);
              DAO.ps.execute();
   
           } catch (SQLException ex) {   System.out.print(" erreur supprimer Journe ");    }
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
}
