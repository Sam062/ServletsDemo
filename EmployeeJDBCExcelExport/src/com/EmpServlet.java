package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class EmpServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/vnd.ms-excel");
		resp.addHeader("Content-Disposition", "attachment;filename=Emp.xls");
		try {
			//create Book
			HSSFWorkbook book=new HSSFWorkbook();
			//create sheet
			HSSFSheet sheet=book.createSheet();
			//create row
			HSSFRow r1=sheet.createRow(0);
			//create cells
			r1.createCell(0).setCellValue("EID");
			r1.createCell(1).setCellValue("ENAME");
			r1.createCell(2).setCellValue("ESAL");
			r1.createCell(3).setCellValue("DEPT");
			
			//call JDBC
			List<Employee> emp=EmpJDBC.getAllEmp();
			int count=0;
			
			for (Employee e : emp) {
				HSSFRow r=sheet.createRow(count++);
				r.createCell(0).setCellValue(e.getEid());
				r.createCell(1).setCellValue(e.getEname());
				r.createCell(2).setCellValue(e.getEsal());
				r.createCell(3).setCellValue(e.getDept());
			}
			book.write(resp.getOutputStream());
			book.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
