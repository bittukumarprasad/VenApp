package com.nt.colletionPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HashMapDemo {

	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
	//	FileInputStream fis = new FileInputStream(
	//			"C:\\Users\\B.Prasad\\git\\VenApp\\src\\com\\app\\properties\\abc.properties");
	
		FileInputStream fis = new FileInputStream(
					"C:\\Users\\B.Prasad\\git\\VenApp\\src\\com\\app\\properties\\abc.properties");
		
		p.load(fis);
		System.out.println(p);
	}

}
