package com.java.thread.semaphore;

/**
 * used for signalling between threads.
 * a signal miss can be avoided by using it.
 * 
 * @author harshul.varshney
 *
 */
public class CustomCountingSemaphore {
	
	private int signals = 0;
	
	public synchronized void signal() {
		signals++;
		notifyAll();
	}
	
	public synchronized void check() throws InterruptedException {
		while(signals == 0)  {
			System.out.println(Thread.currentThread().getName() + " is going to wait for signal.");
			wait();
		}
		System.out.println(Thread.currentThread().getName() + " acquired the signal");
		signals--;
	}

}
