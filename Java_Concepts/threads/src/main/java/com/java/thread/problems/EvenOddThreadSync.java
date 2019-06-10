package com.java.thread.problems;

/**
 * There are 2 threads, 1 prints only even numbers and 2nd prints only odd numbers.
 * write the code so that these thread always print the numbers in sequence.
 * assume they print numbers upto 10.
 * 
 * @author harshul.varshney
 */
public class EvenOddThreadSync {
	private static final Integer MAX = 10;
	private int count = 1;
	
	public static void main(String[] args) {
		EvenOddThreadSync obj = new EvenOddThreadSync();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.printEven();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				obj.printOdd();
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished");
	}
	
	public synchronized void printEven() {
//		System.out.println("inside print even.");
		while(count <= MAX) {
			if(count%2 == 0) {
				System.out.println("Even: " + count);
				count++;
				notifyAll();
			}
			try {
//				System.out.println("even going to wait.");
				wait();
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	public synchronized void printOdd() {
//		System.out.println("inside print odd.");
		while(count <= MAX) {
			if(count%2 != 0) {
				System.out.println("Odd: " + count);
				count++;
				notifyAll();
			}
			try {
//				System.out.println("odd going to wait.");
				wait();
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}
