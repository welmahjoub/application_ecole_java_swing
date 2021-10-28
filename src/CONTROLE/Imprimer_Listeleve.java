package CONTROLE;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import DAO.DAOeleve;
import MODEL.Classe;

public class Imprimer_Listeleve {

	static String fichier_class="C:\\Users\\pc mahjoub\\Desktop\\etudiant_class.pdf";
	
	static public  void Imprimer(int id_class) 
	{

		      ResultSet rs;
		
        try {
       	 
       	      Document doc=new Document();
			  PdfWriter.getInstance(doc ,new FileOutputStream(fichier_class));
			  doc.open();
	
	          Image img = Image.getInstance("C:\\Users\\pc mahjoub\\Downloads\\Mahjoub_project_v1\\src\\image\\log2.png");
	          img.scaleAbsolute(600, 200);
	          img.setAlignment(Image.ALIGN_CENTER);
	          doc.add(img);

	          Classe c=new DAOclass().getById(id_class);
	          for(int i=0;i<5;i++)
	          doc.add(new Paragraph("                 "));
	          doc.add(new Paragraph("                                       Liste des Eleves "+c.getNOM(),FontFactory.getFont("arial",16)));
	          doc.add(new Paragraph("                 "));
	          doc.add(new Paragraph("                 "));
	          
	          PdfPTable tab=new PdfPTable(5);
	          tab.setWidthPercentage(100);
	          rs=new DAOeleve().getALLEleves_By_class_Impression(id_class);
	          
	          PdfPCell cell;
	          
	          /*************************************************************************************/
	          // les colon du tableau 
	          // 1er case 
	          cell=new PdfPCell(new Phrase("Numero Inscription ",FontFactory.getFont("Verdana", 12)));
	          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	          cell.setBackgroundColor(BaseColor.GRAY);
	          tab.addCell(cell);
	          

	          // 2em  case 
	          cell=new PdfPCell(new Phrase("Nom ",FontFactory.getFont("Verdana", 12)));
	          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	          cell.setBackgroundColor(BaseColor.GRAY);
	          tab.addCell(cell);
	          

	          // 3em  case 
	          cell=new PdfPCell(new Phrase("prenom ",FontFactory.getFont("Verdana", 12)));
	          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	          cell.setBackgroundColor(BaseColor.GRAY);
	          tab.addCell(cell);

	          // 4em  case 
	          cell=new PdfPCell(new Phrase("Date Inscription ",FontFactory.getFont("Verdana", 12)));
	          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	          cell.setBackgroundColor(BaseColor.GRAY);
	          tab.addCell(cell);
	          

	          // 5em  case 
	          cell=new PdfPCell(new Phrase("Adress",FontFactory.getFont("Verdana",12 )));
	          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	          cell.setBackgroundColor(BaseColor.GRAY);
	          tab.addCell(cell);
	          
	          
	          /*************************************************************************************/
	          // les donne 
	          
	          if(rs!=null)
	          {
		          while(rs.next())
		          {

		          // 1er case 
		          cell=new PdfPCell(new Phrase(rs.getString("NUM"),FontFactory.getFont("Verdana", 12)));
		          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		       
		          tab.addCell(cell);
		          
	              //NUM,NOM,PRENOM,DATE_INSC,ADRESS
		          // 2em  case 
		          cell=new PdfPCell(new Phrase(rs.getString("NOM"),FontFactory.getFont("Verdana", 12)));
		          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		        
		          tab.addCell(cell);
		          
	
		          // 3em  case 
		          cell=new PdfPCell(new Phrase(rs.getString("PRENOM"),FontFactory.getFont("Verdana", 12)));
		          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		          
		          tab.addCell(cell);
	
		          // 4em  case 
		          cell=new PdfPCell(new Phrase(rs.getString("DATE_INSC"),FontFactory.getFont("Verdana", 12)));
		          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         
		          tab.addCell(cell);
		          
	
		          // 5em  case 
		          cell=new PdfPCell(new Phrase(rs.getString("ADRESS"),FontFactory.getFont("Verdana",12 )));
		          cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         
		          tab.addCell(cell);
		          
		          }
              } 
	          /*************************************************************************************/
	          
	          doc.add(tab);
	         
	          

	         doc.close();
	         Desktop.getDesktop().open(new File(fichier_class));
	         
        } catch (FileNotFoundException e) {System.out.println(" fichier no trouvable ");
		} catch (DocumentException e) {System.out.println("document exception ");
		} catch (IOException e) {System.out.println(" exception io ");
		} catch (SQLException e) {			System.out.println(" erreur du resultat de la base de donne ");}
			

	}
	
}
