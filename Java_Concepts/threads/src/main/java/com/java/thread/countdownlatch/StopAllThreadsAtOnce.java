package com.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class StopAllThreadsAtOnce {
	
	final CountDownLatch latch = new CountDownLatch(5);

	private void finishSimultaneously() {
		for (int i = 0; i < 5; ++i) {
			Thread t = new Thread() {
				public void run() {
					System.out.println("Created: " + Thread.currentThread().getName());
					latch.countDown();
					System.out.printf("Waiting on %d other threads.", latch.getCount());
					System.out.println();
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					finish();
				}
			};
			t.start();
		}
	}
	
	private void finish() {
		System.out.println("Finished.");
	}
	
	public static void main(String[] args) {
		StopAllThreadsAtOnce obj = new StopAllThreadsAtOnce();
		obj.finishSimultaneously();
	}

}
