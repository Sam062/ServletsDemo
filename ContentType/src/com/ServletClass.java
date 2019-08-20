package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletClass extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//prints as it is gitven in the println stmt
		//resp.setContentType("Text/plain");
		//prints as a html tags works
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>Hello</h1>");
		out.println("<h2>Hay</h2>");
	}

}
