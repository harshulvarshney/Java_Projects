package com.java.thread.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Producer Consumer design pattern demo.
 * This class has 2 methods : producer and consumer
 * they will run in 2 different threads.
 * A BlockingQueue is used to implement this pattern, it's a thread safe class.
 * 
 * @author harshul
 *
 */
public class PCWithBlockingQueue {
	/*
	 * Below class is already thread safe so no need for synchronization here.
	 */
	static final BlockingQueue<Integer> q = new ArrayBlockingQueue<>(5);
	
	public static void main(String[] s) {
		Thread t1 = new Thread(() -> {
			try {
				System.out.println("Running t1");
				producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				System.out.println("Running t2");
				consumer();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}
	
	private static void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			Integer i = random.nextInt(100);
			System.out.println("Q size = " + q.size() + "; puttinh = " + i);
			q.put(i);
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			System.out.println("Going to sleep....");
			TimeUnit.SECONDS.sleep(4);
			System.out.println("Waking up.........");
//			if(random.nextInt(10) == 0) {
				Integer i = q.take();
				System.out.println("Taken from Q = " + i + "; Q size now = " + q.size());
//			}
		}
	}

}
