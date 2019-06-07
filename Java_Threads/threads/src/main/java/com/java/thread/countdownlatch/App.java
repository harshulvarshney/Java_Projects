package com.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * java.util.concurrent.CountDownLatch is a concurrency construct that allows one or more threads
 *  to wait for a given set of operations to complete.
 *  
 * @author harshul.varshney
 *
 */
public class App {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 3; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed");
		
		executor.shutdown();//if u dont do this, application will continue to run.
		System.out.println("Is terminated? " + executor.isTerminated());
		System.out.println("Is shutdown?" + executor.isShutdown());
	}
}

class Processor implements Runnable {

	CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
	
}