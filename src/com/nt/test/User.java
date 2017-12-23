package com.nt.test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
 String username = "jayadeba";
	String password = "santilata";

	private void writeObject(ObjectOutputStream os) throws Exception {
		System.out.println("write object");
		os.defaultWriteObject();
		String epassword = "123" + password;
		os.writeObject(epassword);
	}

	private void readObject(ObjectInputStream is) throws Exception {
		System.out.println("Read object");
		is.defaultReadObject();
		String epassword = (String) is.readObject();
		System.out.println("read object::"+password);
		password = epassword.substring(3);
	}
}
