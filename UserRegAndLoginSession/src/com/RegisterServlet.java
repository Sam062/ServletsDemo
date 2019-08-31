package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userReg")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String id=req.getParameter("uid");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		
		int uid=Integer.parseInt(id);
		int count=DbOperation.insert(uid,uname,pwd);

		PrintWriter out=resp.getWriter();
		if(count==1)
		{
			out.println("<h2>Registered Successfully ! </h2><br>");
			RequestDispatcher rd=req.getRequestDispatcher("userLogin.html");
			rd.include(req, resp);
		}
		else
			System.out.println(count);
	}
}
