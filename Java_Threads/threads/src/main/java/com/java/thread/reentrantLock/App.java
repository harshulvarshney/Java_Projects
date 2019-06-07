package com.java.thread.reentrantLock;

public class App {
	
	public static void main(String[] s) {
		RunnerWithCondition obj = new RunnerWithCondition();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.firstThreadMethod();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.secondThreadMethod();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		obj.finished();
	}

}
