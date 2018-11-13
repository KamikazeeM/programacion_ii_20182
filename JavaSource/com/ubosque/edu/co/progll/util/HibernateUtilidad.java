package com.ubosque.edu.co.progll.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilidad {
	private static final SessionFactory sf = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSf() {
		return sf;
	}
}
