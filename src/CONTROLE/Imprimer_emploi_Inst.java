package CONTROLE;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.DAOclass;

import DAO.DAOmatier;

import DAO.DAOsalle;
import DAO.DAOseance;
import MODEL.Classe;

import MODEL.Matiere;
import MODEL.Salle;
import MODEL.Seance;


public class Imprimer_emploi_Inst{
	
	static String fichier_emploiins="C:\\Users\\pc mahjoub\\Desktop\\emploiinst.pdf";
	
	public static void Imprimer(String nomPrenomInst,int cin)
	{
		

        try {
       	 
       	      Document doc=new Document();
			  PdfWriter.getInstance(doc ,new FileOutputStream(fichier_emploiins));
			  doc.open();

			 
		      Image img = Image.getInstance("C:\\Users\\pc mahjoub\\Downloads\\Mahjoub_project_v1\\src\\image\\log2.png");
	          img.scaleAbsolute(600, 200);
	          img.setAlignment(Image.ALIGN_CENTER);
	          doc.add(img);

	          PdfPCell cell;
	          PdfPTable tab=new PdfPTable(7);
	          tab.setWidthPercentage(100);
	         
	          
	          /*************************************************************************************/
	          /*************************************************************************************/
	          setTittle(doc, tab,nomPrenomInst);
	          ArrayList<Seance> list;
	          int res,k;
	          
	          String cas=" ";
	          
	          for(int i=1;i<6;i++)
	          {
	        	 
			         String h=getHoraire(i);
			         cell=new PdfPCell(new Phrase(h,FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         list=null;
	        	    list= getListSeance(i, cin);
	        	   
	        	  for(int j=0;j<list.size();j++)
	        	  {
	        		  Seance s;
	        		  s=list.get(j);
	        		  if(s!=null)
	        		  cas=ConcatenerSeance(s);
	        		  cell=new PdfPCell(new Phrase(cas,FontFactory.getFont("Verdana", 12)));
				         tab.addCell(cell);
				         
	        	  }
	        	  res=6-list.size();
	        	  
	        	  for( k=0;k<res;k++)
	        	  {
	        		  cell=new PdfPCell(new Phrase("",FontFactory.getFont("Verdana", 12)));
				         tab.addCell(cell);
	        	  }
	        	 
	          }

	      	 doc.add(tab);
	         doc.close();
	         Desktop.getDesktop().open(new File(fichier_emploiins));
	         
        } catch (FileNotFoundException e) {System.out.println(" fichier no trouvable ");
		} catch (DocumentException e) {System.out.println("document exception ");
		} catch (IOException e) {System.out.println(" exception io ");}
        
	}

	
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	static  void setTittle(Document doc, PdfPTable tab,String inst)
	{
		   
		   
			try {
				  doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("     Emploi     : "+ inst,FontFactory.getFont("arial",16)));
		          
		          doc.add(new Paragraph("                 "));
		          doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("                 "));
				
				     PdfPCell cell = new PdfPCell(new Phrase(" ",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         // 2em  case 
			         cell=new PdfPCell(new Phrase("Lundi",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         // 3em  case 
			         cell=new PdfPCell(new Phrase("Mardi",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);

			         // 4em  case 
			         cell=new PdfPCell(new Phrase("Mecredi",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         // 5em  case 
			         cell=new PdfPCell(new Phrase("Jeudi",FontFactory.getFont("Verdana",12 )));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			      // 6em  case 
			         cell=new PdfPCell(new Phrase( "Vendredi",FontFactory.getFont("Verdana",12 )));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase( "Samedi",FontFactory.getFont("Verdana",12 )));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			} catch (DocumentException e1) { }
     
	}
	
	 /*========================================================================================================================*/
		/*========================================= 2) fonction  ================================================*/
		/*========================================================================================================================*/
	
	public static String getHoraire(int horaire)
	{
		String cas="";
		if(horaire==1)
			cas="     8H-10h";
		if(horaire==2)
			cas="     10H-12h";
		if(horaire==3)
			cas="     12H-13h";
		if(horaire==4)
			cas="     14H-16h";
		if(horaire==5)
			cas="     16H-18h";
		
		
		return cas;
	}
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	public static ArrayList<Seance> getListSeance(int horaire,int cin)
	{
		ArrayList<Seance>  tab=new ArrayList<Seance> ();
		
		DAOseance d=new DAOseance();
		
		for(int i=1;i<=6;i++)
		{
			Seance c=null;
			c=d.getSeanceInstituteur(cin, horaire, i);
			if(c!=null)
			tab.add(c);
			
		}
		
		return tab;
		
	}
	
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	private static String ConcatenerSeance(Seance s) 
	{
		
		String nomMatier,Cas,nomSale,nomclass;
		
		nomMatier=getNom_Matiere(s.getMATIERE());
		nomSale=getNom_Salle(s.getSALLE());
		nomclass=getNom_Class(s.getCLASSE());
		
		Cas= nomclass +" / " + nomMatier + " / " + nomSale;
		return Cas;
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	static String  getNom_Class(int num)
	{
		Classe c=new DAOclass().getById(num);
		
		if(c!=null)
		{
			return c.getNOM();
		}
		return null;
	}


	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	static String  getNom_Matiere(int num)
	{
		Matiere m=new DAOmatier().getById(num);
		
		if(m!=null)
		{
			return m.getNOM();
		}
		return null;
	}

	
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	static String  getNom_Salle(int num)
	{
		Salle c=new DAOsalle().getById(num);
		
		if(c!=null)
		{
			return c.getNOM();
		}
		return null;
	}
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
}
