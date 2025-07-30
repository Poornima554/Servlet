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

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("courseName");
		String code = req.getParameter("courseCode");
		String dept = req.getParameter("department");
		Department d = Department.valueOf(dept.toUpperCase());
		
		CourseEntity course = new CourseEntity();
		course.setCourse_title(title);
		course.setCourse_code(code);
		course.setDept(d);
		
		PrintWriter pw = res.getWriter();
		StudentDao.addCourse(course);
		pw.print("Course added successfully");
		
	}

}
