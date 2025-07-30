package com.dcl.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.dcl.servlet.doa.StudentDao;
import com.dcl.servlet.entity.CourseEntity;
import com.dcl.servlet.entity.Department;
import com.dcl.servlet.entity.StudentEntity;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("studentName");
		long contact = Long.parseLong(req.getParameter("studentContact"));
		String deptStr = req.getParameter("department");
		Department dept = Department.valueOf(deptStr.toUpperCase());

		StudentEntity st = new StudentEntity();
		st.setTitle(title);
		st.setContact(contact);
		st.setDept(dept);
		
		PrintWriter pw = res.getWriter();
		StudentDao.addStudent(st);
		pw.print("Student added successfully");
	}

}
