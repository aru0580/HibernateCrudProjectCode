package com.hib.test;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hib.entity.*;
import com.hib.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
	SessionFactory sFactory = null;
	Session session = null;
	Transaction t = null;
	boolean f = false;
	try
	{
		sFactory = HibernateUtil.getSessionFactory();
		session = sFactory.getCurrentSession();
		t = session.beginTransaction();
		Department d1=new Department();
		d1.setDeptid(5);
		d1.setDeptname("CSE");
		List <Department> dept=new ArrayList<>();
		dept.add(d1);
		Employee e1=new Employee();
		e1.setEmpid(501);
		e1.setEmpname("Barghavi");
		e1.setEmpadd("ECIL");
	    e1.setDept(d1);
		Employee e2=new Employee();
		e2.setEmpid(502);
		e2.setEmpname("RadhaKrishna");
		e2.setEmpadd("LBNagar");
		e2.setDept(d1);
		session.save(d1);
		session.save(e1);
		session.save(e2);
		session.close();
		f=true;
	}finally
	{
		if (sFactory != null) {
			if (f == true) {
				t.commit();
			} else {
				t.rollback();
			}
		}
	}
}
}
