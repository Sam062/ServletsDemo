package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		resp.setContentType("text/html");
		out.println("<h1>Logged in</h1>");
		out.println(new Date());
		
		resp.addHeader("refresh", "1");
	}
}
