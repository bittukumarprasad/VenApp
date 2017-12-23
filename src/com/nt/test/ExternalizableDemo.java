package com.nt.test;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableDemo implements java.io.Externalizable {
	String s;
	int i;
	int j;
	
	//-------------constructor---------------------
	public ExternalizableDemo() {
		System.out.println("ExternalizableDemo:0-param constructor");
	}
	
//-----------parameterize Constructor----------------------
	public ExternalizableDemo(String s, int i, int j) {
		super();
		this.s = s;
		this.i = i;
		this.j = j;
		System.out.println("ExternalizableDemo:parameterized constructor");
		
	}


	public void writeExternal(ObjectOutput out) throws IOException {
	out.writeObject(s);
	out.writeInt(i);

	}

	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		s=(String) in.readObject();
		i=in.readInt();
	}

}
