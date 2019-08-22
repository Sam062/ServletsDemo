package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.collection.PdfTargetDictionary;

public class GstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String icode=req.getParameter("icode");
		String c=req.getParameter("cost");
		String slab=req.getParameter("slab");
		
		double cost=Double.parseDouble(c);
		int gstPercent=0;
		if("SLAB-A".equals(slab))
			gstPercent=5;
		else if("SLAB-B".equals(slab))
			gstPercent=12;
		else if("SLAB-C".equals(slab))
			gstPercent=21;
		else if("SLAB-D".equals(slab))
			gstPercent=32;
		
		double gst=cost*gstPercent/100;
		int cgst,sgst;
		cgst=sgst=(int) (gst/2);
		
		double total=cost+gst;
		
//		System.out.println(icode
//				+" "+slab
//				+" "+cost
//				+" "+gstPercent
//				+" "+gst
//				+" "+cgst
//				+" "+sgst
//				+" "+total);
		
		resp.setContentType("application/pdf");
		resp.addHeader("Content-Disposition", "attachment;filename=GST.pdf");
		
		//pdf document
		try {
			Document doc=new Document();
			PdfWriter.getInstance(doc, resp.getOutputStream());
			doc.open();
			
			Paragraph p1=new Paragraph("***** : Invoice PDF TABLE :*******\n\n");
			doc.add(p1);
			
			PdfPTable table=new PdfPTable(2);
			table.addCell("ITEM-CODE");
			table.addCell(String.valueOf(icode));
			
			table.addCell("cost");
			table.addCell(String.valueOf(cost));
			
			table.addCell("SGST");
			table.addCell(String.valueOf(sgst));
			
			table.addCell("CGST");
			table.addCell(String.valueOf(cgst));
			
			table.addCell("TOTAL");
			table.addCell(String.valueOf(total));
			
			doc.add(table);
			doc.close();
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}	
	}
}
