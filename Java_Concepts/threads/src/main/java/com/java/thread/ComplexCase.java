package com.java.thread;


/**
 * 2 threads are trying to call 2 different synchronized methods on same object instance
 *
 */
public class ComplexCase {
	
	public static void main(String[] args) {
		MyClass object = new MyClass();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				object.method1();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				object.method2();
			}
		});
		
		t1.setName("t1");

		t1.start();
		t2.setName("t2");
		t2.start();
	}

}

class MyClass {
	
	public void method1() {
		System.out.println(Thread.currentThread().getName() + " in method1");
		synchronized(this) {
			System.out.println(Thread.currentThread().getName() + " has taken lock");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " completed");
	}
	
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + " in method2");
		synchronized(this) {
			System.out.println(Thread.currentThread().getName() + " has taken lock");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " completed");
	}
}
