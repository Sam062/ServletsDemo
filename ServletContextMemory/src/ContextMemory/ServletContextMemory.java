package ContextMemory;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletContextMemory extends GenericServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context=config.getServletContext();
		String s=context.getInitParameter("TITLE");
		System.out.println("from init method :"+s);
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("from Servive method");
		
	}
}
