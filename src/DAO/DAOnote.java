package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import MODEL.Note;

public class DAOnote extends DAO<Note>  {
	
	String SQL;
	Note n;
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	 public DAOnote()
	 {
		 n=new Note();
	 }

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	public void Ajouter(Note n) {
		
		 SQL= "INSERT INTO note(NUM,CLASSE,MATIERE,SIMESTRE,ORALE,DS1,DS2,OBSERVATION) VALUES(?,?,?,?,?,?,?,?)";

		   try {
			   
	             DAO.ps=DAO.conn.prepareStatement(SQL);
	             DAO.ps.setInt(1,n.getNUM());
	             DAO.ps.setInt(2, n.getCLASS());
	             DAO.ps.setInt(3,n.getMATIERE());
	             DAO.ps.setInt(4,n.getSIMESTRE());
	             DAO.ps.setString(5, n.getORALE());
	             DAO.ps.setString(6, n.getDS1());
	             DAO.ps.setString(7, n.getDS2());
	             DAO.ps.setString(8, n.getOBSERVATION());
	             
	             DAO.ps.execute();

	           } catch (SQLException ex) {   System.out.print(" erreur ajout note ");    }
		
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	public void Modifier(Note n) 
	{
		

	        SQL="Update note set ORALE=?,DS1=?,DS2 =?,OBSERVATION=? where id=?"; 
	  try {
		   
	         DAO.ps=DAO.conn.prepareStatement(SQL);
	         DAO.ps.setString(1, n.getORALE());
	         DAO.ps.setString(2, n.getDS1());
	         DAO.ps.setString(3, n.getDS2());
	         DAO.ps.setString(4, n.getOBSERVATION());
	         DAO.ps.setInt(5, n.getID());
	         
	         DAO.ps.execute();
	    
	       } catch (SQLException ex) {   System.out.print(" erreur modifier  note  ");    }	
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	public void Supprimer(int id) {
		
		
	}
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	public ResultSet getAll() {
		
		return null;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	
	public Note getById(int id) {
		
		return null;
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public Boolean  Note_class_DejaSaisir(int classe,int matiere,int simestre)
	{
		
		  SQL="select * from note where classe=? and simestre=? and matiere=? ";
	
		 try {
			      DAO.ps=DAO.conn.prepareStatement(SQL);
		          DAO.ps.setInt(1, classe);
		          DAO.ps.setInt(2, simestre);
		          DAO.ps.setInt(3, matiere);
	              rs=DAO.ps.executeQuery();
	           
	           if(rs.next())
	           {
	          	    return true;
	           }
	           else
	                return false;
		
	          } catch (SQLException ex) 
		                  {   System.out.print(" erreur note deja saisir ");   return false;   }
		
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	public Note GetNoteEleve(int num,int classe,int matiere,int simestre)
	{
	
		
		SQL="select * from note where num=? and classe=? and simestre=? and matiere=? ";
		
		 try {
			      DAO.ps=DAO.conn.prepareStatement(SQL);
			      DAO.ps.setInt(1, num);
		          DAO.ps.setInt(2, classe);
		          DAO.ps.setInt(3, simestre);
		          DAO.ps.setInt(4, matiere);
	              rs=DAO.ps.executeQuery();
	           
	           if(rs.next())
	           {
	        	 
	        	   n.setMATIERE(rs.getInt("matiere"));
	        	   n.setCLASS(rs.getInt("CLASSE"));
	        	   n.setID(rs.getInt("id"));
	        	   n.setNUM(rs.getInt("num"));
	        	   n.setSIMESTRE(rs.getInt("simestre"));
	        	   n.setORALE(rs.getString("ORALE"));
	        	   n.setDS1(rs.getString("DS1"));
	        	   n.setDS2(rs.getString("DS2"));
	        	   n.setOBSERVATION(rs.getString("OBSERVATION"));
	        	   
	        	   return n;
	           }
	           else
	                return null;
		
	          } catch (SQLException ex) 
		                  {   System.out.print(" erreur getnote eleve ");   return null;   }
	}
	

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public Note getByNom(String nom) {
		
		return null;
	}

	@Override
	public ResultSet Find_ById(int id) {
		
		return null;
	}

	@Override
	public ResultSet Find_ByNom(String nom) {
		
		return null;
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

}
