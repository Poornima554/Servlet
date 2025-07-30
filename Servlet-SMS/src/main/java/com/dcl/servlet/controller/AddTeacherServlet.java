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
import com.dcl.servlet.entity.TeacherEntity;

@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("teacherName");
		long contact = Long.parseLong(req.getParameter("teacherContact"));
		String dept = req.getParameter("department");
		Department d = Department.valueOf(dept.toUpperCase());
//		String[] courseCodes = req.getParameterValues("assignedCourse");
//		
//		 List<CourseEntity> courseList = new ArrayList<>();
//		    if (courseCodes != null) {
//		        for (String code : courseCodes) {
//		            List<CourseEntity> course = StudentDao.findCourse(d);
//		            if (course != null) {
//		                courseList.add(course);
//		            }
//		        }
//		    }
		    
		    TeacherEntity t = new TeacherEntity();
		    t.setT_name(title);
		    t.setT_contact(contact);
		    t.setDept(d);
//		    t.setCourses(courseList);
		    
		    StudentDao.addTeacher(t);
		    PrintWriter pw = res.getWriter();
		    pw.print("Teacher added successfully");
	}

}
