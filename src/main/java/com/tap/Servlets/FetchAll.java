package com.tap.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoFiles.StudentSDAOImpl;
import com.tap.Model.Student;

public class FetchAll extends HttpServlet {
	
	private List<Student> studentlist;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentSDAOImpl sdimpl=new StudentSDAOImpl();
		 studentlist = sdimpl.fetchAll();
		 req.getSession().setAttribute("studentlist", studentlist);
		 resp.sendRedirect("home.jsp");
	}
}
