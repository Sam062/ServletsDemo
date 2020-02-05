package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class LoginCheck extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un=req.getParameter("un");
		String pwd=req.getParameter("pwd");
		
		if(un.equals("sam") && pwd.equals("sam")) {
			RequestDispatcher rd=req.getRequestDispatcher("/home");
			rd.forward(req, resp);
		}
		else {
			PrintWriter p=resp.getWriter();
			p.println("Invalid Username or Password !!");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
			
		}
			
	}
}
