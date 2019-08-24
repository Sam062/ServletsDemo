package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheck extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		//read form data
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		
		//verify Data
		if("admin".equals(un) && "root".equals(pwd)) {
			//goto Home Page 
			RequestDispatcher rd=req.getRequestDispatcher("/home");
			rd.forward(req, resp);
		}
		else {
			//Error msg on Login page
			PrintWriter out=resp.getWriter();
			out.println("<div style='color:red'>"
					+ "<h1>Invalid user/password found</h1>"
					+ "</div>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
}
