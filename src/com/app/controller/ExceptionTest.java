package com.app.controller;

import java.util.Scanner;

public class ExceptionTest {


public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the a/c number!!!");
	String ac=sc.nextLine();
	StringBuffer s1=getAccount(ac);
	System.out.println("Your a/c number is:::"+s1);
	}
public static StringBuffer getAccount(String ac){
	StringBuffer s=new StringBuffer();
	char[] ch=ac.toCharArray();
	for(int i=0;i<ch.length-4;i++){
		s.append("*");
	}
	for(int j=ch.length-4;j<ch.length;j++){
		s.append(ch[j]);
	}
	return s;
	
	
}

}
