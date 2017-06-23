package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import hiberante.be.*;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			Configuration configuration = new Configuration().configure("test/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder.applySettings(configuration.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = configuration.buildSessionFactory(registry);
			session = sessionFactory.getCurrentSession();
			transaction  = session.beginTransaction();
			Product p1 = new Product();
			p1.setPid("p03");
			p1.setPname("moto");
			p1.setPcost("10000");
			Product p2=new Product();
			p2.setPname("Htc");
            p2.setPid("p04");
            p2.setPcost("18000");
            session.save(p1);
            session.save(p2);
            transaction.commit();
            System.out.println("success");
		}
		finally
		{
			if (sessionFactory != null) {
				if (flag == true) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
		}
	}
}
