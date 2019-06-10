package com.java.thread.multiLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Output:
				Hello
				processing ... 
				processing ... 
				Total time taken: 2172
				List1: 2000
				List2: 2000
  As can be seen, time taken in this example is approx 2 seconds. 
  Reason being: there are 2 separate locks for each stage, so when 1 thread is executing stageOne, other 
  can execute stageTwo simultaneously without causing any exception.
  
  We could have used list1 and list2 objects to take locks, but it's a good practice to create separate locks
  and dont use any data which is being modified by our program.
				
 * @author harshul
 *
 */
public class WorkerWithMultiThreadsMultiLock {
	
	Object lock1 = new Object();
	Object lock2 = new Object();
	
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
		System.out.println("processing ... "+Thread.currentThread().getName());
		for(int i = 0; i < 5; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void stageOne() {
		synchronized(lock1) {
			try {
				System.out.println(Thread.currentThread().getName()+" processing stage One");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	
	public void stageTwo() {
		synchronized(lock2) {
			try {
				System.out.println(Thread.currentThread().getName()+" processing stage Two");
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
}
