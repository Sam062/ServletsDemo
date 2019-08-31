package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("HI LOGIN SERVLET");
		
		String id=req.getParameter("uid");
		String uname=req.getParameter("uname");
		
		int uid=Integer.parseInt(id);
		boolean flag=DbOperation.isExist(uid,uname);
		System.out.println(flag);
		if(flag==true)
		{
			out.println("<h1>Hay !! I'm Logged in.</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
		}
	}
}
