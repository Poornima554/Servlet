package com.dcl.servlet.doa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dcl.servlet.entity.CourseEntity;
import com.dcl.servlet.entity.Department;
import com.dcl.servlet.entity.StudentEntity;
import com.dcl.servlet.entity.TeacherEntity;

public class StudentDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	
	public static void addStudent(StudentEntity st) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(st);
		
		em.getTransaction().commit();
		em.close();
	}

	public static List<StudentEntity> findStudent(String title) {
		EntityManager em = emf.createEntityManager();
		Query query= em.createQuery("SELECT s FROM StudentEntity s WHERE s.title = :title");
		query.setParameter("title", title);
		List<StudentEntity> students = query.getResultList();
		return students;
	}

	public static void addCourse(CourseEntity course) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(course);
		
		em.getTransaction().commit();
		em.close();
		
	}

	public static List<CourseEntity> findCourse(Department d) {
		EntityManager em = emf.createEntityManager();
		Query query= em.createQuery("SELECT c FROM CourseEntity c WHERE c.dept = :title");
		query.setParameter("title", d);
		List<CourseEntity> courses = query.getResultList();
		return courses;
	}

	public static List<TeacherEntity> findTeacher(String title) {
		EntityManager em = emf.createEntityManager();
		Query query= em.createQuery("SELECT t FROM TeacherEntity t WHERE t.t_name = :title");
		query.setParameter("title", title);
		List<TeacherEntity> teacher = query.getResultList();
		return teacher;
	}
	
	public static void addTeacher(TeacherEntity t) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();
		em.close();
	}

	public static int updateStudent(Department d, String title) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query= em.createQuery("UPDATE StudentEntity s SET s.dept=?1 WHERE s.title=?2");
		query.setParameter(1, d);
		query.setParameter(2, title);
		int res = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		return res;
	}

}
