package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/prod")
public class ProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String id=req.getParameter("pid");
		String pcode=req.getParameter("pcode");
		String cost=req.getParameter("pcost");
		String pdesc=req.getParameter("pdesc");
		String grade=req.getParameter("grade");
		String stype=req.getParameter("stype");

		int count=0;	
		int pid=Integer.parseInt(id);
		double pcost=Double.parseDouble(cost);
		if(stype.equals("DB")) {
			try {
				count=ProductJDBC.operations(pid,pcode,pcost,pdesc,grade);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if(count==1)
			{
				RequestDispatcher rd=req.getRequestDispatcher("product.html");
				resp.getWriter().println("<div style=\"color: red\"><h4>"+pcode+" Details inserted !</h4></div>");
				rd.include(req, resp);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("product.html");
				resp.getWriter().println("<div style=\"color: red\"><h4> Not inserted !</h4></div>");
				rd.include(req, resp);
			}
		}
		else if(stype.equals("ExcelExport")) {
			excelExport(req,resp);
		}
		else if(stype.equals("PdfExport")) {
			try {
				pdfExport(req,resp);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}

	private void pdfExport(HttpServletRequest req, HttpServletResponse resp) throws DocumentException, IOException, ServletException {
		resp.setContentType("application/pdf");
		resp.addHeader("Content-Disposition", "attachment;filename=Product.pdf");


		String pid=req.getParameter("pid");
		String pcode=req.getParameter("pcode");
		String pcost=req.getParameter("pcost");
		String pdesc=req.getParameter("pdesc");
		String grade=req.getParameter("grade");

		Document doc=new Document();
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

	private void excelExport(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	resp.setContentType("application/vnd.ms-excel");
	resp.addHeader("Content-Disposition", "attachment;filename=Product.xls");

	String pid=req.getParameter("pid");
	String pcode=req.getParameter("pcode");
	String pcost=req.getParameter("pcost");
	String pdesc=req.getParameter("pdesc");
	String grade=req.getParameter("grade");

	HSSFWorkbook book=new HSSFWorkbook();
	HSSFSheet sheet=book.createSheet();
	HSSFRow r1=sheet.createRow(0);
	r1.createCell(0).setCellValue("PID");
	r1.createCell(1).setCellValue("PCODE");
	r1.createCell(2).setCellValue("PCOST");
	r1.createCell(3).setCellValue("PDESC");
	r1.createCell(4).setCellValue("GRADE");


	HSSFRow r2=sheet.createRow(1);
	r2.createCell(0).setCellValue(pid);
	r2.createCell(1).setCellValue(pcode);
	r2.createCell(2).setCellValue(pcost);
	r2.createCell(3).setCellValue(pdesc);
	r2.createCell(4).setCellValue(grade);

	book.write(resp.getOutputStream());
	book.close();
}
}
