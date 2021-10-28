package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Matiere;


public class DAOmatier extends DAO<Matiere>{
	
	private  String Requete;
	private Matiere m;
	
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

	@Override
	public void Ajouter(Matiere e) 
	{
		Requete=" INSERT INTO MATIERE (nom,niveau,coef,HAS_NOTE_ORALE) VALUES (?,?,?,?)";
		
		try {
			   
	            DAO.ps=DAO.conn.prepareStatement(Requete);
	            DAO.ps.setString(1,e.getNOM());
	            DAO.ps.setInt(2,e.getNIVEAU());
	            DAO.ps.setString(3,e.getCOEF());
	            DAO.ps.setInt(4, e.getHas_Note_Orale());
	            
	            DAO.ps.execute();

	         } catch (SQLException ex) {   System.out.print(" erreur ajouter matiere ");    }
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Modifier(Matiere e)
	{
		
		Requete="Update MATIERE set NOM =? ,niveau =?,coef=? ,HAS_NOTE_ORALE=? where  ID =?";
		
        try {
			   
	              DAO.ps=DAO.conn.prepareStatement(Requete);
		          DAO.ps.setString(1,e.getNOM());
		          DAO.ps.setInt(2,e.getNIVEAU());
		          DAO.ps.setString(3,e.getCOEF());
		          DAO.ps.setInt(4, e.getHas_Note_Orale());
		          DAO.ps.setInt(5, e.getID());
	              DAO.ps.execute();
	     
	          } catch (SQLException ex) {   System.out.print(" erreur modifier matiere  ");    }	
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public void Supprimer(int id) 
	{
		
		   Requete="DELETE FROM MATIERE WHERE ID=?";
		   
	        try {
			   
	              DAO.ps=DAO.conn.prepareStatement(Requete);
	              DAO.ps.setInt(1 ,id);
	              DAO.ps.execute();
	   
	           } catch (SQLException ex) {   System.out.print(" erreur supprimer matiere  ");    }
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public ResultSet getAll() 
	{		
		 Requete="SELECT m.nom matiere,m.coef coefficient ,n.nom NIVEAU FROM MATIERE m,niveau n"
		 		+ " where (m.niveau=n.id) order by m.ID";
	 	   
	 	 try {
	 		     DAO.ps=DAO.conn.prepareStatement(Requete);
	             rs=DAO.ps.executeQuery();
	            
	             return rs;    
	            
	           } catch (SQLException ex) {   System.out.print(" erruer getALL matier  ");   return null;   }	
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public Matiere getByNom(String nom)
	{
	
		m=new Matiere();
	    Requete="select * from MATIERE where nom=?";
	 
	     try {
	    	 
		      DAO.ps=DAO.conn.prepareStatement(Requete);
		      DAO.ps.setString(1, nom);
	          rs=DAO.ps.executeQuery();
         
	         if(rs.next())
	         {
	        	    m=new Matiere();
	        	    m.setID(rs.getInt("ID"));
	        	    m.setNOM(rs.getString("NOM"));
	        	    m.setNIVEAU(rs.getInt("NIVEAU"));
	        	    m.setCOEF(rs.getString("coef"));
	        	    m.setHas_Note_Orale(rs.getInt("HAS_NOTE_ORALE"));
	        	    
	        	    return m;
	         }
	         else
	              return null;
        } catch (SQLException ex) {   System.out.print(" erreur get by nom  matiere  ");   return null;   }	
	}

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
	@Override
	public ResultSet Find_ByNom(String nom) 
	{
		 nom=nom+"%";
		 
		 Requete="SELECT m.nom matiere,m.coef Coefficient,n.nom  Niveau FROM MATIERE m,niveau n"
		 		+ "   where ( m.niveau =n.id) and (m.nom like ?)  order by m.ID"; 
	 	  try {

	 		   DAO.ps=DAO.conn.prepareStatement(Requete);
	 		   DAO.ps.setString(1, nom);
	           rs=DAO.ps.executeQuery();
	            
	           return rs;    
	            
	           } catch (SQLException ex) 
	 	   {   System.out.print(" erruer find by nom  matier  ");   return null;   } 	   
	}   

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	
    public ResultSet FindByNiveau(int  niveau)
    {
 	   
 	   Requete="SELECT m.nom matiere,m.coef Coefficient,n.nom niveau   FROM MATIERE m,niveau n"
 	   		+ " where    m.niveau =n.id and m.niveau=?";
 	   
 	   try {
 		   
 		     DAO.ps=DAO.conn.prepareStatement(Requete);		   
 		     DAO.ps.setInt(1, niveau);
             rs=DAO.ps.executeQuery();
            
             return rs;    
            
           } catch (SQLException ex) {   System.out.print(" erreur findByniveau  (int id,int idniv) ");   return null;   }
    }
    

    
	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

    public Matiere getById(int id)
    {
        m=new Matiere();
   	    Requete="select * from MATIERE where id=?";
   	 
 	     try {
 	    	 
 		      DAO.ps=DAO.conn.prepareStatement(Requete);
 	          DAO.ps.setInt(1, id);
              rs=DAO.ps.executeQuery();
            
            if(rs.next())
            {
           	    m=new Matiere();
           	    m.setID(rs.getInt("ID"));
           	    m.setNOM(rs.getString("NOM"));
           	    m.setCOEF(rs.getString("coef"));
           	    m.setNIVEAU(rs.getInt("NIVEAU")); 
           	    m.setHas_Note_Orale(rs.getInt("HAS_NOTE_ORALE"));
           	    return m;
            }
            else
                 return null;
           } catch (SQLException ex)  {   System.out.print(" erreur get by id matiere  ");   return null;   }
     }

	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
	public ArrayList<String> ListeDesMatiereByNiveau(int niveau)
	{
		
		ArrayList<String> tab=new ArrayList<String>();
         Requete="select nom from matiere where niveau = ?  ";
     	 
   	   try {
   	    	 
   		      DAO.ps=DAO.conn.prepareStatement(Requete);
   		      DAO.ps.setInt(1, niveau);
              rs=DAO.ps.executeQuery();
              
              while(rs.next())
              {
            	  tab.add(rs.getString("nom"));
            	 
              }
   	
             } catch (SQLException ex)  {   System.out.print(" erreur liset matiere by niveau    ");   return null;   }
		
		
		return tab;
	}
	
    /*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
	@Override
	public ResultSet Find_ById(int id) {
		
		return null;
	}
	/*========================================================================================================================*/
   	/*========================================= Fin                           ================================================*/
   	/*========================================================================================================================*/
	
}
