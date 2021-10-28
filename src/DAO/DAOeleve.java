package DAO;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Eleve;

public class DAOeleve extends DAO<Eleve> {
	
	 
	 private  String SQL;
	 private  Eleve e;
	  
 	/*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

 	@Override
 	public void Ajouter(Eleve e) 
 	{
 		
 	     SQL=" INSERT INTO ELEVE(NUM,DATE_INSC,NOM,PRENOM,DAT_NAIS,LIEU_NAIS,SEXE,ADRESS,NIVEAU"
     	 		+ ",CIN_PERE,NOM_PERE,ADRESS_PERE,TEL_PERE,CIN_MERE,NOM_MERE,ADRESS_MERE,TEL_MERE,IMAGE)"
     	 		+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		 
 		 
 		try {
 			    			
 			  InputStream img=null;
 			  if(e.getPath()!=null)
 			  img=new FileInputStream(new File(e.getPath()));
 
 	          DAO.ps= DAO.conn.prepareStatement(SQL);
 	          DAO.ps.setInt(1,e.getNum());  
 	          DAO.ps.setString(2,e.getDate_insc());
 	          DAO.ps.setString(3,e.getNom()); 
 	          DAO.ps.setString(4,e.getPrenom());
 	          DAO.ps.setString(5,e.getDate_nais());
 	          DAO.ps.setString(6,e.getLieu_nais());
 	          DAO.ps.setString(7,e.getSexe());
 	          DAO.ps.setString(8,e.getAdress());
 	          DAO.ps.setInt(9, e.getNIVEAU());
 	          DAO.ps.setString(10, e.getCin_pere());
 	          DAO.ps.setString(11,e.getNom_pere());
 	          DAO.ps.setString(12,e.getAdress_pere());
 	          DAO.ps.setString(13 ,e.getTel_pere());
 	          DAO.ps.setString(14 ,e.getCin_mere());
 	          DAO.ps.setString(15,e.getNom_mere());
 	          DAO.ps.setString(16,e.getAdress_mere());
 	          DAO.ps.setString(17 ,e.getTel_mere());
 	          DAO.ps.setBlob(18, img);
 	          DAO.ps.execute();
      
 	       } catch (SQLException ex) {   System.out.print(" erreur ajout elev "); 
 	       } catch (FileNotFoundException e1) {System.out.println("erreur de la convertion image");} 
 	}
 	
 	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/

 	@Override
 	public void Modifier(Eleve e)
 	{
 	    SQL="Update ELEVE set  NOM =?,PRENOM =?,DATE_INSC =?, DAT_NAIS =?,LIEU_NAIS=? "
 		   		+ ", SEXE =? ,ADRESS =? , NIVEAU=?, CIN_PERE=? ,NOM_PERE =?, ADRESS_PERE =?, TEL_PERE=?"
 		   		+ ", CIN_MERE =? ,NOM_MERE=?, ADRESS_MERE=?,TEL_MERE=? ,IMAGE=? where NUM =?";
 		try {
 			   
 			    InputStream img=null;
 			    if(e.getPath()!=null)
 			    img=new FileInputStream(new File(e.getPath()));

 	            DAO.ps=DAO.conn.prepareStatement(SQL);
 	            DAO.ps.setString(1,e.getNom());
 	            DAO.ps.setString(2,e.getPrenom());
 	            DAO.ps.setString(3,e.getDate_insc());
 	            DAO.ps.setString(4,e.getDate_nais());
 	            DAO.ps.setString(5,e.getLieu_nais());
 	            DAO.ps.setString(6,e.getSexe());
 	            DAO.ps.setString(7,e.getAdress());
 	            DAO.ps.setInt(8, e.getNIVEAU());
 	            DAO.ps.setString(9,e.getCin_pere());
 	            DAO.ps.setString(10,e.getNom_pere());
 	            DAO.ps.setString(11,e.getAdress_pere());
 	            DAO.ps.setString(12,e.getTel_pere());
 	            DAO.ps.setString(13,e.getCin_mere());
 	            DAO.ps.setString(14,e.getNom_mere());
 	            DAO.ps.setString(15,e.getAdress_mere());
 	            DAO.ps.setString(16,e.getTel_mere());  
 	            DAO.ps.setBlob(17,img);
 	            DAO.ps.setInt(18,e.getNum());
 	            DAO.ps.execute();
      
 	           } catch (SQLException ex) {   System.out.print(" erreur au nivea modfier elev"); 
 	           } catch (FileNotFoundException e1) {System.out.println(" erreur au niveau daoeleve convertion image ");} 
 	}
 	
 	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/

 	@Override
 	public void Supprimer(int id) 
 	{
 		 SQL="DELETE FROM ELEVE WHERE NUM=?";
 	    
        try {
		   
              DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1 ,id);
              DAO.ps.execute();
    
            } catch (SQLException ex) {   System.out.print(" erreur au niveau suppimer elev  ");    }	
 	}
 	
 	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
 	
 	@Override
 	public ResultSet getAll()
 	{
 		
 		SQL="SELECT  e.NUM,e.NOM||'  ' ||e.PRENOM  NOM,n.nom  niveau FROM ELEVE e,niveau n "
 				+ "where e.niveau=n.id order by e.num";
 		   
 		try {
 			
 			   DAO.ps=DAO.conn.prepareStatement(SQL);
 	           rs=DAO.ps.executeQuery();
 	           
 	           return rs;    
 	           
 	          } catch (SQLException ex) {   System.out.print(" erreur get all eleve ");   return null;   }	
 	}

 	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
 	
 	@Override
 	public ResultSet Find_ById(int id)
 	{
 		 
 		 String n=String.valueOf(id); 
  	     n=n+"%";
		SQL="SELECT  e.NUM,e.NOM||'   ' ||e.PRENOM  NOM, n.nom  niveau FROM ELEVE e,niveau n where e.niveau=n.id "
				+ " and   to_char(e.num) like ? order by e.num";

 	   try {
 		   
 		      DAO.ps=DAO.conn.prepareStatement(SQL);
 		      DAO.ps.setString(1, n);
              rs=DAO.ps.executeQuery();
            
              return rs;    
            
           } catch (SQLException ex) 
 	   {   System.out.print(" erreur get eleve (id) ");   return null;   }
 	}

 	/*========================================================================================================================*/
 	/*========================================= 2) fonction  ================================================*/
 	/*========================================================================================================================*/
 	
 	@Override
 	public ResultSet Find_ByNom(String nom)
 	{
        nom=nom+"%";		   
 		 SQL="SELECT  e.NUM,e.NOM||'  '||e.PRENOM NOM,n.nom  niveau FROM ELEVE e ,niveau n"
 		 		+ " where e.niveau=n.id and (e.NOM like ? or e.PRENOM like ? ) order by e.num";
	   try {
		   
		   DAO.ps=DAO.conn.prepareStatement(SQL);
		   DAO.ps.setString(1, nom);
		   DAO.ps.setString(2, nom);
           rs=DAO.ps.executeQuery();
           
           return rs;    
           
          } catch (SQLException ex)  {   System.out.print(" erreur find bynom (string) ");   return null;   }	
 	}
   /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

   public ResultSet Find_AllEleves_ByClass(int id_class)
   {
	   
	   SQL="SELECT  e.NUM,e.NOM,e.PRENOM,c.NOM class ,n.nom  niveau FROM ELEVE e,classe c,niveau n "
	   		+ "where( e.niveau=n.id )and (e.CLASS =?) and (e.CLASS=c.ID)  order by e.num";
	   
	   try {
		   
		   DAO.ps=DAO.conn.prepareStatement(SQL);
		   DAO.ps.setInt(1, id_class);
           rs=DAO.ps.executeQuery();
           
           return rs;    
           
          } catch (SQLException ex) 
	   {   System.out.print(" erreur get all eleve par class");   return null;   }
   }
   
    /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/
   
   public ResultSet Find_Eleve_By_class(int num,int id_class)
   {
	   String n=String.valueOf(num);
	   n=n+"%";
	    
	   SQL="SELECT  e.NUM,e.NOM,e.PRENOM,c.NOM class,n.nom niveau FROM ELEVE e,classe c ,niveau n"
	   		+ " where e.niveau=n.id  and (e.CLASS =?) and (e.CLASS=c.ID) and ( to_char(e.num) like ?) order by e.num";
	   try {
		   
			   DAO.ps=DAO.conn.prepareStatement(SQL);	   
			   DAO.ps.setInt(1, id_class);
			   DAO.ps.setString(2,n);
	           rs=DAO.ps.executeQuery();
           
               return rs;    
           
          } catch (SQLException ex) {   System.out.print(" erreur get eleve (id,idclass) ");   return null;   }
   }
   
   /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

   public ResultSet Find_Eleve_No_Affecter(int num,int niveau)
   {
	   
	   String n=String.valueOf(num);
	    n=n+"%";
	    
	   SQL="SELECT  e.NUM,e.NOM,e.PRENOM, n.nom niveau  FROM ELEVE e ,niveau n"
	   		+ " where e.niveau=n.id  and (e.class is null)  and ( to_char(e.num) like ? ) and (e.niveau=?) order by e.num";
	   
	   try {
		   
			   DAO.ps=DAO.conn.prepareStatement(SQL);
			   DAO.ps.setString(1,n);
			   DAO.ps.setInt(2,niveau);
	           rs=DAO.ps.executeQuery();
	           
	           return rs;    
           
          } catch (SQLException ex)  {   System.out.print(" erreur get eleve (id) no efectuer ");   return null; } 
   }
   
    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

    public ResultSet Find_AllEleves_No_Affecte(int niveau)
    {
	   
	   SQL="SELECT  e.NUM,e.NOM,e.PRENOM,n.nom niveau  FROM ELEVE e ,niveau n where e.niveau=n.id "
	       +" and (e.class is null)  and (e.niveau=?)order by num";
	   
	   try {
		    
			   DAO.ps=DAO.conn.prepareStatement(SQL);
			   DAO.ps.setInt(1, niveau);
	           rs=DAO.ps.executeQuery(); 
	          
	           return rs;    
          
         } catch (SQLException ex) {   System.out.print(" erreur get all eleve  no affecte ");   return null;   } 
    }
  
    /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
 
   public ResultSet Find_Eleve_No_Affecter(String nom,int niveau)
   {
	   nom=nom+"%";
	   
	  SQL="SELECT  e.NUM,e.NOM,e.PRENOM,n.nom niveau FROM ELEVE e ,niveau n"
	  		+ " where e.niveau=n.id and (e.class is null)  and ( e.NOM like ? or e.PRENOM like ? ) and (e.niveau=?) order by e.num";
	   
	   try {
		   
			   DAO.ps=DAO.conn.prepareStatement(SQL);
			   DAO.ps.setString(1, nom);
			   DAO.ps.setString(2, nom);
			   DAO.ps.setInt(3, niveau);
	           rs=DAO.ps.executeQuery();
	           
	           return rs;    
           
          } catch (SQLException ex) {   System.out.print(" erreur Find_Eleve_No_Affecter (string) ");   return null;   }	   
   }
   
   /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

   
   public ResultSet Find_Eleve_By_Class(String nom,int id_class)
   {
	   nom=nom+"%";
	   
	   SQL="SELECT  e.NUM,e.NOM,e.PRENOM,c.NOM class ,n.nom niveau FROM ELEVE e,classe c ,niveau n"
	   		+ " where (e.niveau =n.id)and (CLASS =?) and (e.CLASS=c.ID) and ( (e.NOM like ?) or (e.PRENOM like ?))  order by num";
	   
	   try {
		   
			   DAO.ps=DAO.conn.prepareStatement(SQL); 
			   DAO.ps.setInt(1, id_class); 
			   DAO.ps.setString(2, nom);
			   DAO.ps.setString(3, nom);
	           rs=DAO.ps.executeQuery();
	           
	           return rs;    
           
          } catch (SQLException ex) {   System.out.print(" erreur get eleev (string) ");   return null;   } 
   }
   /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/


     public Eleve getById(int num)
     {
        e=new Eleve();
    	SQL="select * from eleve where num=?";
    	 
  	   try {
  		           DAO.ps=DAO.conn.prepareStatement(SQL);
  	               DAO.ps.setInt(1, num);
                   rs=DAO.ps.executeQuery();
             
             if(rs.next())
             {
            	    e.setNum(rs.getInt("num"));
            	    e.setDate_insc(rs.getString("DATE_INSC"));
            	    e.setNom(rs.getString("NOM"));
            	    e.setPrenom(rs.getString("PRENOM"));
            	    e.setDate_nais(rs.getString("DAT_NAIS"));
            	    e.setLieu_nais(rs.getString("LIEU_NAIS"));
            	    e.setSexe(rs.getString("SEXE"));
            	    e.setAdress(rs.getString("ADRESS"));
            	    e.setNIVEAU(rs.getInt("NIVEAU"));
            	    e.setCin_pere(rs.getString("CIN_PERE"));
            	    e.setNom_pere(rs.getString("NOM_PERE"));
            	    e.setAdress_pere(rs.getString("ADRESS_PERE"));
            	    e.setTel_pere(rs.getString("TEL_PERE"));
            	    e.setCin_mere(rs.getString("CIN_MERE"));
            	    e.setNom_mere(rs.getString("NOM_MERE"));
            	    e.setAdress_mere(rs.getString("ADRESS_MERE"));
            	    e.setTel_mere(rs.getString("TEL_MERE"));
            	    e.setImage(rs.getBlob("IMAGE"));
            	    return e;
             }
             else
                      return null;
            } catch (SQLException ex){   System.out.print(" erreur au niveau get byt id eleve  ");   return null;   }
     }	 
     /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/

     
     public void Affecter_Eleve_to_class(int num,int id_class)
     {
    	 
         SQL="Update ELEVE set  class=?  where NUM =?";
		 
  	   try {   

              DAO.ps=DAO.conn.prepareStatement(SQL);
              DAO.ps.setInt(1, id_class);
              DAO.ps.setInt(2, num);
              DAO.ps.execute();  
              
             } catch (SQLException ex) {   System.out.print(" erreur au nivea afceter elev  elev"); 	} 	 
     }
     /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/

      public void Supprimer_Eleve_from_class(int num)
      {
     	 
    	 SQL="Update ELEVE set  class=null where NUM =?";

    	 try {
    	  		      DAO.ps=DAO.conn.prepareStatement(SQL);
    	              DAO.ps.setInt(1, num);
    	              DAO.ps.execute();  
    	              
    	   } catch (SQLException ex) {   System.out.print(" erreur au nivea supprimer eleev from class ");   }   		 
      }
      
     /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/

     public ResultSet getAllEleves_Impression()
     {
  	    SQL="SELECT  NUM,NOM,PRENOM,DATE_INSC,ADRESS FROM ELEVE order by num";
  	   
  	   try {
  		   
  		     DAO.ps=DAO.conn.prepareStatement(SQL);
             rs=DAO.ps.executeQuery();
             
             return rs;    
             
            } catch (SQLException ex) 
  	   {   System.out.print(" erreur get all eleve impresion ");   return null;   }
  	   
  	  
     }
     
     /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/

     public ResultSet getALLEleves_By_class_Impression(int id_class)
     {
  	   
  	   SQL="SELECT  NUM,NOM,PRENOM,DATE_INSC,ADRESS FROM ELEVE where CLASS =? order by num";
  	   
  	   try {
  		   
  		     DAO.ps=DAO.conn.prepareStatement(SQL);
  		     DAO.ps.setInt(1, id_class);		   
             rs=DAO.ps.executeQuery();
             
             return rs;    
             
            } catch (SQLException ex) 
  	   {   System.out.print(" erreur get all eleve impresion ");   return null;   }
  	   
  	  
     }
 
     /*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/
  	
 	public ArrayList<String> ListeDesNomElevesByClasse(int classe)
 	{
 		
 		ArrayList<String> tab=new ArrayList<String>();
 		
         SQL="select nom || ' ' || prenom  nom from eleve where class = ?  order by num";
      	 
    	try {
    	    	 
    		      DAO.ps=DAO.conn.prepareStatement(SQL);
    		      DAO.ps.setInt(1, classe);
               rs=DAO.ps.executeQuery();
               
               while(rs.next())
               {
             	  tab.add(rs.getString("nom"));
               }
            } catch (SQLException ex)  {   System.out.print(" erreur liset des nom by class    ");   return null;   }
 		return tab;
 	}
 	
 	/*========================================================================================================================*/
  	/*========================================= 2) fonction  ================================================*/
  	/*========================================================================================================================*/
 	
	public ArrayList<String> ListeDesNumElevesByClasse(int classe)
 	{
 		
 		ArrayList<String> tab=new ArrayList<String>();
          SQL="select   num from eleve where class = ?  order by num";
      	 
    	   try {
    	    	 
    		      DAO.ps=DAO.conn.prepareStatement(SQL);
    		      DAO.ps.setInt(1, classe);
               rs=DAO.ps.executeQuery();
               
               while(rs.next())
               {
             	  tab.add(rs.getString("num"));
               }
    	
            } catch (SQLException ex)  {   System.out.print(" erreur liset des numero  by class    ");   return null;   }
 		return tab;
 	}

    /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
  	@Override
  	public Eleve getByNom(String nom) {
  		
  		return null;
  	}
  	
     /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
   	/*========================================================================================================================*/
}
