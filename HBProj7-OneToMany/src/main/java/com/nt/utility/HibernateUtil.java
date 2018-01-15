package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> tl=new ThreadLocal<Session>();
	private static Session session;
	static{
		System.out.println("HU:Thread--->"+Thread.currentThread().getName());
	//create SessionFactory obj
	factory=new Configuration().
		          configure("/com/nt/cfgs/hibernate.cfg.xml").
		           buildSessionFactory();
	}
	public static Session getSession(){
		System.out.println("HU:Thread--->"+Thread.currentThread().getName());
		if(tl.get()==null){
			session=factory.openSession();
			tl.set(session);
		}
		session=tl.get();
		return session;
	}
	
	public static void closeSession(){
		 if(tl.get()!=null){
			 tl.get().close(); //close Session
			 tl.remove();
		 }
	}
	
	public static void closeSessionFactory(){
		 factory.close();
	}
}
