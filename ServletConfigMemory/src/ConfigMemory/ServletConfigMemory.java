package ConfigMemory;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletConfigMemory extends GenericServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("From init");
		String s=config.getInitParameter("TITLE");
		System.out.println(s);
		System.out.println("init ends");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("from service method");
	}

}
