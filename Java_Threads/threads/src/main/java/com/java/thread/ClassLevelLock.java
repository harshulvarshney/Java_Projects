package com.java.thread;

/**
 *  2 threads are created, one is calling an instance method of Test class after taking lock on test object
 *  another is calling static method of test class after taking class level lock
 *  1- both threads can run concurrently
 *  2- the thread who has taken object level lock can call a non-synchronized method 
 *  2- the thread who has taken object level lock can not call any of the synchronized static member of Test class
 */
public class ClassLevelLock {
	
	public static void main(String[] args) {
		Test test = new Test();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Test.staticMethod();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.instanceMethod();
			}
		});
		
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

}

class Test {
	
	public void instanceMethod() {
		System.out.println(Thread.currentThread().getName() + " running");
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " has taken lock in instanceMethod");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			staticPrivateMethod();
			System.out.println(Thread.currentThread().getName() + " completed");
		}
	}
	
	public static void staticMethod() {
		System.out.println(Thread.currentThread().getName() + " running");
		synchronized (Test.class) {
			System.out.println(Thread.currentThread().getName() + " has taken lock in staticMethod");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Test test = new Test();
			test.instancePrivateMethod();
			System.out.println(Thread.currentThread().getName() + " completed");
		}
	}
	
	private synchronized static void staticPrivateMethod() {
		System.out.println(Thread.currentThread().getName() + " is inside static private method");
	}
	
	private synchronized void instancePrivateMethod() {
		System.out.println(Thread.currentThread().getName() + " is inside non-static private method");
	}
}
