package com.java.thread.readWriteLock;

/**
 * the conditions for getting read and write access to the resource:
 *		Read Access   	If no threads are writing, and no threads have requested write access.
 *		Write Access   	If no threads are reading or writing.
 *  Writing thread should be given preference.
 *  
 *  there can be more then 1 reading threads at a time but only one writing thread.
 *  
 * @author harshul.varshney
 */
public class MyreadWriteLockSimple {
	
	private int writingThreads = 0;
	private int writingRequests = 0;
	private int readingThreads = 0;
	
	public void lockRead() throws InterruptedException {
		synchronized (this) {
			while(writingRequests > 0 || writingThreads > 0)
				wait();
			
			readingThreads++;
		}
	}
	
	public void unlockRead() throws InterruptedException {
		synchronized (this) {
			if(readingThreads > 0) {
				readingThreads--;
				notifyAll();
			}
		}
	}
	
	public void lockWrite() throws InterruptedException {
		synchronized (this) {
			writingRequests++;
			while(writingThreads > 0 || readingThreads > 0) {
				wait();
			}
			
			writingRequests--;
			writingThreads++;
		}
	}
	
	public void unlockWrite() {
		synchronized (this) {
			if(writingThreads > 0) {
				writingThreads--;
				notifyAll();
			}
		}
	}

}
