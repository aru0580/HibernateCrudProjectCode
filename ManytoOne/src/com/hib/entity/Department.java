package com.hib.entity;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="Department")
public class Department {
private int deptid;
private String deptname;

@Id
public int getDeptid() {
	return deptid;
}
public void setDeptid(int deptid) {
	this.deptid = deptid;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
}
