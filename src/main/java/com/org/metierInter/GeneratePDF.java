package com.org.metierInter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.org.entities.Approvement;
import com.org.entities.Deviation;

public class GeneratePDF {
	
	private Document doc;
    private Font normal;
    private Font normalBold;
    private Font small;
    private Font bigBold;
    
    //to write out in the servlet response
    ByteArrayOutputStream docOut;
    
	public GeneratePDF(float f, float g, float h, float i) {	
		doc = new Document(PageSize.A4, f, g, h, i);
        normal = FontFactory.getFont("Arial", 7, BaseColor.BLACK);
        normalBold = FontFactory.getFont("Arial", 7, Font.BOLD);
        small = FontFactory.getFont("Arial", 6);
        bigBold = FontFactory.getFont("Arial", 14, Font.BOLD);
        docOut = new ByteArrayOutputStream();
       
	}
	

	//add table cell
    private void addTableCell(PdfPTable table, String text, Font font, int collapse, int allignement)
    {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setColspan(collapse);
        cell.setPadding(4);
        cell.setHorizontalAlignment(allignement);
        table.addCell(cell);
    }
    
    
  //add table cell for page foot
    private void addTableCellForPageFoot(PdfPTable table, String text, Font font, int collapse, int allignement)
    {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setColspan(collapse);
        cell.setPadding(4);
        cell.setBorder(0);;
        cell.setHorizontalAlignment(allignement);
        table.addCell(cell);
    }
    
    

    //add table cell
    private void addTableCell(PdfPTable table, String text, Font font, int collapse, int allignement, String color)
    {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        BaseColor cellBackColor = WebColors.getRGBColor(color);
        cell.setBackgroundColor(cellBackColor);
        cell.setColspan(collapse);
        cell.setPadding(4);
        //cell.setBorder(0);
        cell.setHorizontalAlignment(allignement);
        table.addCell(cell);
    }
    

    // using the pdf writer generate the page header
    public PdfPTable generatePageHead()
    {
        PdfPTable table = new PdfPTable(7);
        table.setTotalWidth(100);

        // add the logo
        /*
        Image logoIm = Image.GetInstance("logo.PNG");
        PdfPCell logo = new PdfPCell(logoIm);
        logo.FixedHeight = 50f;
        logo.Colspan = 2;
        logo.Padding = 4;
        logo.HorizontalAlignment = 1;
        table.AddCell(logo);
        */

        //JUST FOR LOGO SIMULATION
        this.addTableCell(table, "LOGO", bigBold, 2, 1);
        
        //Title  cell
        this.addTableCell(table, "Deviation-Report / Abweichungserlaubnis", bigBold, 5, 1);

        //Document Number  cell
        this.addTableCell(table, "Document Number: FTDS-BM-F-001", normal, 2, 0);

        //Process Chqmpion  cell
        this.addTableCell(table, "Process Champion:  Global Quality Standards Manager", normal, 5, 0);


        //Document title  cell
        this.addTableCell(table, "Document Title:  DEVIATION REPORT", normal, 2, 0);

        //Process Approver cell
        this.addTableCell(table, "Process Approver:  Global Quality & Warranty Director", normal, 5, 0);

        //user Document cell
        this.addTableCell(table, "Usage of Document:", normal, 1, 0);

        //FTDS -BM-P-008 Deviation Control Procedure cell
        this.addTableCell(table, "FTDS -BM-P-008 Deviation Control Procedure Documentation and Approval of Deviations which are departures from standard procedures, product specifications or process controls.", normal, 3, 0);


        //scope of document  cell
        this.addTableCell(table, "Scope of Document:", normal, 1, 0);

        //TI FTDS Division  cell
        this.addTableCell(table, "TI FTDS Division", normal, 2, 0);



        return table;

    }
    
	
    //create the content of the deviation
    public PdfPTable createDeviationContent(PdfPTable table, Deviation deviation)
    {
        //Deviation No cell
        this.addTableCell(table, "ABWEICHUNG NR.:", normal, 1, 0, "#99ccff");

        //Deviation No Value cell
        this.addTableCell(table, "DR-" + deviation.getDeviationRef(), normal, 2, 0);

        // Risk Category cell
        this.addTableCell(table, "RISIKOKATEGORIE / (circle relevant):", normal, 2, 0, "#99ccff");

        // Risk Category Value cell
        String riskCat = deviation.getDeviationRiskCategory();
        String color = "";
        if (riskCat == "GRÜN")
        {
            color = "green";
        }else if (riskCat == "ROT")
        {
            color = "red";
        }else if (riskCat == "GELB")
        {
            color = "yellow";
        }

        this.addTableCell(table, deviation.getDeviationRiskCategory(), normal, 2, 0);

        // Requested by cell
        this.addTableCell(table, "ERSTELLT VON:", normal, 1, 0);

        // Requested by value cell
        this.addTableCell(table, deviation.getRequestedBy(), normal, 3, 0);

        // DATE cell
        this.addTableCell(table, "DATE:", normal, 1, 0);

        // DATE value cell
        String dateCreation = "";
        if(deviation.getDateCreation() != null ) {
        	dateCreation = deviation.getDateCreation().toString();
        }
        this.addTableCell(table, dateCreation, normal, 2, 0);

        // Signature cell
        this.addTableCell(table, "UNTERSCHRIFT:", normal, 1, 0);

        //Signature value cell
        this.addTableCell(table, "", normal, 3, 0);

        // position cell
        this.addTableCell(table, "POSITION:", normal, 1, 0);

        // position value cell
        this.addTableCell(table, deviation.getPosition(), normal, 2, 0);

        // deviation type cell
        this.addTableCell(table, "ABWEICHUNG ART:", normal, 2, 0,"#99ccff");

        // deviation type value cell
        this.addTableCell(table, deviation.getDeviationType(), normal, 1, 0,"#ff9900");

        // Other Description value cell
        this.addTableCell(table, "Other : " + deviation.getDeviationTypeOther(), normal, 7, 0);

        // Detail description of deviation cell
        this.addTableCell(table, "DETAILED DESCRIPTION OF DEVIATION (detail product name / procedure number / specification / etc) \n Detaillierte Beschreibung der Abweichung ( Produkt Nr., Anweisungs Nr.:, Spezifikation, Verfahrensanweisungsnr., usw.)", normal, 7, 0);

        // Standard condition cell
        this.addTableCell(table, "Beschreibung Istzustand", normal, 3, 1, "#C4C7C3");

        // detail requested condition cell
        this.addTableCell(table, "Beschreibung Sollzustand", normal, 4, 1, "#C4C7C3");

        // Standard condition  value cell
        String productanlage = deviation.getProduct();
        if (productanlage != "")
        {
            if (deviation.getAnlage() != "")
            {
                productanlage = productanlage + " / Anlage " + deviation.getAnlage();
            }
        }
        else
        {
            productanlage = deviation.getAnlage();
        }

        if (productanlage != "")
        {
            productanlage = productanlage + " ";
        }

        this.addTableCell(table, productanlage + deviation.getSollZustand(), normal, 3, 0);

        // detail requested condition value  cell
        this.addTableCell(table, deviation.getIstZustand(), normal, 4, 0);

        // 5 why cell
        this.addTableCell(table, "DETAIL 5 WHY TO SHOW REASON CHANGE FOR DEVIATION:", normal, 7, 0, "#C4C7C3");

        // why 1 cell
        this.addTableCell(table, "WHY: " + deviation.getReason1(), normal, 7, 0);

        // why 2 cell
        this.addTableCell(table, "WHY: " + deviation.getReason2(), normal, 7, 0);

        // why 3 cell
        this.addTableCell(table, "WHY: " + deviation.getReason3(), normal, 7, 0);

        // why 4 cell
        this.addTableCell(table, "WHY: " + deviation.getReason4(), normal, 7, 0);

        // why 5 cell
        this.addTableCell(table, "WHY: " + deviation.getReason5(), normal, 7, 0);

        // Period deviation cell
        this.addTableCell(table, "Zeitraum für Abweichung(Schicht / Woche / usw.)", normal, 3, 0, "#C4C7C3");

        // Period deviation value  cell    
        String startDate = "", endDate = "" ;
        if(deviation.getStartDatePeriod() != null) {
        	startDate = deviation.getStartDatePeriod().toString();
        }
        if(deviation.getEndDatePeriod() != null) {
        	endDate = deviation.getEndDatePeriod().toString();
        }

        this.addTableCell(table, "Von: " + startDate + "  Bis: " + endDate, normal, 4, 0);


        // DENTFY THE FIRST AND LAST PART NUMBER  FOR DEVIATION  ... cell
        this.addTableCell(table, "IDENTFY THE FIRST AND LAST PART NUMBER  FOR DEVIATION OR IDENTIFY ALTERNATIVE IDENTIFICATION METHOD (For example circle on base of tank - include photo, diagram where applicable) \n Erste Tanknummer ab der Abweichung gilt oder andere Identifikationsmethode zur Rückverfolgung.", normal, 7, 0, "#C4C7C3");


        // DENTFY THE FIRST AND LAST PART NUMBER  FOR DEVIATION value  ... cell
        this.addTableCell(table, deviation.getBarcode(), normal, 7, 0);


        return table;
    }

    
    // add Aprovement to Deivation pdf 
    private PdfPTable createApprovementPdf(PdfPTable table, Deviation deviation)
    {

        // Approval cell
        this.addTableCell(table, "APPROVAL \n Prüfer", normalBold, 1, 1, "#99ccff");

        // Name cell
        this.addTableCell(table, "NAME", normalBold, 1, 1, "#99ccff");

        // Approve cell
        this.addTableCell(table, "APPROVE \n Freigabe", normalBold, 1, 1, "#99ccff");

        // Reject cell
        this.addTableCell(table, "REJECT \n Abgelehnt", normalBold, 1, 1, "#99ccff");

        // Comments cell
        this.addTableCell(table, "COMMENTS \n Bemerkungen", normalBold, 1, 1, "#99ccff");

        // Signed cell
        this.addTableCell(table, "SIGNED \n Unterschrift", normalBold, 1, 1, "#99ccff");

        // Signed cell
        this.addTableCell(table, "DATE \n Datum", normalBold, 1, 1, "#99ccff");

        //Get All Approvement
        List<Approvement> approvements = deviation.getAprovements();
        for(Approvement approvement : approvements)
        {             
                  
                // Approval cell
                this.addTableCell(table, approvement.getApprovementGroup().getLabel(), normal, 1, 0);

                // Name cell
                this.addTableCell(table, approvement.getClient().getName() + approvement.getClient().getPrenom(), normal, 1, 0);

                // Approve cell
                if (approvement.isApproved())
                {
                    //this.addTableCell(table);
                	this.addTableCell(table, "approved", normal, 1, 0);
                }
                else
                {
                    this.addTableCell(table,"", normal, 1, 0);
                }

                // Reject cell
                if (approvement.isRejected())
                {
                    //this.addTableCell(table);
                	this.addTableCell(table, "rejected", normal, 1, 0);
                }
                else
                {
                    this.addTableCell(table, "", normal, 1, 0);
                }

                // Comments cell
                this.addTableCell(table, approvement.getComment(), normal, 1, 0);

                // Signed cell
                if (approvement.isRejected() || approvement.isApproved())
                {
                    //this.addTableCell(table);
                	this.addTableCell(table, "signed", normal, 1, 0);
                }
                else
                {
                    this.addTableCell(table, "", normal, 1, 0);
                }

                // date cell
                String approvementDate = "";
                if(approvement.getDate() != null) {
                	approvementDate = approvement.getDate().toString();
                }
                this.addTableCell(table, approvementDate, normal, 1, 0);
            
        }

        
        return table;
    }

    
	
	//here will the doc generated and writen in a ByteArrayOutputStream, this will be sent to the client in the servlet response
	public ByteArrayOutputStream getPDFOutput(Deviation deviation) throws IOException {
		
		try {
			
			//step 1
			PdfWriter.getInstance(doc, docOut);
			
			// step 3
            doc.open();
            
            
            //step 4
            //crate deviation page header
            PdfPTable table = this.generatePageHead();           
            
            //create Deviation content
            this.createDeviationContent(table, deviation);
            
            //add Aprovement to Deivation pdf
            this.createApprovementPdf(table, deviation);
            
            
            //step 5
            doc.add(table); 
            doc.close();
            
            
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			throw new IOException(e.getMessage());
		}
		
		
		return this.docOut;
	}
	
	

}
