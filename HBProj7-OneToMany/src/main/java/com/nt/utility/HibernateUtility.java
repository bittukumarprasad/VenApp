package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory=null;
	private static ThreadLocal<Session> threadlocal=new  ThreadLocal<Session>();
	static{
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static Session getSession(){
		Session ses=null;
		if(threadlocal.get()==null){
			ses=factory.openSession();
			threadlocal.set(ses);
		}
		else{
			ses=threadlocal.get();
		}
		return ses;
	}//getSession(-)
	
	public static  void closeSession(){
		if(threadlocal!=null){
		threadlocal.get().close();
		threadlocal.remove();
		}
	}//closeSession(-)
	
	public static void closeSessionFactory(){
		factory.close();
	}

}
