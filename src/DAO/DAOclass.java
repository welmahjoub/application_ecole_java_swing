package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Classe;


public class DAOclass extends DAO<Classe>{
	
	Classe c=null;
	String Requete;
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Ajouter(Classe e) {
		
		       Requete= "INSERT INTO CLASSE(nom,niveau) VALUES(?,?)";

		   try {
			   
	             DAO.ps=DAO.conn.prepareStatement(Requete);
	             DAO.ps.setString(1,e.getNOM());
	             DAO.ps.setInt(2, e.getNIVEAU());
	             DAO.ps.execute();
 
	           } catch (SQLException ex) {   System.out.print(" erreur Au niveau ajout class ");    }
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Modifier(Classe e) 
	{
		
		         Requete="Update CLASSE set NOM =? ,niveau =? where ID =?"; 
		   try {
			   
	              DAO.ps=DAO.conn.prepareStatement(Requete);
		          DAO.ps.setString(1,e.getNOM());
		          DAO.ps.setInt(2, e.getNIVEAU());
		          DAO.ps.setString(3, String.valueOf(e.getID()));
	              DAO.ps.execute();
		     
	            } catch (SQLException ex) {   System.out.print(" erreur Au niveau Modifier class ");    }	
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Supprimer(int id) 
	{
		   Requete="DELETE FROM CLASSE WHERE ID=?";
	        try {
			   
	              DAO.ps=DAO.conn.prepareStatement(Requete);
	              DAO.ps.setInt(1 ,id);
	              DAO.ps.execute();
	   
	           } catch (SQLException ex) {   System.out.print(" erreur supprimer class ");    }
		
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public ResultSet getAll() {
		
		String requete="SELECT c.nom as classe,n.nom niveau FROM classe c,niveau n where c.niveau=n.id order by c.id";
	 	   
	 	   try {
	 		     DAO.ps=DAO.conn.prepareStatement(requete);
	             rs=DAO.ps.executeQuery();
	            
	             return rs;    
	            
	           } catch (SQLException ex) 
	 	   {   System.out.print(" erruer getALL class1  ");   return null;   }
	}
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public Classe getByNom(String nom) {
		
		      Requete="SELECT * FROM CLASSE WHERE nom=? ";
	     try {
	    	 
		      DAO.ps=DAO.conn.prepareStatement(Requete);
	          DAO.ps.setString(1, nom);
              rs=DAO.ps.executeQuery();
           
           if(rs.next())
           {
           	    c=null;
          	    c=new Classe()   ;
          	    c.setID(rs.getInt("ID"));
          	    c.setNOM(rs.getString("NOM"));
          	    c.setNIVEAU(rs.getInt("NIVEAU"));
          	    
          	    return c;

           }
           else
                return null;
	
          } catch (SQLException ex) 
	                  {   System.out.print(" erreur getbynom (string)  ");   return null;   }
		
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
		
		
		String requete="SELECT c.nom as classe,n.nom niveau FROM classe c,niveau n "
				+ "where  (c.niveau=n.id) and  c.nom like ? order by c.id"; 
	 	   try {
	 		   
	 		   nom=nom+"%";
	 		   DAO.ps=DAO.conn.prepareStatement(requete);
	 		   DAO.ps.setString(1, nom);
	           rs=DAO.ps.executeQuery();
	            
	           return rs;    
	            
	           } catch (SQLException ex) 
	 	   {   System.out.print(" erruer find by nom  class  ");   return null;   }
		
	}

	
	
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

    
    public ResultSet FindByNiveau(int niveau)
    {
 	   
    	   Requete="SELECT c.nom as classe,n.nom niveau  FROM CLASSE c, niveau n "
    	   		+ " where c.niveau =n.id  and niveau=? order by c.ID";
 	   
 	   try {
 		   
 		    DAO.ps=DAO.conn.prepareStatement(Requete);
 		    DAO.ps.setInt(1, niveau);
 		
            rs=DAO.ps.executeQuery();
            
            return rs;    
            
           } catch (SQLException ex) 
 	   {   System.out.print(" erreur FindByNiveau (id) ");   return null;   }
 	   
 	  
    }
    
    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

    public Classe getById(int id)
    {
 
   	     Requete="SELECT * FROM CLASSE WHERE ID=?";

 	     try {
 	    	 
 		      DAO.ps=DAO.conn.prepareStatement(Requete);
 	          DAO.ps.setInt(1, id);
              rs=DAO.ps.executeQuery();
            
            if(rs.next())
            {
           	    c=new Classe()   ;
           	    c.setID(rs.getInt("ID"));
           	    c.setNOM(rs.getString("NOM"));
           	    c.setNIVEAU(rs.getInt("NIVEAU"));
           	    
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
	public ArrayList<String> ListeDesClasseByNiveau(int niveau)
	{
		
		ArrayList<String> tab=new ArrayList<String>();
         Requete="select nom from classe where niveau = ?  ";
     	 
   	   try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(Requete);
   		      DAO.ps.setInt(1, niveau);
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  tab.add(rs.getString("nom"));
            	 
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset classe by niveau    ");   return null;   }
		
		
		return tab;
	}
	
    /*========================================================================================================================*/
 	/*=========================================       Fin                    ================================================*/
 	/*========================================================================================================================*/
	
	public boolean ClassContientDesEleves(int num)
	{

  	     Requete="SELECT * FROM ELEVE WHERE class=?";

	     try {
	    	 
		      DAO.ps=DAO.conn.prepareStatement(Requete);
	          DAO.ps.setInt(1, num);
             rs=DAO.ps.executeQuery();
           
           if(rs.next())
           {
          	   return true;

           }
           else
                return false;
	
          } catch (SQLException ex) 
	                  {   System.out.print(" erreur classcontient des eleves;   ");   return false;   }
	}
	
	/*========================================================================================================================*/
	/*=========================================       Fin                    ================================================*/
	/*========================================================================================================================*/
	  
  
}
