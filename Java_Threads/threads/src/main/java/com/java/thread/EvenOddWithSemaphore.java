package com.java.thread;

import java.util.concurrent.Semaphore;

public class EvenOddWithSemaphore {
	
	private Semaphore semaphore = new Semaphore(1);
	private boolean printOdd = true;
	private int count = 1;
	
	private void printOdd() throws InterruptedException {
		semaphore.acquire();
		if(printOdd && count <= 9) {
			System.out.print(" " + count++);
			printOdd = !printOdd;
		}
		semaphore.release();
	}
	
	private void printEven() throws InterruptedException {
		semaphore.acquire();
		if(!printOdd && count <= 10) {
			System.out.print(" " + count++);
			printOdd = !printOdd;
		}
		semaphore.release();
	}
	
	public static void main(String[] args) {
		EvenOddWithSemaphore o = new EvenOddWithSemaphore();
		Runnable t1 = () -> {
			try {
				while(o.count <= 10)
					o.printEven();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable t2 = () -> {
			try {
				while(o.count <= 10)
					o.printOdd();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch(InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
	}

}
