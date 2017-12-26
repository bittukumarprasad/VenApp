package com.nt.ThreadDemo;

public class ThreadA {

	public static void main(String[] args) throws InterruptedException {
	ThreadB b=new ThreadB();
	b.start();
	Thread.sleep(10);
	System.out.println(b.total);

	}

}
