package com.nt.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ExternalizableDemo u=new ExternalizableDemo("jaya",12,52);
		FileOutputStream file=new 	FileOutputStream("D:\\abc.txt");
		ObjectOutputStream obj=new ObjectOutputStream(file);
		obj.writeObject(u);
		
		
		FileInputStream ins=new 	FileInputStream("D:\\abc.txt");
		ObjectInputStream objin=new ObjectInputStream(ins);
		

		ExternalizableDemo u1=(ExternalizableDemo) objin.readObject();
		System.out.println(u1.s+"===="+u1.i+"===="+u1.j); 

	}

}


