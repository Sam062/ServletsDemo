package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String d=req.getParameter("id");
		int param=Integer.parseInt(d);
		PrintWriter p=resp.getWriter();
		int num=new Random().nextInt(9);
		p.println(param==num?"yo won Lottory":"lost");
		p.print(num);
		
		
		
	}

}
