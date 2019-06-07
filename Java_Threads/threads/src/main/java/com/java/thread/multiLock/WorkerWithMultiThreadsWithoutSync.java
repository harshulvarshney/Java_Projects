package com.java.thread.multiLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * When you call process method of this class, you will see that sometime you are getting below output:
 			Hello
			processing ... 
			processing ... 
			Total time taken: 2118
			List1: 1994
			List2: 1995
   And sometimes you are getting an exception:
   			Hello
			processing ... 
			processing ... 
			Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: 49
				at java.util.ArrayList.add(Unknown Source)
				at com.java.thread.multiLock.WorkerWithMultiThreadsWithoutSync.stageOne(WorkerWithMultiThreadsWithoutSync.java:79)
				at com.java.thread.multiLock.WorkerWithMultiThreadsWithoutSync.process(WorkerWithMultiThreadsWithoutSync.java:68)
				at com.java.thread.multiLock.WorkerWithMultiThreadsWithoutSync$2.run(WorkerWithMultiThreadsWithoutSync.java:41)
				at java.lang.Thread.run(Unknown Source)
			Total time taken: 2147
			List1: 1024
			List2: 1023
			
  This is because both threads are simultaneously running and accessing list1 and list2.
  Writing to a list is not a single step process, so if 1 thread writing to a list and doesn't completes its work
  and second thread comes alive and try to write to same list, it may lead to unexpected exceptions.
  
  Solution to this problem is to make method synchronized.
  
  
 * @author harshul
 *
 */
public class WorkerWithMultiThreadsWithoutSync {
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
	
	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
	}
	
	public void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
	}
}
