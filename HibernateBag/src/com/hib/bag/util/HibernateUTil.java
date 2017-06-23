package com.hib.bag.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUTil {
public static SessionFactory sFactory=null;
static{
	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
	builder.applySettings(configuration.getProperties());
	StandardServiceRegistry registry = builder.build();
	sFactory = configuration.buildSessionFactory(registry);
}
	public static SessionFactory getSessionFactory() {
		return sFactory;
	}

	public static void closeSessionFactory()
{
		if (sFactory != null) 
		{
			sFactory.close();
		}
	}	
}
