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

@WebServlet("/FindStudentServlet")
public class FindStudentServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("searchStudent");

		StudentEntity st = new StudentEntity();
		
		PrintWriter pw = res.getWriter();
		List<StudentEntity> students = StudentDao.findStudent(title);
		pw.print("HEYYYYY✌️✌️😁😁+\n\n\n");
		pw.print("Student details are\n");
		for(StudentEntity stu : students) {
			pw.print("Student id=> "+stu.getStudent_id()+"\n");
			pw.print("Student name=> "+stu.getTitle()+"\n");
			pw.print("Student contact=> "+stu.getContact()+"\n");
			pw.print("Student department=> "+stu.getDept()+"\n");
		}
	}

}
