package com.nt.Client;

import com.nt.dao.OneToManyDaoImpl;
import com.nt.dao.OneToManyFactory;
import com.nt.utility.HibernateUtil;


public class ClientApp {

	public static void main(String[] args) {
		OneToManyDaoImpl dao=null;
	
		//==========Create the DaoImpl object===========//
		dao=OneToManyFactory.getInstance();
		dao.deleteChild();
		//=======Close the Session & SessionFactory()=======//
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}

}
