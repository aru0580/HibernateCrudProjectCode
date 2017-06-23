package test;
import java.util.*;
import org.hibernate.*;
import hibernate.util.*;
import hibernate.entity.*;

public class Test {

	public static void main(String[] args) {
		SessionFactory sFactory = null;
		Session session = null;
		Transaction t = null;
		boolean f = false;
		try {
			sFactory = HibernateUTil.getSessionFactory();
			session = sFactory.getCurrentSession();
			t = session.beginTransaction();
			Product p1=new Product();
			p1.setPname("Nokia");
			p1.setPid("p001");
			p1.setPcost("10000");
			List<Product> list=new ArrayList<>();
			list.add(p1);
			Product p2=new Product();
			p2.setPid("p002");
			p2.setPname("Samsung");
			p2.setPcost("20000");
			list.add(p2);
			Sales s1=new Sales();
			s1.setOrderid("O01");
			s1.setOrderdate(new Date());
			s1.setProduct(list);
			session.save(p1);
			session.save(p2);
			session.save(s1);
			f=true;
		} finally {
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