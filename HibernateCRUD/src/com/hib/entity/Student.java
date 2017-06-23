package com.hib.entity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
public class Student {

	private int studentid;
	private String sname;
	private String scourse;
	private String sadd;
public Student() {
		
	}
	public Student(int studentid, String sname, String scourse, String sadd) {
		this.studentid = studentid;
		this.sname = sname;
		this.scourse = scourse;
		this.sadd = sadd;
	}

	@Id
	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	@Column(name = "STUDENTNAME")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "SADDRESS")
	public String getScourse() {
		return scourse;
	}

	public void setScourse(String scourse) {
		this.scourse = scourse;
	}

	public String getSadd() {
		return sadd;
	}

	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

}
