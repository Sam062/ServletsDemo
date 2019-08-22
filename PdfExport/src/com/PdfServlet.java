package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/pdf");
		resp.addHeader("Content-Disposition", "attachment;filename=Demo.pdf");
		try {
			//create new pdf file
			Document doc=new Document();
			//link document with OutputStream
			PdfWriter.getInstance(doc, resp.getOutputStream());
			//open doc
			doc.open();
			
			//create element and add to document
			Paragraph p=new Paragraph("Hello Demo PDF");
			doc.add(p);
			
			
			//close doc
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
