package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/pdf");
		resp.addHeader("Content-Disposition", "attachment;filename=Product.pdf");

		String pid=req.getParameter("pid");
		String pcode=req.getParameter("pcode");
		String pcost=req.getParameter("pcost");
		String pdesc=req.getParameter("pdesc");
		String grade=req.getParameter("grade");
				
		Document doc=new Document();
		try {
			PdfWriter.getInstance(doc, resp.getOutputStream());
			doc.open();

			Paragraph p1=new Paragraph("Product Pdf");
			doc.add(p1);
			Paragraph p2=new Paragraph(" ");
			doc.add(p2);

			PdfPTable table=new PdfPTable(5);
			table.addCell("PID");
			table.addCell("PCODE");
			table.addCell("PCOST");
			table.addCell("PDESC");
			table.addCell("GRADE");

			table.addCell(String.valueOf(pid));
			table.addCell(String.valueOf(pcode));
			table.addCell(String.valueOf(pcost));
			table.addCell(String.valueOf(pdesc));
			table.addCell(String.valueOf(grade));

			doc.add(table);

			Paragraph p3=new Paragraph("Details Entered By the user converted into PDF");
			doc.add(p3);

			doc.close();
		}
		catch (DocumentException e) {
			e.printStackTrace();
		}	
	}
}
