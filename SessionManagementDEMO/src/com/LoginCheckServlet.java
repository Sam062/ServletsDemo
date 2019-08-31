package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginCheckServlet
extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		//1. read form data
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		
		//2. verify and Dispatch
		if("admin".equals(un) && "sam".equals(pwd)) {
			
			//if valid create new session
			HttpSession ses=req.getSession();
			ses.setMaxInactiveInterval(10);
			
			//set data un=admin
			ses.setAttribute("un", un);
			ses.setMaxInactiveInterval(5);
			
			//goto ProfileServlet
			RequestDispatcher rd=req.getRequestDispatcher("/profile");
			rd.forward(req, resp);
		}
		else {
			//invalid data show error message
			PrintWriter out=resp.getWriter();
			out.println("Invalid Un/pwd entered");
			
			//goto index.html
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
}
