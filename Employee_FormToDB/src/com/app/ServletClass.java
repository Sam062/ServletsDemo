package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class ServletClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("eid");
		String ename=req.getParameter("ename");
		String egen=req.getParameter("egen");
		String emob=req.getParameter("emob");
		String eaddr=req.getParameter("eaddr");
		String dept=req.getParameter("dept");
		
		int eid=Integer.parseInt(id);
		int count=0;
		PrintWriter p=res.getWriter();
		
		try {
			count=EmployeeDao.save(eid, ename, egen, emob, eaddr, dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(count==1)
			p.println("Success "+count);
		else
			p.println("Failure ");
	}
	

}
