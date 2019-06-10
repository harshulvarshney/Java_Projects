package com.java.thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant lock is an alternative of synchronized keyword.
 * Below is an example of how to implement it.
 * 
 * @author harshul
 *
 */
public class Runner {
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	
	private void increment() {
		for(int i = 0; i < 1000; i++) {
			count++;
		}
	}
	
	/**
	 * thread 1 will execute below method
	 * @throws InterruptedException
	 */
	public void firstThreadMethod() throws InterruptedException {
		lock.lock();
		try {		//try-finally is used to make sure that lock is released if anything goes wrong.
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * thread 2 will execute below method
	 * @throws InterruptedException
	 */
	public void secondThreadMethod() throws InterruptedException {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("count is " + count);
	}

}
