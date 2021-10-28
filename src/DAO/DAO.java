package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public 	abstract class DAO <T> {
	
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
	
		public static  Connection conn=ConnexionBd.getConnexion(); 
		public static   PreparedStatement ps=null;
		public ResultSet rs=null;
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/
	
		public abstract void Ajouter(T o);
		
		public abstract void Modifier(T o);
		
		public abstract void Supprimer(int id);
		
		public abstract ResultSet getAll();
		
		public abstract T getById(int id);
		
		public abstract T getByNom(String nom);
		
		public abstract ResultSet Find_ById(int id);
		
		public abstract ResultSet Find_ByNom(String  nom);
	
	 /*========================================================================================================================*/
   	/*========================================= 2) fonction  ================================================*/
    /*========================================================================================================================*/

}
