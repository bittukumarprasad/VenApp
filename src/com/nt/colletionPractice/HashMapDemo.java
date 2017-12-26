package com.nt.colletionPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HashMapDemo {

	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
			"C:\\Users\\Jaydev\\git\\VenApp\\src\\com\\app\\properties\\abc.properties");
	
		//InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("com/app/properties/abc.properties");
		System.out.println(fis);
		p.load(fis);
		System.out.println(p);
	}

}
