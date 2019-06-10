package com.java8.thread;

import java.util.LinkedList;
import java.util.Queue;

public class FairLock {
	
	private Queue<LockObject> threads = new LinkedList<>();
	private boolean locked = false;;
	private Thread lockingThread = null;
	
	public void lock() throws InterruptedException {
		LockObject lockOb = new LockObject();
		synchronized (this) {
			
			while(locked) {
				threads.add(lockOb);
				lockOb.wait();
			}
			
			lockingThread = Thread.currentThread();
			locked = true;
		}
	}
	
	public void unlock() {
		if(lockingThread != Thread.currentThread())
			throw new IllegalMonitorStateException("Can not release lock before taking it");
		
		locked = false;
		lockingThread = null;
		if(threads.size() > 0)
			threads.poll().notify();
	}
	
	static class LockObject {
		private boolean notified;
		
		public synchronized void doNotify() {
			notified = true;
			this.notify();
		}
		
		public synchronized void doWait() throws InterruptedException {
			while(!notified)
				wait();
			
			notified = false;
		}
		
	}

}
