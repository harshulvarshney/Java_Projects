package com.java.thread.problems;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author harshul
 *
 */
public class MultiThreadSync {
	
	public static void main(String[] s) {
		boolean[] arr = new boolean[3];
		arr[0] = true;
		Object lock = new Object();
		
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
					synchronized (lock) {
						while(!arr[0])
							lock.wait();
						System.out.println(Thread.currentThread().getName() + " is running");
						TimeUnit.SECONDS.sleep(2);
						arr[1] = true;
						arr[0] = false;
						lock.notifyAll();
					}
					}
				} catch(InterruptedException e) {
					
				}
			}
		};
		
		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
					synchronized (lock) {
						while(!arr[1])
							lock.wait();
						System.out.println(Thread.currentThread().getName() + " is running");
						TimeUnit.SECONDS.sleep(2);
						arr[2] = true;
						arr[1] = false;
						lock.notifyAll();
					}
					}
				} catch(InterruptedException e) {
					
				}
			}
		};
		
		Runnable t3 = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
					synchronized (lock) {
						while(!arr[2])
							lock.wait();
						System.out.println(Thread.currentThread().getName() + " is running");
						TimeUnit.SECONDS.sleep(2);
						arr[0] = true;
						arr[2] = false;
						lock.notifyAll();
					}
					}
				} catch(InterruptedException e) {
					
				}
			}
		};
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		Thread th3 = new Thread(t3);
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch(InterruptedException ie) {
			
		}
		
	}
}


