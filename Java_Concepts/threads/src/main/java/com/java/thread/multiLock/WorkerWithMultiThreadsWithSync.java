package com.java.thread.multiLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Output:
				Hello
				processing ... 
				processing ... 
				Total time taken: 4316
				List1: 2000
				List2: 2000
 * Below program works fine and does not throw any exception but it takes approx 4 seconds to complete.
 * Reason being: when any one thread enters any of the stages, it takes lock on the class object, so 
 * other thread can not even execute other stage.
 * 
 * Solution: Use multiple locks.
 * 
 * @author Charu
 *
 */
public class WorkerWithMultiThreadsWithSync {
	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	public void main() {
		System.out.println("Hello");
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Total time taken: " + (end-start));
		System.out.println("List1: "+list1.size());
		System.out.println("List2: "+list2.size());
	}
	
	/**
	 * Calls each stage for a 1000 times and each stage makes the 
	 * running thread to sleep for a mili sec.
	 */
	public void process() {
		System.out.println("processing ... ");
		for(int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public synchronized void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
	}
	
	public synchronized void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
	}
}
