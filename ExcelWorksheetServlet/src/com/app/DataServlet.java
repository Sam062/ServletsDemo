package com.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/vnd.ms-excel");
		resp.setHeader("Content-Disposition", "attachment;filename=Student.xls");
		try {
			//create Book
			HSSFWorkbook book=new HSSFWorkbook();
			//create sheet
			HSSFSheet sheet=book.createSheet();
			//create row
			HSSFRow r1=sheet.createRow(0);
			//create cells
			r1.createCell(0).setCellValue("sno");
			r1.createCell(1).setCellValue("sname");
			r1.createCell(2).setCellValue("course");
			r1.createCell(3).setCellValue("fee");
			
			//create 2nd row
			HSSFRow r2=sheet.createRow(1);
			//create cells
			r2.createCell(0).setCellValue(101);
			r2.createCell(1).setCellValue("SAM");
			r2.createCell(2).setCellValue("JAVA");
			r2.createCell(3).setCellValue(512.45);
			
			//write to OutputStream
			book.write(resp.getOutputStream());
			//close book
			book.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
