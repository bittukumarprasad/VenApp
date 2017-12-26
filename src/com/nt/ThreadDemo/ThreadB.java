package com.nt.ThreadDemo;

public class ThreadB extends Thread {
	int total=0;
	
	public void run() {
		for(int i=0;i<=100;i++)
		{
			total=total+i;
		}
	}

}
