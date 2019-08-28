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

@WebServlet("/logout")
public class LogoutServlet
extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		//read old session
		HttpSession ses=req.getSession(false);
		
		//remove session
		ses.invalidate();
		
		//print message
		PrintWriter out=resp.getWriter();
		out.println("Logout success!!");
		
		//goto Login Page
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.include(req, resp);
	}
}