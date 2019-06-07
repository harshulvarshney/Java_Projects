package com.java8.thread;

public class InterruptThread {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is running");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					System.out.println(name + " interrupted");
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is running");
				try {
					Thread.sleep(3000);
					t1.interrupt();
					synchronized (this) {
						System.out.println(name + " is going in indefinite wait");
						wait(2000);
					}
				} catch (InterruptedException e) {
					System.out.println(name + " interrupted");
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			System.out.println(">>>");
		}
	}

}
