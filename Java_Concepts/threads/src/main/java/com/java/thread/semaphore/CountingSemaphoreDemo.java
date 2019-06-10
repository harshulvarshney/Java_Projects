package com.java.thread.semaphore;

import java.util.concurrent.TimeUnit;

/**
 * If thread-1 runs first and notifies all threads, it's signal will be missed if there is no thread waiting,
 * By using a count in semaphore, we keep track of all the signals.
 * 
 * Thread-2 and 3 can utilize this saved semaphore count as signals for their task.
 * 
 * @author harshul.varshney
 *
 */
public class CountingSemaphoreDemo {
	
	public static void main(String[] args) {
		CustomCountingSemaphore customSemaphore = new CustomCountingSemaphore();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String name = Thread.currentThread().getName();
					while(true) {
						customSemaphore.signal();
						System.out.println(name + " signaled");
						TimeUnit.SECONDS.sleep(3);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						TimeUnit.SECONDS.sleep(7);
						String name = Thread.currentThread().getName();
						System.out.println(name + " is going to check if any signal present.");
						customSemaphore.check();
						System.out.println(name + " received signal.");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						TimeUnit.SECONDS.sleep(8);
						String name = Thread.currentThread().getName();
						System.out.println(name + " is going to check if any signal present.");
						customSemaphore.check();
						System.out.println(name + " received signal.");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.setName("Thread-1");
		t2.setName("Thread-2");
		t3.setName("Thread-3");

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
