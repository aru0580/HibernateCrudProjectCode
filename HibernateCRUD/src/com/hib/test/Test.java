package com.hib.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.hib.dao.HibDaoOperations;
import com.hib.entity.Student;

public class Test {

	public static void main(String[] args) {
		HibDaoOperations hdao = new HibDaoOperations();
		boolean flag = true;
		do {
			Student s1 = new Student();
			System.out.println("Select any MENU item:");
			System.out.println("1.Insert\t2.Retrieve\t3.Update\t4.delete\t5.Search\t6.Exit");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			int sid;
			switch (ch) {
			case 1:
				System.out.println("enter Student details:/n");
				System.out.println("ID:");
				s1.setStudentid(sc.nextInt());
				System.out.println("Name:");
				s1.setSname(sc.next());
				System.out.println("Course:");
				s1.setScourse(sc.next());
				System.out.println("Address:");
				s1.setSadd(sc.next());
				hdao.insertStudentDetails(s1);
				/*Student s2 = new Student(2, "Vinod", "CSE", "MBNR");
				hdao.insertStudentDetails(s2);
				Student s3 = new Student(3, "Ravi", "Mca", "Vizag");
				hdao.insertStudentDetails(s3);*/
				break;
			case 2:
				System.out.println("enter Student id to get details:");
				sid = sc.nextInt();
				List student = hdao.getStudentbyID(sid);
				Iterator itr = student.iterator();
				while (itr.hasNext())
				// for (Iterator<Student> itr = student.iterator();
				// itr.hasNext();)
				{
					Student s = (Student) itr.next();
					System.out
							.println(s.getStudentid() + " " + s.getSname() + " " + s.getScourse() + " " + s.getSadd());
				}
				break;
			case 3:
				System.out.println("enter Student id to be modified:\n");
				s1.setStudentid(sc.nextInt());
				System.out.println("Updated Name:");
				s1.setSname(sc.next());
				System.out.println("Updated Course:");
				s1.setScourse(sc.next());
				System.out.println("Updated Address:");
				s1.setSadd(sc.next());
				/*Student s4 = new Student(2, "Sravanthi", "CSE", "KNR");*/
				hdao.updateStudentDetails(s1);
				break;
			case 4:
				System.out.println("enter Student id to be deleted:");
				sid = sc.nextInt();
				hdao.deleteStudentById(sid);
				break;
			case 5:
				System.out.println("enter any charcter to find matching student details\n");
				char A = sc.next().charAt(0);
				hdao.getStudentByPattern('A');
				break;
			case 6:
				flag = false;
				System.out.println("Exited");
				break;
			default:
				System.out.println("please select valid option");
				break;
			}
		} while (flag==true);
	}
}
