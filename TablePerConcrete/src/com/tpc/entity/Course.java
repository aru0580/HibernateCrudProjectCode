package com.tpc.entity;

public class Course {
private String Courseid;
private String Coursename;
private int duration;
public String getCourseid() {
	return Courseid;
}
public void setCourseid(String courseid) {
	Courseid = courseid;
}
public String getCoursename() {
	return Coursename;
}
public void setCoursename(String coursename) {
	Coursename = coursename;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}

}
