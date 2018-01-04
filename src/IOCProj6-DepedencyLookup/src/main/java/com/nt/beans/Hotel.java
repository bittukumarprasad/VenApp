package com.nt.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Hotel {
	// =======property==========//
	private String beanId;

	// ==========StterMethod=========//
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public void eat() {
		BeanFactory factory = new XmlBeanFactory(
				new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml"));
				Manu manu = factory.getBean("beanId", Manu.class);
				manu.chiken();
				manu.sweet();
	}
	
	public void ac(){
		System.out.println("A/C is doing on");
	}

}
