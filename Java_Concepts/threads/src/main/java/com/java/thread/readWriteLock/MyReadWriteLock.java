package com.java.thread.readWriteLock;

import java.util.HashMap;
import java.util.Map;

/**
 * the conditions for getting read and write access to the resource:
		Read Access   	If no threads are writing, and no threads have requested write access.
		Write Access   	If no threads are reading or writing.
  Writing thread should be given preference.

		
 * @author harshul.varshney
 *
 */
public class MyReadWriteLock {
	
	private int writingThreads = 0;
	private int writeRequests = 0;
	private Thread writingThread = null;
	private Map<Thread, Integer> readingThreads = new HashMap<Thread, Integer>();
	
	/*
	 * Taking read lock.
	 */
	public synchronized void lockRead() throws InterruptedException {
		Thread requestingThread = Thread.currentThread();
		while(!canGrantReadAccess(requestingThread))
			wait();
		
		readingThreads.put(requestingThread, getReadAccessCount(requestingThread));
	}
	
	/*
	 * Releasing read lock.
	 */
	public synchronized void unlockRead() {
		Thread requestingThread = Thread.currentThread();
		if(!isReader(requestingThread)) {
			throw new IllegalMonitorStateException("Calling Thread does not hold a read lock on MyReadWriteLock");
		}
		int readAccessCount = getReadAccessCount(requestingThread);
		if(readAccessCount == 1){ readingThreads.remove(requestingThread); }
	    else { readingThreads.put(requestingThread, (readAccessCount -1)); }
	    notifyAll();
	}
	
	/*
	 * acquire lock for write
	 */
	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		Thread requestingThread = Thread.currentThread();
		while(!canGrantReadAccess(requestingThread)) 
			wait();
		
		writeRequests--;
		writingThreads++;
		writingThread = requestingThread;
		
	}
	
	/*
	 * release write lock.
	 */
	public synchronized void unlockWrite() {
		Thread requestingThread = Thread.currentThread();
		if(requestingThread != writingThread) {
			throw new IllegalMonitorStateException("Calling Thread does not hold the write lock on MyReadWriteLock");
		}
		writingThreads--;
		if(writingThreads == 0) 
			writingThread = null;
		
		notifyAll();
	}
	
	private boolean canGrantReadAccess(Thread requestingThread) {
		if(isWrite(requestingThread)) return true;
		if(hasWriter()) return false;
		if( isReader(requestingThread)) return true;
	    if( hasWriteRequests()) return false;
	    return true;
	}
	
	private boolean isWrite(Thread requestingThread) {
		return writingThread == requestingThread;
	}
	private boolean hasWriter() {
		return writingThread != null;
	}
	private boolean isReader(Thread requestingThread) {
		return readingThreads.get(requestingThread) != null;
	}
	private boolean hasWriteRequests() {
		return writeRequests > 0;
	}
	private int getReadAccessCount(Thread requestingThread) {
		Integer count = readingThreads.get(requestingThread);
		return count == null ? 0 : count;
	}
	
}
