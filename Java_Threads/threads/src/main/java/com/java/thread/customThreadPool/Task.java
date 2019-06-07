package com.java.thread.customThreadPool;

/**
 * 
 * @author harshul.varshney
 *
 */
public class Task implements Runnable {

	private int num;
	
	public Task(int m) {
		this.num = m;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task " + this.num + " is running...");
		if(num == 3)
			throw new RuntimeException("Task-3 throwing run time exception");
	}
	
	public int getNum() {
		return num;
	}

}
