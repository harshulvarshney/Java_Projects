package com.java8.thread;

/**
 * join() is called on thread instance.
 * we can pass a thread instance 't' to another thread and call join() on t
 * the second thread will wait for t to complete.
 *
 */
public class DemoJoin {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is running");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " is complete");
			}
		});
		t.setName("t");
		t.start();
		
		Thread myThread = new Thread(new MyThread(t));
		myThread.setName("myThread");
		myThread.start();
		
		try {
			myThread.join();
		} catch(InterruptedException ie) {
			
		}
		
		System.out.println("Finished.");
	}

}

class MyThread implements Runnable {
	
	Thread t;
	public MyThread(Thread t) {
		this.t = t;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " running, calling wait on passed thread.");
		try {
			t.join();
		} catch(InterruptedException ie) {
			
		}
		System.out.println(name + " is complete.");
	}
	
}


