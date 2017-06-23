package com.hib.dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.hib.entity.Student;
import com.hib.util.HibernateUtil;

public class HibDaoOperations {
	public static void insertStudentDetails(Student s) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(s);
		t.commit();
		System.out.println("Insertion is Successful");
	}

	public static List getStudentbyID(int sid) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("From Student where studentid=:S");
		query.setParameter("S", sid);
		List result = query.list();
		t.commit();
		System.out.println("success");
		return result;

	}

	public static void updateStudentDetails(Student s) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		int sid = s.getStudentid();
		String sname = s.getSname();
		String course = s.getScourse();
		String add = s.getSadd();
		Query query = session.createQuery("update Student set sname=:sn,scourse=:sc,sadd=:sa where studentid=:si");
		query.setString("sn", sname);
		query.setString("sc", course);
		query.setString("sa", add);
		query.setInteger("si", sid);
		int status = query.executeUpdate();
		t.commit();
		// session.close();
		if (status == 1)
			System.out.println("Details updated successfully for Student id:" + sid);
		else
			System.out.println("updation operation failed");

	}

	public static void deleteStudentById(int sid) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete from Student where studentid=:S");
		query.setParameter("S", sid);
		int status = query.executeUpdate();
		t.commit();
		if (status == 1)
			System.out.println("Details deleted successfully for Student id:" + sid);
		else
			System.out.println("updation operation failed");
		// session.close();

	}

	public static void getStudentByPattern(char c) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("From Student  where STUDENTNAME  like :s");
		query.setParameter("s", c+"%");
		List Stulist = query.list();
		for (Iterator<Student> itr = Stulist.iterator(); itr.hasNext();) {
			Student s=(Student)itr.next();
			System.out.println(s.getStudentid()+"\t"+s.getSname()+"\t"+s.getScourse()+"\t"+s.getSadd());
		}
	}
}
