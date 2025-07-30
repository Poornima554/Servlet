package com.dcl.servlet.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TeacherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int t_id;
	private String t_name;
	private long t_contact;
	@Enumerated(EnumType.STRING)
	private Department dept;
	
	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public long getT_contact() {
		return t_contact;
	}

	public void setT_contact(long t_contact) {
		this.t_contact = t_contact;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "TeacherEntity [t_id=" + t_id + ", t_name=" + t_name + ", t_contact=" + t_contact + ", dept=" + dept
				+ "]";
	}

	
}
