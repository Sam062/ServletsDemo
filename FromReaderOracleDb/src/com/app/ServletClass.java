package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@SuppressWarnings("serial")
public class ServletClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter p=res.getWriter();
		String sid=req.getParameter("sid");
		String sname=req.getParameter("sname");
		String sgen=req.getParameter("sgen");
		String addr=req.getParameter("addr");
		int id=Integer.parseInt(sid);
		int count1=StudentDao.save(id, sname, sgen, addr);
		if(count1!=0)
			p.println("SUCCESS "+count1);
		else
			p.println("FAILURE ");	
		
		p.println("***************");
	}
	

}
