package base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String gender=req.getParameter("gen");
		String[] dept=req.getParameterValues("dept");
		
		PrintWriter p=res.getWriter();
		p.println("ID : "+id);
		p.println("NAME : "+name);
		p.println("Gender : "+gender);
		p.println("Departments : ");
		for (String string : dept) {
			p.println(string);
		}
	}

}
