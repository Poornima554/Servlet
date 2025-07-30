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

@WebServlet("/FindTeacherServlet")
public class FindTeacherServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("searchTeacher");
		
		List<TeacherEntity> teach = StudentDao.findTeacher(title);
		PrintWriter pw = res.getWriter();
		pw.print("TEACHER DETAILS\n\n");
		for(TeacherEntity t: teach) {
			pw.print("Teacher id=> "+t.getT_id()+"\n");
			pw.print("Teacher name=> "+t.getT_name()+"\n");
			pw.print("Teacher contact=> "+t.getT_contact()+"\n");
			pw.print("Teacher department"+t.getDept()+"\n");
		}
	}

}
