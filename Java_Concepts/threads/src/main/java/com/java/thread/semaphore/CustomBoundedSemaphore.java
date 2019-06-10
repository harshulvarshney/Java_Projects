package com.java.thread.semaphore;

/**
 * A Semaphore is a thread synchronization construct that can be used either to send signals 
 * between threads to avoid missed signals, or to guard a critical section like you would with 
 * a lock. Java 5 comes with semaphore implementations in the java.util.concurrent package.
 * 
 * below is a sample implementation of {@link java.util.concurrent.Semaphore} class.
 * 
 * A semaphore can be used as counting semaphore, bounded semaphore or a lock (by using single permit).
 * 
 * @author harshul.varshney
 */
public class CustomBoundedSemaphore {
	
	private final int MAX_PERMITS;
	private int permitsAcquired;
	
	public CustomBoundedSemaphore(int maxPermits) {
		MAX_PERMITS = maxPermits;
	}
	
	public synchronized void acquire() throws InterruptedException {
		while(permitsAcquired == MAX_PERMITS) {
			System.out.println("No permits available. "+Thread.currentThread().getName() + " will wait.");
			wait();
		}
		permitsAcquired++;
		notifyAll();
	}
	
	public synchronized void release() throws InterruptedException {
		while(permitsAcquired == 0) {
			wait();
		}
		permitsAcquired--;
		notifyAll();
	}

}
