package com.nt.Client;

import com.nt.dao.OneToManyDaoImpl;
import com.nt.dao.OneToManyFactory;
import com.nt.utility.HibernateUtility;

public class ClientApp {

	public static void main(String[] args) {
		OneToManyDaoImpl dao=null;
	
		//==========Create the DaoImpl object===========//
		dao=OneToManyFactory.getInstance();
		dao.saveObject();
		//=======Close the Session & SessionFactory()=======//
		HibernateUtility.closeSession();
		HibernateUtility.closeSessionFactory();
	}

}
