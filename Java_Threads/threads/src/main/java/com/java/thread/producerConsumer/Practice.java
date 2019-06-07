package com.java.thread.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Practice {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
		Producer p1 = new Producer(q, "P1");
		Producer p2 = new Producer(q, "P2");
		
		Consumer c1 = new Consumer(q, "C1");
//		Consumer c2 = new Consumer(q, "P2");
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p1);
		Thread t3 = new Thread(c1);
//		Thread t4 = new Thread(c1);
		
		t1.start();
		t2.start();
		t3.start();
//		t4.start();
		
		try {
			t1.join(); 
			t2.join(); 
			t3.join(); 
//			t4.join(); 
		} catch(InterruptedException ie) {
			
		}
	}
	

}

class Producer implements Runnable {

	private final BlockingQueue<Integer> q;
	private String name;

	public Producer(BlockingQueue<Integer> q, String name) {
		this.q = q;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			Random r = new Random();
			int d = r.nextInt(100);
			System.out.println("Producer : " + name + " is inserting data: " + d);
			try {
				q.put(d);
				System.out.println(name + " pushed data.");
				TimeUnit.SECONDS.sleep(14);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Consumer implements Runnable {

	private final BlockingQueue<Integer> q;
	private String name;

	public Consumer(BlockingQueue<Integer> q, String name) {
		this.q = q;
		this.name = name;
	}
	
	@Override
	public void run() {
		while(true) {
			
			System.out.println("Consumer : " + name + " is removing data: ");
			try {
				int d = q.take();
				System.out.println(name + " fetched data: " + d);
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
