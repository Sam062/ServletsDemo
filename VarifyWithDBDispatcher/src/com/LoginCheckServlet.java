package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		//1. read form data
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");

		//2. verify data 
		if(LoginJDBC.isExist(un, pwd)) {
			//goto HomePage
			RequestDispatcher rd=req.getRequestDispatcher("/home");
			rd.forward(req, resp);
		}
		else {
			//include Login Page with error message
			PrintWriter out=resp.getWriter();
			out.println("<div style='color:red'>Invalid user/password found</div>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}

}
