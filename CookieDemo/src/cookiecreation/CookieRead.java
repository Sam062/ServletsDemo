package cookiecreation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class CookieRead extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read all cookies from req
		Cookie[] ck=req.getCookies();
		
		//print cookies
		PrintWriter out=resp.getWriter();
		if(ck!=null &&ck.length>0)
			for(Cookie c:ck)
				out.println(c.getName()+"="+c.getValue());
		else
			out.println("No Cookie Found");
		
	}

}
