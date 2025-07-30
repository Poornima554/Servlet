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

@WebServlet("/FindCourseServlet")
public class FindCourseServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String dept = req.getParameter("department");
		Department d = Department.valueOf(dept.toUpperCase());

		StudentEntity st = new StudentEntity();
		
		PrintWriter pw = res.getWriter();
		List<CourseEntity> courses = StudentDao.findCourse(d);
		pw.print("HEYYYYY✌️✌️😁😁+\n\n\n");
		pw.print("Course details are:-\n\n");
		int i=1;
		for(CourseEntity c : courses) {
			pw.print("Course "+i+"\n\n");
			pw.print("Course id=> "+c.getCourse_id()+"\n\n");
			pw.print("Course name=> "+c.getCourse_title()+"\n\n");
			pw.print("Course code=> "+c.getCourse_code()+"\n\n");
			i++;
		}
	}

}
