package com.java.thread.semaphore;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author harshul.varshney
 *
 */
public class BoundedSemaphoreDemo {

	public static void main(String[] args) {
		CustomBoundedSemaphore customSemaphore = new CustomBoundedSemaphore(2);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String name = Thread.currentThread().getName();
					customSemaphore.acquire();
					System.out.println(name
							+ "Acquired the permit, going to work on critical section for next 5 seconds");
					TimeUnit.SECONDS.sleep(5);
					System.out.println(name + "Completed work, releasing permit");
					customSemaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String name = Thread.currentThread().getName();
					customSemaphore.acquire();
					System.out.println(name
							+ "Acquired the permit, going to work on critical section for next 10 seconds");
					TimeUnit.SECONDS.sleep(10);
					System.out.println(name + "Completed work, releasing permit");
					customSemaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String name = Thread.currentThread().getName();
					customSemaphore.acquire();
					System.out.println(name
							+ "Acquired the permit, going to work on critical section for next 8 seconds");
					TimeUnit.SECONDS.sleep(8);
					System.out.println(name + "Completed work, releasing permit");
					customSemaphore.release();
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
