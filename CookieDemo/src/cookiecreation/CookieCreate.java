package cookiecreation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CookieCreate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//read from form
		String Name=req.getParameter("code");
		String model=req.getParameter("model");
		
		//create cookie
		Cookie c1=new Cookie("pcode", Name);
		Cookie c2=new Cookie("pmodel", model);

		//set cookie life 10min 
		c1.setMaxAge(600);
		
		//send to browser
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		//print 
		PrintWriter out=resp.getWriter();
		out.println("Cookies Created !!check browser!!");
		
	}
}
