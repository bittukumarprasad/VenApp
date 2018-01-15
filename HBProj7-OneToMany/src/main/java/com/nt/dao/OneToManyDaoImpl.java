package com.nt.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumbers;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyIDao {

	@Override
	public void saveObject() {
		Session ses = null;
		Transaction tx = null;
		User user = null;
		PhoneNumbers pnr1, pnr2 = null;
		// =====create thye Session===========//
		ses = HibernateUtil.getSession();

		// =======create the user Objcet======//
		user = new User();
		user.setUserid(1001);
		user.setFirstName("jayadeba");
		user.setLastName("jena");
		user.setAddrs("bbsr");

		// ========Create PhoneNumber class=====//
		pnr1 = new PhoneNumbers();
		pnr1.setPhone(9999999);
		pnr1.setNumbertype("persinal");
		pnr1.setProvider("Airtel");

		pnr2 = new PhoneNumbers();
		pnr2.setPhone(88888);
		pnr2.setNumbertype("office");
		pnr2.setProvider("Aircel");

		// ==========Add The number into the Set=====//
		Set<PhoneNumbers> set = new HashSet();
		set.add(pnr1);
		set.add(pnr2);
		// ============aad the Set to the User======//
		user.setPhones(set);

		// ==========save the Object in Trasaction environment========//
		try {
			tx = ses.beginTransaction();
			ses.save(user);
			tx.commit();
			System.out.println("object Saved");
		} catch (Exception e) {

			tx.rollback();

		}

	}

	@Override
	public void deleteChild() {
		Session ses = null;
		Transaction tx = null;
		PhoneNumbers phn = null;
		 Set<PhoneNumbers> pnr = null;
		User user = null;
		// ========get the Session==========//
		ses = HibernateUtil.getSession();

		// ====Load the Parent=======//
		user =(User)ses.get(User.class,1001);
		// ===get the Childs=====//
		try{
	           pnr =user.getPhones();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		// get the particular child object
		phn = (PhoneNumbers)ses.get(PhoneNumbers.class,(long)9999999);
		System.out.println(phn);
		System.out.println(pnr);
       try{
    	   tx=ses.beginTransaction();
            pnr.remove(phn);
    	   tx.commit();
    	   System.out.println("Child Object Deleted");
       }
       catch(Exception e)
       {
    	   tx.rollback();
       }
       
	}

}
