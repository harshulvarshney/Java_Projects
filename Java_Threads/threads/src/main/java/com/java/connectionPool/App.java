package com.java.connectionPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author harshul.varshney
 * requirements:
 * 1- pool shud let the caller know if a connection is available or not
 * 2- pool shud expose an API to get a connection
 * 3- pool shud expose an API to release a connection
 * 4- pool shud expose an API to shutdown the pool
 * 5- 
 */
public class App {
	
	ConnectionPoolManager mgr = new ConnectionPoolManager(2);
	
	public static void main(String[] args) {
		App o = new App();
		o.test();
	}
	
	private void test() {
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		
		for (int i = 0; i < 4; i++) {
			ConnectionRequester req = new ConnectionRequester(mgr);
			es.submit(req);
		}
		
		try {
			es.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
