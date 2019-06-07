package com.java.thread.reentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerWithCondition {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
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
		System.out.println("first method called");
		lock.lock();
		
		System.out.println("Going to wait");
		cond.await(); //same is calling wait() inside a synchronized block. it releases the lock.
		
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
		System.out.println("second method called");
		lock.lock();
		
		System.out.println("Enter return key");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key");
		
		cond.signal();
		
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
