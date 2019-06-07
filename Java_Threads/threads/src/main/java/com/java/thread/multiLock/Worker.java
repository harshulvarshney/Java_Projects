package com.java.thread.multiLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Normal Java Class without any thread.
 * Check out the time taken to complete 2 stages in below output:
				  	Hello
					processing ... 
					Total time taken: 2142
					List1: 1000
					List2: 1000
	As you can see, total time taken is approx 2 seconds and each list has 1000 integers at the end.
					
 * @author harshul
 *
 */
public class Worker {

	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	public void main() {
		System.out.println("Hello");
		long start = System.currentTimeMillis();
		
		process();
		
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
