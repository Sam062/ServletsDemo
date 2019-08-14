package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletClass extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter p=resp.getWriter();
		try {
		long val1=Long.parseLong(req.getParameter("val1"));
		long val2=Long.parseLong(req.getParameter("val2"));
		
		String s=req.getParameter("cal");
		
		if(s.equals("ADD")) {
			p.println(add(val1,val2));
		}
		else if(s.equals("SUB"))
			p.println(sub(val1,val2));
		else if(s.equals("MUL"))
			p.println(mul(val1,val2));
		else if(s.equals("DIV"))
			p.println(div(val1,val2));
		}catch (Exception e) {
			p.println("Invalid Arguments");
		}
		
	}

	public long add(long a,long b) {
		return a+b;
		
	}
	public long sub(long a,long b) {
		return a-b;
		
	}
	public long mul(long a,long b) {
		return a*b;
		
	}
	public long div(long a,long b) {
		return a/b;
		
	}
}
