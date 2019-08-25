package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@WebServlet("/excel")
public class ExcelServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		r1.createCell(0).setCellValue("Product ID");
		r1.createCell(1).setCellValue("CODE");
		r1.createCell(2).setCellValue("COST");
		r1.createCell(3).setCellValue("DISCRIPTION");
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
