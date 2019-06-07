package com.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class StartAllThreadsAtOnce {
	final CountDownLatch latch = new CountDownLatch(1);
	
	private void startThreads() {
		
		for(int i = 0; i< 5; i++) {
			Thread runner = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("Created: " + Thread.currentThread().getName());
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Started: " + Thread.currentThread().getName());
				}
			});
			runner.start();
		}
		
		System.out.println("Go...");
		latch.countDown();
	}
	
	public static void main(String[] args) {
		StartAllThreadsAtOnce obj = new StartAllThreadsAtOnce();
		obj.startThreads();
	}

}
