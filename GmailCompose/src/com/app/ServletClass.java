package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String emailId=req.getParameter("emailId");
		String subject=req.getParameter("subject");
		String msg=req.getParameter("msg");
		
		PrintWriter p=resp.getWriter();
		p.println(emailId);
		p.println(subject);
		p.println(msg);
		
		int count=GmailDao.save(emailId,subject,msg);
		if(count==1)
			p.println("Inserted into DB "+1);
		else
			p.println("Failure");
		p.println();
		p.println("***********************************");
		
	}
	

}
