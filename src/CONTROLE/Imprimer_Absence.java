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

import DAO.DAOeleve;




public class Imprimer_Absence{
	
	static String fichier_Absence="C:\\Users\\pc mahjoub\\Desktop\\Absence.pdf";
	
	public static void Imprimer(String nomclass, int idclass, int idniv,String dat)
	{
		

        try {
       	 
       	      Document doc=new Document();
			  PdfWriter.getInstance(doc ,new FileOutputStream(fichier_Absence));
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
	          setTittle(doc, tab,  nomclass,dat);
	          
	          ArrayList<String> listNomPRENOM=getListe_NomPrenom_Eleves(idclass);
	          ArrayList<String> listNumero=getListe_Num_Eleves(idclass);
	          String num,nom;
	          
	          for (int i = 0; i < listNomPRENOM.size(); i++)
	          {
				     num=listNumero.get(i);
				     nom=listNomPRENOM.get(i);
	        	     cell=new PdfPCell(new Phrase(num,FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase(nom,FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase("",FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase("",FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase("",FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase("",FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase("",FontFactory.getFont("Verdana", 12)));
			         tab.addCell(cell);
			         
			       
			}
	        
	          cell=new PdfPCell(new Phrase("",FontFactory.getFont("Verdana", 12)));
		         tab.addCell(cell);

	      	 doc.add(tab);
	         doc.close();
	         Desktop.getDesktop().open(new File(fichier_Absence));
	         
        } catch (FileNotFoundException e) {System.out.println(" fichier no trouvable ");
		} catch (DocumentException e) {System.out.println("document exception ");
		} catch (IOException e) {System.out.println(" exception io ");}
        
	}

	
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	static  void setTittle(Document doc, PdfPTable tab,String classe,String dat)
	{
		   
		   
			try {
				  doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph(  "                           Liste des Absences   "  ,FontFactory.getFont("arial",16))); 
		          doc.add(new Paragraph("       classe :           " +classe + " /  date : " + dat,FontFactory.getFont("arial",16)));
		          doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("                 "));
				
				     PdfPCell cell = new PdfPCell(new Phrase(" Num  ",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         // 2em  case 
			         cell=new PdfPCell(new Phrase("Nom Prenom",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         // 3em  case 
			         cell=new PdfPCell(new Phrase("     8H-10h",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);

			         // 4em  case 
			         cell=new PdfPCell(new Phrase("     10H-12h",FontFactory.getFont("Verdana", 12)));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         // 5em  case 
			         cell=new PdfPCell(new Phrase("     12H-13h",FontFactory.getFont("Verdana",12 )));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			      // 6em  case 
			         cell=new PdfPCell(new Phrase( "     14H-16h",FontFactory.getFont("Verdana",12 )));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			         cell=new PdfPCell(new Phrase( "     16H-18h",FontFactory.getFont("Verdana",12 )));
			         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			         cell.setBackgroundColor(BaseColor.GRAY);
			         tab.addCell(cell);
			         
			} catch (DocumentException e1) { }
     
	}
	


	
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

	static  ArrayList<String> getListe_NomPrenom_Eleves(int idclass) {
		
    	DAOeleve de=new DAOeleve();
		ArrayList<String> ListeNomPrenom;
	    
	    ListeNomPrenom=de.ListeDesNomElevesByClasse(idclass);
	    
		return ListeNomPrenom;
	}
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	static  ArrayList<String> getListe_Num_Eleves(int idclass) {
		
		DAOeleve de=new DAOeleve();
		ArrayList<String> ListeNum;
	   
		ListeNum=de.ListeDesNumElevesByClasse(idclass);
		
		return ListeNum;
	}
	 /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	

}
