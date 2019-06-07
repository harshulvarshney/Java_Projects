package com.java.thread.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrates how wait and notify works.
 * wait, notify and notifyAll are methods of object class.
 * calling wait() releases the lock also.
 * 
 * @author harshul
 *
 */
public class PCWithWaitAndNotify {

	private static int CAPACITY = 2;
	public static void main(String[] args) {
		Queue<Integer> list = new LinkedList<>();
		PCWithWaitAndNotify o = new PCWithWaitAndNotify();
		Producer p = o.new Producer(list);
		Consumer c = o.new Consumer(list);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException ie) {
			
		}
	}
	
	class Producer implements Runnable {
		private final Queue<Integer> list;
		public Producer(Queue<Integer> list) {
			this.list = list;
		}
		
		@Override
		public void run() {
			try {
				for(int i = 0; i<5; i++)
					produce();
			} catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
			}
		}
		
		private void produce() throws InterruptedException {
			synchronized (list) {
				System.out.println("producer running");
				while(CAPACITY == list.size()) {
					System.out.println("queue is full, producer is going to wait.");
					list.wait();
					System.out.println("producer came out of wait");
				}
				Random r = new Random();
				int d = r.nextInt(10);
				list.offer(d);
				System.out.println("producer pushed: " + d);
				list.notifyAll();
				TimeUnit.SECONDS.sleep(4);
			}
		}
		
	}

	class Consumer implements Runnable {
		private final Queue<Integer> list;
		public Consumer(Queue<Integer> list) {
			this.list = list;
		}
		
		@Override
		public void run() {
			try {
				for(int i = 0; i<5; i++)
					consume();
			} catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
			}
		}
		private void consume() throws InterruptedException {
			synchronized (list) {
				System.out.println("consumer running");
				while(list.isEmpty()) {
					System.out.println("queue is empty,consumer is going to wait.");
					list.wait();
					System.out.println("consumer came out of wait.");
				}
				System.out.println(list.poll());
				list.notifyAll();
				TimeUnit.SECONDS.sleep(12);
			}
		}
	}
	
}



