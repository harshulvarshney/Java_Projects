package com.java.thread.problems;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Problem statement:
 * One thread is going to write/update on a object, to do that it must take lock on that object
 * Another thread is going to read that object, it need not take lock on this object
 * 
 * @author harshul.varshney
 *
 */
public class ReadWriteSync {
	
	private volatile String name = "test";
	
	
	
	private void write() {
		for(int i = 0; i < 5; i++) {
			synchronized (this) {
				System.out.println("Taken lock on this.");
				try {
					//TimeUnit.SECONDS.sleep(3);
					name = "NewName_" + i;
					System.out.println("name is updated, going to sleep, new name: " + name);
					TimeUnit.SECONDS.sleep(5);
					System.out.println("releasing lock on this.");
				} catch(Exception e) {
					
				}
			}
		}
	}
	
	private void read() {
		while(true) {
			System.out.println("Going to read name");
			System.out.println("name is : " + this.name);
			long i = 1;
			while(i<1000000000l)
				i++;
		}
	}
	
	public static void main(String[] args) {
		ReadWriteSync obj = new ReadWriteSync();
		
		Runnable r1 = () -> {obj.write();};
		Thread t1 = new Thread(r1);
		
		Runnable r2 = () -> {obj.read();};
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(Exception e) {
			
		}
		System.out.println("Completed.");
		
		ConcurrentHashMap<String, String> test = new ConcurrentHashMap<>();
//		test.repl
	}

}
