package com.java.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author harshul.varshney
 *
 */
public class PCWithExecuter {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
		ExecutorService es = Executors.newFixedThreadPool(4);
		for(int i=0; i < 2; i++) {
			es.submit(new Producer(q, "PRO-"+i));
		}
		for(int i=0; i < 2; i++) {
			es.submit(new Consumer(q, "CON-"+i));
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
