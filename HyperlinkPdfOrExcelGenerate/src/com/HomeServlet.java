package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String id=req.getParameter("pid");
		String pcode=req.getParameter("pcode");
		String cost=req.getParameter("pcost");
		String pdesc=req.getParameter("pdesc");
		String grade=req.getParameter("grade");


		int count=0;	
		int pid=Integer.parseInt(id);
		double pcost=Double.parseDouble(cost);

		try {
			count=ProductJDBC.operations(pid,pcode,pcost,pdesc,grade);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(count==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("forward.html");
			PrintWriter out=resp.getWriter();
			out.println("<h2>----- "+pcode+" Details inserted ! -----</h2>");
			out.println("<table style='width:30%' border=1><tr><th> ID </th>\r\n" + 
					"<th> CODE </th>\r\n" + 
					"<th> COST </th>\r\n" + 
					"<th> DESCRIPTION </th>\r\n" + 
					"<th> GRADE </th>\r\n" + 
					"</tr><tr align='center'>"
					+ "<td>"+pid+"</td>\r\n" + 
					"<td>"+pcode+"</td>\r\n" + 
					"<td>"+pcost+"</td>\r\n" + 
					"<td>"+pdesc+"</td>\r\n" + 
					"<td>"+grade+"</td>\r\n" + 
					"</tr></table>"
					+ "<br>" );		
			out.println("<fieldset><legend><h3>Data Export</h3></legend>");
			//			out.println("<a href=http://localhost:9090/HyperlinkPdfOrExcelGenerate/pdf?pid="+pid+">PDF</a>");
			out.println("&nbsp&nbsp"
					+ "<a href=http://localhost:9090/HyperlinkPdfOrExcelGenerate/pdf?pid="+pid
					+"&pcode="+pcode
					+"&pcost="+pcost
					+"&pdesc="+pdesc
					+"&grade="+grade
					+">PDF</a>");
			
			out.println("<br><br>&nbsp&nbsp"
					+ "<a href=http://localhost:9090/HyperlinkPdfOrExcelGenerate/excel?pid="+pid
					+"&pcode="+pcode
					+"&pcost="+pcost
					+"&pdesc="+pdesc
					+"&grade="+grade
					+">Excel</a>");

			//out.println("<br><br><a href=http://localhost:9090/HyperlinkPdfOrExcelGenerate/pdf?pid="+pid+">Excel</a>");
			out.println("<br><br></fieldset>");
			rd.include(req, resp);

		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("product.html");
			resp.getWriter().println("<div style=\"color: red\"><h4> Not inserted !</h4></div>");
			rd.include(req, resp);


		}
	}
}
