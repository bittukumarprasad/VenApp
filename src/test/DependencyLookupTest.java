package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.Hotel;


public class DependencyLookupTest {

	public static void main(String[] args) {
		BeanFactory factory=null;
	   Hotel hot=null;
	   
		//==========create IOC container=============//
		factory=new XmlBeanFactory(new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml"));
		
		//=========get Beans=============//
		hot=factory.getBean("hotel",Hotel.class);
		hot.eat();
		hot.ac();
	}//main
}//class
