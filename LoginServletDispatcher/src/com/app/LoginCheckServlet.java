package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.LoginJDBC;

public class LoginCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");

		//Verify data

		if("admin".equals(un) && "root".equals(pwd)) {
			if(LoginJDBC.isExist(un, pwd)) {
				//goto AdminPage
				RequestDispatcher rd=req.getRequestDispatcher("/admins");
				rd.forward(req, resp);
			}
		}
		else if("sam".equals(un) && "sam".equals(pwd)) {
			if(LoginJDBC.isExist(un, pwd)) {
				//goto UserPage
				RequestDispatcher rd=req.getRequestDispatcher("/user");
				rd.forward(req, resp);
			}
		}		
		else {
			//include Login Page with error message
			PrintWriter out=resp.getWriter();
			RequestDispatcher rd=req.getRequestDispatcher("error.html");
			rd.forward(req, resp);
		}
	}
}
