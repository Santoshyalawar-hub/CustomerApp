package com.tap.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoFiles.StudentSDAOImpl;


public class Delete extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("sid"));
		
		StudentSDAOImpl sdaoi= new StudentSDAOImpl();
		int x=sdaoi.delete(id);
		if(x!=0) {
			resp.sendRedirect("FetchAll");
		}else {
			resp.sendRedirect("failure.jsp");
		}
	}
}
