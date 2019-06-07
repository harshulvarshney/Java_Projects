package com.java.thread;

/**
 * There are 2 ways we can create a thread in java:
 * 	1-By extending Thread class
 * 	2-By implementing Runnable interface
 * 
 * @author harshul
 *
 */
public class ThreadSample1 {
	
	public static void main(String[] args) {
		new Thread1().start();
		
		Thread thread2 = new Thread(new Thread2());
		thread2.start();
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is running");				
			}
			
		});
		thread3.start();
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		Thread t = new Thread(task);
		t.start();
	}

}

class Thread1 extends Thread {
	
	@Override
	public void run() {
		System.out.println("This is " + this.getClass().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread 1 complete.");
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("This is " + this.getClass().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread 2 complete.");
	}
	
}

