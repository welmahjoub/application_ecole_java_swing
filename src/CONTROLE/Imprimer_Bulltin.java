package CONTROLE;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
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
import DAO.DAOeleve;
import DAO.DAOmatier;
import DAO.DAOnote;
import MODEL.Classe;
import MODEL.Eleve;
import MODEL.Matiere;
import MODEL.Note;

public class Imprimer_Bulltin {
	
	
	static String fichier_Bultin="C:\\Users\\pc mahjoub\\Desktop\\Bultin.pdf";
	
	/*========================================================================================================================*/
	/*=============================================  Fin class  ==============================================================*/
	/*========================================================================================================================*/
	
	public static  void Imprimmer(int num,int simestre,int niv,int classe)
	{

		
        try {
       	 
       	      Document doc=new Document();
			  PdfWriter.getInstance(doc ,new FileOutputStream(fichier_Bultin));
			  doc.open();

			  Eleve e =new DAOeleve().getById(num);
		      Image img = Image.getInstance("C:\\Users\\pc mahjoub\\Downloads\\Mahjoub_project_v1\\src\\image\\log2.png");
	          img.scaleAbsolute(600, 200);
	          img.setAlignment(Image.ALIGN_CENTER);
	          doc.add(img);

	          PdfPCell cell;
	          PdfPTable tab=new PdfPTable(6);
	          tab.setWidthPercentage(100);
	         
	          
	          /*************************************************************************************/
	          /*************************************************************************************/
	          
	          setinfoEleve(doc, simestre, e,classe);
	          SetTitleTable_Bultin(tab);

	          ArrayList<String> ListMatiere=GetListeMatiere(niv);
	  		  DAOnote d=new DAOnote();
	  		  DAOmatier dm=new DAOmatier();
	  		  double moye;
	  		  String nomMat,moy;
			  int numMatier=0;
			  Matiere m = null;
			  
	      	for (int i=0;ListMatiere!=null && i<ListMatiere.size();i++) 
			{

				nomMat=ListMatiere.get(i);
                m=dm.getByNom(nomMat);
                if(m!=null)
                	numMatier=m.getID();
				Note noteeleve =null;
				noteeleve=	d.GetNoteEleve(num, classe, numMatier, simestre);
				
		 		 cell=new PdfPCell(new Phrase(nomMat,FontFactory.getFont("Verdana", 12)));
		         tab.addCell(cell);
		          
				if(noteeleve!=null)
				{
					
					  cell=new PdfPCell(new Phrase(noteeleve.getORALE(),FontFactory.getFont("Verdana", 12)));
					  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			          tab.addCell(cell);
			          
			          cell=new PdfPCell(new Phrase(noteeleve.getDS1(),FontFactory.getFont("Verdana", 12)));
			          tab.addCell(cell);
			          
			          cell=new PdfPCell(new Phrase(noteeleve.getDS2(),FontFactory.getFont("Verdana", 12)));
			          tab.addCell(cell);

					   moye=Calcul_Moyen_Matier(m, noteeleve);
					   moy=String.valueOf(moye);
					   moy=moy.substring(0,4);
					   cell=new PdfPCell(new Phrase(moy,FontFactory.getFont("Verdana", 12)));
			           tab.addCell(cell);
			          
			          cell=new PdfPCell(new Phrase(noteeleve.getOBSERVATION(),FontFactory.getFont("Verdana", 12)));
			          tab.addCell(cell);
				}	
			  
			}
	      	 doc.add(tab);
	      	 
	      	if(simestre==1 || simestre==2)
	      		Remplir_Champs_MoyeGeneral__Decision_Simestre_1_2(doc, simestre, e.getNum(), classe, niv);
	      	else
	      		Remplir_Champs_MoyeGeneral__Decision_Simestre_3(simestre, classe, niv, num, doc);
	         

	         doc.close();
	         Desktop.getDesktop().open(new File(fichier_Bultin));
	         
        } catch (FileNotFoundException e) {System.out.println(" fichier no trouvable ");
		} catch (DocumentException e) {System.out.println("document exception ");
		} catch (IOException e) {System.out.println(" exception io ");
	    } catch (SQLException e) {			System.out.println(" erreur du resultat de la base de donne ");
	    } catch (Exception e1) {	 }
        
	}

	    /*========================================================================================================================*/
		/*========================================= 2) fonction  ================================================*/
		/*========================================================================================================================*/
	
	static  void setinfoEleve(Document doc, int  simestre, Eleve e,int classe)
	{
		   Classe c=new DAOclass().getById(classe);
		   
			try {
				  doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("     N°Inscription    : "+ e.getNum(),FontFactory.getFont("arial",16)));
		          doc.add(new Paragraph("     Nom              : "+ e.getNom(),FontFactory.getFont("arial",16)));
		          doc.add(new Paragraph("     Prenom           : "+e.getPrenom(),FontFactory.getFont("arial",16)));
		          doc.add(new Paragraph("     classe           : "+c.getNOM(),FontFactory.getFont("arial",16)));
		          doc.add(new Paragraph("     Niveau           : "+c.getNIVEAU() + " Anne ",FontFactory.getFont("arial",16)));
		          doc.add(new Paragraph("     Simestre         : "+simestre,FontFactory.getFont("arial",16)));
		          doc.add(new Paragraph("                 "));
		          doc.add(new Paragraph("                 "));
				  doc.add(new Paragraph("                 "));
				
			} catch (DocumentException e1) { }
     
	}

     /*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/
	
	static void SetTitleTable_Bultin(PdfPTable tab)
	{
		 PdfPCell cell = new PdfPCell(new Phrase("Matiere ",FontFactory.getFont("Verdana", 12)));
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setBackgroundColor(BaseColor.GRAY);
         tab.addCell(cell);
         
         // 2em  case 
         cell=new PdfPCell(new Phrase("Note orale  ",FontFactory.getFont("Verdana", 12)));
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setBackgroundColor(BaseColor.GRAY);
         tab.addCell(cell);
         
         // 3em  case 
         cell=new PdfPCell(new Phrase("Note Devoir1 ",FontFactory.getFont("Verdana", 12)));
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setBackgroundColor(BaseColor.GRAY);
         tab.addCell(cell);

         // 4em  case 
         cell=new PdfPCell(new Phrase("Note Devoir2",FontFactory.getFont("Verdana", 12)));
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setBackgroundColor(BaseColor.GRAY);
         tab.addCell(cell);
         
         // 5em  case 
         cell=new PdfPCell(new Phrase("Moyenne ",FontFactory.getFont("Verdana",12 )));
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setBackgroundColor(BaseColor.GRAY);
         tab.addCell(cell);
         
      // 6em  case 
         cell=new PdfPCell(new Phrase("Observations ",FontFactory.getFont("Verdana",12 )));
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell.setBackgroundColor(BaseColor.GRAY);
         tab.addCell(cell);
         
	}
	
	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/

     public static double Calcul_Moyen_Matier(Matiere m,Note n)throws Exception
     {
			double res=0,NoteOrale=0,NoteDs1=0,NoteDs2=0;
			
			if(n!=null && m!=null)
			{
				if(NoteVide(n.getDS1())==false)
				NoteDs1=Double.parseDouble(n.getDS1());
					
				if(NoteVide(n.getDS2())==false)
					NoteDs2=Double.parseDouble(n.getDS2());
					
					if(m.getHas_Note_Orale()==1)
					{
						if(NoteVide(n.getORALE())==false)
						NoteOrale=Double.parseDouble(n.getORALE());
						
					   	res= ( NoteOrale * 1) + ( NoteDs1 *  1 ) + ( NoteDs2 * 2) ;
					   	res=res/4;
				
					   	return res;
					}
					else
					{
						res=( NoteDs1 ) +  ( NoteDs2 * 2 );
					   	res=res/3;
					
					   	return res;
					}
			}
			else
				return 0;
      }

	/*========================================================================================================================*/
	/*========================================= 2) fonction  ================================================*/
	/*========================================================================================================================*/


     private static boolean NoteVide(String note) 
     {

    	 if( note== null)
 			return true;
 		else if(note.equals("")==true)
 			return true;
 		else if(note.equals(" ")==true)
 			return true;
 		
 			return false;
    }
     
     /*========================================================================================================================*/
     /*=============================================  Fin class  ==============================================================*/
     /*========================================================================================================================*/
 	public static  ArrayList<String> GetListeMatiere(int idniv)
 	{
 		
 		ArrayList<String>tab=new DAOmatier().ListeDesMatiereByNiveau(idniv);
 		
 		return tab;
 	}
 	
     /*========================================================================================================================*/
     /*=============================================  Fin class  ==============================================================*/
     /*========================================================================================================================*/
 	
	public static double CalculerMoyen_Simestre(int simestre,int idElev,int idclass,int idniv)throws Exception
	{

		ArrayList<String> ListMatiere=null;

		ListMatiere=	new DAOmatier().ListeDesMatiereByNiveau(idniv);
		Note noteelev=new Note();
		double somme=0;
		Matiere m;
		Double moyeneMtaier=0.0;
		int idMatier=0;
	
		DAOmatier dm=new DAOmatier();
		DAOnote d=new DAOnote();
		 String NomMatiere;
		for (int i = 0; i < ListMatiere.size(); i++) {
			
			  NomMatiere=ListMatiere.get(i);
			 m=dm.getByNom(NomMatiere);
			 if(m!=null)
				 idMatier=m.getID();
			 
			 noteelev=d.GetNoteEleve(idElev,idclass,idMatier, simestre);
			 if(noteelev!=null)
			  moyeneMtaier=Calcul_Moyen_Matier(m, noteelev);
			 
			 somme+=moyeneMtaier;
		}

		return somme/ListMatiere.size();
		
	}
	
     /*========================================================================================================================*/
     /*=============================================  Fin class  ==============================================================*/
     /*========================================================================================================================*/
	
	public static  void Remplir_Champs_MoyeGeneral__Decision_Simestre_1_2(Document doc, int simestre, int idElev, int idclass, int idniv)
			throws Exception
	{
		double moye=CalculerMoyen_Simestre(simestre, idElev, idclass, idniv);
		String m=String.valueOf(moye);
		m=m.substring(0,4);
		String dec="";
		if(moye>=10)
			dec=" Admis";
			else
				dec=" Admis";
		  doc.add(new Paragraph("                 "));
          doc.add(new Paragraph("                 "));
		  doc.add(new Paragraph("                 "));
		  doc.add(new Paragraph("     Decision         :   "+dec,FontFactory.getFont("arial",16)));
		  doc.add(new Paragraph("     Moyenne general  :   "+ m,FontFactory.getFont("arial",16)));
		  
	}
	
    /*========================================================================================================================*/
    /*=============================================  Fin class  ==============================================================*/
    /*========================================================================================================================*/
	
	public static  void Remplir_Champs_MoyeGeneral__Decision_Simestre_3(int simestre, int idclass, int idniv, int idElev, Document doc) 
			throws Exception
	{
		  
		 
		  double Moye=0,Moy1=0,Moy2=0,Moy3=0,moyene=0;
		  
		  doc.add(new Paragraph("                 "));
		  doc.add(new Paragraph("                 "));
		  doc.add(new Paragraph("                 "));
		  doc.add(new Paragraph("                 "));
		  for (int i = 1; i <= 3; i++) 
		  {
			  Moye=CalculerMoyen_Simestre(i, idElev, idclass, idniv);
			 
			  String mo=String.valueOf(Moye);
			  mo=mo.substring(0, 4);

			  doc.add(new Paragraph(" Moyenne Simestre " + i +"  : "+ mo ,FontFactory.getFont("arial",16)));

				 if(i==1)
					 Moy1=Moye;
				 if(i==2)
					 Moy2=Moye;
				 if(i==3)
					 Moy3=Moye;
			
		 }
     
		   moyene=Moy1+Moy2+Moy3;		
		   moyene/=3;
		   String moyenGeneral=String.valueOf(moyene);
		   moyenGeneral=moyenGeneral.substring(0, 4);
		   
		   String dec;
		   
		   if(moyene >=10.0)
			   dec=" Admis ";
		   else
			   dec=" Redoublent ";
		   doc.add(new Paragraph("                 "));
		   doc.add(new Paragraph("                 "));
		   doc.add(new Paragraph(" Decision         :   "+dec,FontFactory.getFont("arial",16)));
		   doc.add(new Paragraph(" Moyenne general  :   "+moyenGeneral,FontFactory.getFont("arial",16)));
		 
	}
	
	
     /*========================================================================================================================*/
     /*=============================================  Fin class  ==============================================================*/
     /*========================================================================================================================*/

}
