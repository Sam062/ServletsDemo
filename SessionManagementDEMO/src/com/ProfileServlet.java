package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet
extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		//read old session
		HttpSession ses=req.getSession(false);
		
		//read attribute un
		Object ob=ses.getAttribute("un");
		
		//downcast
		String s=(String)ob;
		
		//print welcome message
		PrintWriter out=resp.getWriter();
		ses.setMaxInactiveInterval(5);
		if(ses!=null) {
			resp.addHeader("refresh", "1");
			out.println("<h1>Welcome to : "+s.toUpperCase()+"</h1>");
			out.println("<h3>"+new Date()+"</h3>");
			out.println("<br><br>Max inactive intervel is "+ses.getMaxInactiveInterval());
			out.println("<br><h3><a href='logout'>Logout</a></h3>");
			
		}else
			ses.invalidate();	
	}
}
