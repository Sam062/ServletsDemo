package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LuckTest extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String s=req.getParameter("sid");
		int id=Integer.parseInt(s);
		int gid=new Random().nextInt(9);
		PrintWriter out=resp.getWriter();
		if(gid==id)
			out.println("you won 1 lac");
		else
			out.println("Sorry! Try Next Time");
		out.println(gid);
	}

}
