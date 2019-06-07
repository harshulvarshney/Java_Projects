package com.java.thread.lock;

import java.util.Deque;
import java.util.LinkedList;


/**
 * A custom lock implementation which will grant access to threads in first come first server manner - fairness. 
 *
 */
public class FairLock {
	
	private boolean lockAvailable = true;
	private Deque<LockObject> q = new LinkedList<>();
	
	public void lock() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " is trying to take lock");
		LockObject lockObject = new LockObject();
		synchronized (lockObject) {
			System.out.println(Thread.currentThread().getName() + " inside synchronized block");
			while(!lockAvailable) {
				q.offer(lockObject);
				System.out.println(Thread.currentThread().getName() + " is going to wait");
				lockObject.wait();
				System.out.println(Thread.currentThread().getName() + " got notification");
			}
			lockAvailable = false;
		}
	}
	
	public void unlock() {
		
		LockObject lockObject = q.poll();
		synchronized (lockObject) {
			lockObject.notify();
			lockAvailable = true;
		}
	}
	
	class LockObject {
		
	}

}
