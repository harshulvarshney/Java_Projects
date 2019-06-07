package com.java.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	
	public static void main(String[] args) {
		
		FairLock lock = new FairLock();
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10; i++) {
			Thread t = new Thread(new MyThread(lock));
			t.setName("Thread-"+i);
			es.submit(t);
		}
		
		try {
			es.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
