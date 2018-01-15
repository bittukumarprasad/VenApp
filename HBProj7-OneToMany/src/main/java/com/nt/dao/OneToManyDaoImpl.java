package com.nt.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumbers;
import com.nt.domain.User;
import com.nt.utility.HibernateUtility;

public class OneToManyDaoImpl implements OneToManyIDao {

	@Override
	public String saveObject() {
		Session ses=null;
		Transaction tx=null;
		User user=null;
		PhoneNumbers pnr1,pnr2=null;
		//=====create thye Session===========//
		ses=HibernateUtility.getSession();
		
		//=======create the user Objcet======//
		user=new User();
		user.setUserid(1001);
		user.setFirstName("jayadeba");
		user.setLastName("jena");
		user.setAddrs("bbsr");
		
		//========Create PhoneNumber class=====//
		pnr1=new PhoneNumbers();
		pnr1.setPhone(9999999);
		pnr1.setNumbertype("persinal");
		pnr1.setProvider("Airtel");
		
		pnr2=new PhoneNumbers();
		pnr2.setPhone(9999999);
		pnr2.setNumbertype("persinal");
		pnr2.setProvider("Airtel");
		
		//==========Add The number into the Set=====//
		Set<PhoneNumbers> set=new HashSet();
		set.add(pnr1);
		set.add(pnr2);
		//============aad the Set to the User======//
		user.setPhones(set);
		
		
	//==========save the Object in Trasaction environment========//
		try{
		tx=ses.beginTransaction();
		ses.save(user);
		tx.commit();
		return "Object Saved!!!";
		}
		catch(Exception e){
			
			tx.rollback();
			
		}
		return null;
	}

}
