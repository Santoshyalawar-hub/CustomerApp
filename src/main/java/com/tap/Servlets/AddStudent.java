package com.tap.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoFiles.StudentSDAOImpl;
import com.tap.Model.Student;
import com.tap.security.Encrypt;


public class AddStudent extends HttpServlet 
{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Student student = new Student(
					req.getParameter("name"),
					Encrypt.encrypt(req.getParameter("email")),
					req.getParameter("password"),
					req.getParameter("mobile"),
					req.getParameter("address")
					);
			StudentSDAOImpl sdaoi = new StudentSDAOImpl();
			int status = sdaoi.insertStudent(student);
			if(status==1) {
				//success
				resp.sendRedirect("FetchAll");
			}else {
				//failure
				resp.sendRedirect("failure.jsp");
			}
		}
}
