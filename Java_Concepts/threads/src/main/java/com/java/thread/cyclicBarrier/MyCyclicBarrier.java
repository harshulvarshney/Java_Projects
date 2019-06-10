package com.java.thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {
	
	public static void main(String[] args) {
		test();
	}
	
	static void test() {
		
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task-1 executed");
			}
		};
		
		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Task-2 executed");
			}
		};
		
		CyclicBarrier barrier1 = new CyclicBarrier(2, t1);
		CyclicBarrier barrier2 = new CyclicBarrier(2, t2);
		
		Thread th1 = new Thread(new MyThread(barrier1, barrier2));
		Thread th2 = new Thread(new MyThread(barrier1, barrier2));
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch(Exception e) {
			
		}
	}

}

class MyThread implements Runnable {

	CyclicBarrier barrier1;
	CyclicBarrier barrier2;
	public MyThread(CyclicBarrier barrier1, CyclicBarrier barrier2) {
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name  + " is running");
		try {
			barrier1.await();
			System.out.println(name + " passed barrier1");
			barrier2.await();
			System.out.println(name + " passed barrier2");
			Thread.sleep(2000);
			barrier1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
