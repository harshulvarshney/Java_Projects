package com.java.thread.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates how deadlock happens.
 * Using Lock objects for demonstration.
 * 
 * @author harshul
 *
 */
public class Runner {
	
	private Account acc1 = new Account();
	private Account acc2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	public void firstThreadMethod() throws InterruptedException {
		Random random = new Random();
		System.out.println("thread 1 going to acquire lock1");
		lock1.lock();
		System.out.println("thread 1 accouired lock1, going to acquire lock2");
		lock2.lock();
		try {
			for(int i = 0; i<10; i++) {
				Account.transfer(acc1, acc2, random.nextInt(100));
			}
			
		}
		finally {
			lock1.unlock();
			lock2.unlock();
		}
	}
	
	public void secondThreadMethod() throws InterruptedException {
		Random random = new Random();
		System.out.println("thread 2 going to acquire lock2");
		lock2.lock();//If order of lock1 and lock2 is reversed here, it will work fine.
		System.out.println("thread 2 accouired lock1, going to acquire lock1");
		lock1.lock();
		try {
			for(int i = 0; i<10; i++) {
				Account.transfer(acc2, acc1, random.nextInt(100));
			}
		}
		finally {
			lock1.unlock();
			lock2.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Account1 balance is " + acc1.getBalance());
		System.out.println("Account2 balance is " + acc2.getBalance());
		System.out.println("Total Bal: " + (acc1.getBalance() + acc2.getBalance()));
	}

}
