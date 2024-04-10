/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btssnir;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import java.io.FileOutputStream;

/**
 *
 * @author infcb
 */
public class gestion {
    
    IHMPanel panel ;
    
    public gestion(IHMPanel monJPanel) {
        this.panel = monJPanel;

    }


    public void split(){
         
        try {
            String pdfpath = panel.pathpdf ;
            PdfReader pdf = new PdfReader(pdfpath);
            

            //Récupérer le nombre de pages en pdf.
            int nbrPages = pdf.getNumberOfPages();

            //Itérer le pdf à travers les pages.
            for (int i = 1; i <= nbrPages; i++) {
                //Extraire le contenu de la page à l'aide de PdfTextExtractor.
                Document document = new Document(pdf.getPageSizeWithRotation(i));
                
               
                String destchemin = panel.pathdest;
                String nomfichier = panel.nomfichier;
                String cheminnew = ( destchemin + "\\"+ nomfichier +"(page " + i + ").pdf");
                PdfCopy writer = new PdfCopy(document, new FileOutputStream(cheminnew));
                document.open();
                PdfImportedPage page = writer.getImportedPage(pdf,i);
                
                writer.addPage(page);
                document.close();
                writer.close();
            }

            //Fermez le PdfReader.
            
            pdf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    
    
    }
    
}
