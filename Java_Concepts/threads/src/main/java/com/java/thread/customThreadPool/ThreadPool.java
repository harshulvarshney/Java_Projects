package com.java.thread.customThreadPool;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Custom Thread Pool, demonstrates how a thread pool works.
 * Thread Pool is initialized with a pool size. it defines the number of worker threads to be created.
 * A Queue is used to get tasks from creator.
 * 
 * The run() of Worker runs in loop and catches RuntimeException so that a worker will continue to work
 * even if an exception occured.
 * 
 * @author harshul.varshney
 *
 */
public class ThreadPool {
	
	private final int size;
	private Worker[] workers;
	private LinkedBlockingDeque<Runnable> queue;
	
	public ThreadPool(int poolSize) {
		System.out.println("Creating thread pool of size: " + poolSize);
		this.size = poolSize;
		queue = new LinkedBlockingDeque<>();
		workers = new Worker[poolSize];
		
		for(int i = 0; i < size; i++) {
			workers[i] = new Worker(i);
			workers[i].start();
		}
	}
	
	public void submit(Runnable task) {
		synchronized (queue) {//if using a blocking q, no need to take lock on it.
			queue.add(task);
			queue.notify();
		}
	}
	
	
	//worker threads of pool.
	private class Worker extends Thread {
		private int num;
		public Worker(int m) {
			this.num = m;
		}
		public void run() {
			
			Runnable task;
			
			while(true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					task = queue.poll();
					queue.notifyAll();
				}
				
				try {
					System.out.println("Worker " + this.num + " is working on task " + ((Task)task).getNum());
					task.run();
				} catch(RuntimeException re) {
					System.out.println("Thread Pool interrypted due to: " + re.getMessage());
				}
			}
			
		}
	}

}
