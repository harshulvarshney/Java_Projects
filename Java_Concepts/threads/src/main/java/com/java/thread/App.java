package com.java.thread;

import java.util.concurrent.LinkedBlockingDeque;

public class App {
	
	public static void main(String[] args) {
		
	}
	
	
	

}

class ThreadPool {
	int capacity;
	Worker[] workers;
	LinkedBlockingDeque<Runnable> q;
	
	public ThreadPool(int capacity) {
		this.capacity = capacity;
		workers = new Worker[capacity];
		q = new LinkedBlockingDeque<>();
		
		for(int i=0; i < capacity; i++) {
			workers[i] = new Worker(i);
			workers[i].start();
		}
	}
	
	public void submit(Runnable task) {
		synchronized (q) {
			q.add(task);
			q.notifyAll();
		}
	}
	
	private class Worker extends Thread {
		int num;
		Worker(int num) {
			this.num = num;
		}
		
		@Override
		public void run() {
			Runnable task;
			while(true) {
				try {
					synchronized (q) {
						while(q.isEmpty())
							q.wait();
						
						task = q.poll();
					}
					
					System.out.println("Worker " + num + " is running.");
					task.run();
					
				} catch(RuntimeException | InterruptedException e) {
					System.out.println("Exception occured in " + num);
				}
			}
			
		}
		
	}
	
}


