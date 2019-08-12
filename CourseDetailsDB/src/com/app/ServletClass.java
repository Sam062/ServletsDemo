package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletClass extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String cname=req.getParameter("cname");
		String dur=req.getParameter("duration");
		String fname=req.getParameter("fname");
		String ctype=req.getParameter("ctype");
		String fee=req.getParameter("cfee");
		String note=req.getParameter("note");
		
		int duration=Integer.parseInt(dur);
		double cfee=Double.parseDouble(fee);
		
		int count=CourseDao.save(cname, duration, fname, ctype, cfee, note);
		PrintWriter p=res.getWriter();
		if(count==1)
			p.println("Succeed "+count);
		else
			p.println("Failure");
		
	}
	

}
