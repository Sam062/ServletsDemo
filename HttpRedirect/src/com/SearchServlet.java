package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data=req.getParameter("data");
		String servive=req.getParameter("service");
		String url=null;
		if("google".equals(servive))
			url="http://www.google.com/search?q="+data;
		
		else if("yahoo".equals(servive))
			url="http://in.search.yahoo.com/search?p="+data;
		
		else if("bing".equals(servive))
			url="http://www.bing.com/search?q="+data;
		
		//redirect
		resp.sendRedirect(url);
	}

}
