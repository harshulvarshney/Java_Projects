package com.java.thread;

import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class BQSample {
	
	private List<T> list = new LinkedList<>();
	private final int LIMIT = 2;
	
	public synchronized void enque(T item) throws InterruptedException {
		while(list.size() == LIMIT) {
			wait();
		}
		if(list.size() == 0)
			notifyAll();
		list.add(item);
	}
	
	public synchronized void deque(T item) throws InterruptedException {
		while(list.size() == 0) {
			wait();
		}
		if(list.size() == LIMIT)
			notifyAll();
		
		list.remove(0);
	}

}
