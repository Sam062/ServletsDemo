package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class StudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Read form Inputs
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String type=req.getParameter("type");
		String mark=req.getParameter("marks");
		
		double marks=Double.parseDouble(mark);
		int totalMarks=0;
		
		//calculations
		if("SEM".equals(type))
			totalMarks=600;
		else if("MID".equals(type))
			totalMarks=400;
		else if("FINAL".equals(type))
			totalMarks=1200;
		
		double percent=marks/totalMarks*100;
		
		String grade="";
		if(percent>=75)
			grade="A+";
		else if(percent<75 && percent>=65)
			grade="A";
		else if(percent<60 && percent>=45)
			grade="B+";
		else if(percent<45 && percent>=45)
			grade="B+";
		
		String result=(percent>=35)?"PASS":"FAIL";
		
		resp.setContentType("application/pdf");
		resp.addHeader("Content-Disposition", "attachment;filename=Student.pdf");
		
		try {
			Document doc=new Document();
			PdfWriter.getInstance(doc, resp.getOutputStream());
			doc.open();
			Paragraph p1=new Paragraph("WELCOME TO RESULT : \nNAME : "+name);
			doc.add(p1);
			Paragraph p2=new Paragraph("ID : "+id);
			doc.add(p2);
			Paragraph p3=new Paragraph("\nGRADE : "+grade);
			doc.add(p3);
			Paragraph p4=new Paragraph("\nPERCENTAGE : "+percent);
			doc.add(p4);
			Paragraph p5=new Paragraph("EXAM-TYPE : "+type);
			doc.add(p5);
			Paragraph p6=new Paragraph("RESULT : "+result);
			doc.add(p6);
			Paragraph p7=new Paragraph("\n\n******ALL THE BEST*******");
			doc.add(p7);
			
			doc.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
