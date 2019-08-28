package com;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		//read old session
		HttpSession ses=req.getSession(false);
		
		//read attribute un
		Object ob=ses.getAttribute("un");
		
		//downcast
		String s=(String)ob;
		
		//print welcome message
		PrintWriter out=resp.getWriter();
		out.println("Welcome to :"+s);
		out.println("<br><a href='logout'>Logout</a>");
		
//		resp.addHeader("refresh", "1");
//		out.println(new Date());
	}
}
