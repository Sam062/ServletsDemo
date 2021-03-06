package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FormReaderServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		//read form input-----------------------------
		String ename=req.getParameter("ename");
		String email=req.getParameter("email");
		String course=req.getParameter("course");
		String gender=req.getParameter("gender");
		String addr=req.getParameter("addr");
		String[] arr=req.getParameterValues("lang");
		
		//convert array data to List type
		List<String> languages=Arrays.asList(arr);
		//reading end-------------------------------
		
		
		//display data
		PrintWriter out=resp.getWriter();
		
		out.println("NAME :"+ename);
				
		out.println("EMAIL :"+email);
		
		out.println("COURSE :"+course);
		
		out.println("GENDER :"+gender);

		out.println("ADDRESS :"+addr);
		
		out.println("LANGUAGES :"+languages);
		

	}

}
