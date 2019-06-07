package com.java.thread.problems;

import java.util.concurrent.Semaphore;

//this prog needs to be corrected.
public class EvenOddThreadWithSemaphore {
	
	private static Semaphore semaphore = new Semaphore(0);
	
	private int count = 1;
	private static final Integer MAX = 10;
	
	private void printEven() throws InterruptedException {
		while(count <= MAX) {
			semaphore.acquire();
			if(count % 2 == 0) {
				System.out.print(" " + count);
				++count;
			}
		}
	}
	
	private void printOdd() throws InterruptedException {
		while(count < MAX) {
			if(count % 2 != 0) {
				System.out.print(" " + count);
				++count;
			}
			semaphore.release();
		}
	}
	
	public static void main(String[] args) {
		EvenOddThreadWithSemaphore obj = new EvenOddThreadWithSemaphore();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.printEven();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.printOdd();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
