package com.tap.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoFiles.StudentSDAOImpl;
import com.tap.Model.Student;


public class FetchOne extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentSDAOImpl sdaoi = new StudentSDAOImpl();
		Student student = sdaoi.fetchOnId(id);
		req.getSession().setAttribute("student", student);
		resp.sendRedirect("editStudent.jsp");
	}
}
