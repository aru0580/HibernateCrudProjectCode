package com.hib.entity;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="EMPLOYEES")
public class Employee {
private int empid;
private String empname;
private String empadd;
@ManyToOne(optional = false,targetEntity = Department.class)
@JoinColumn(name="deptid")
private Department dept;
@Id
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getEmpadd() {
	return empadd;
}
public void setEmpadd(String empadd) {
	this.empadd = empadd;
}
public Department getDept() {
	return dept;
}
public void setDept(Department dept) {
	this.dept = dept;
}
}
