package com.tap.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoFiles.StudentSDAOImpl;
import com.tap.Model.Student;


public class UpdateStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Student student = new Student(
				id,
				req.getParameter("name"),
				req.getParameter("email"),
				req.getParameter("password"),
				req.getParameter("mobile"),
				req.getParameter("address")
				);
	StudentSDAOImpl sdaoi=	new StudentSDAOImpl();
	int x=sdaoi.updateStudent(student);
	if(x==1) {
		resp.sendRedirect("FetchAll");
	}else {
		resp.sendRedirect("failure.jsp");
	}
	}
}
