package com.java.thread.waitNotify;

/**
 * wait and notify are part of Object hierarchy.
 * They are used for inner thread communication.
 * they must be called from inside synchronized block/method otherwise we will get IllegalMonitorStateException.
 * If we don't call them from inside a synchronized block/method, there could be a race condition.
 * they throws interrupted exception
 * @author harshul.varshney
 */
public class HowWaitNotifyWorks {
	
	private boolean test = false;
	
	private void waitTest() throws InterruptedException {
		System.out.println("inside wait test");
		synchronized (this) {
			System.out.println("acquired the lock");
			Thread.sleep(1000);
			if(!test) {
				System.out.println("Going to wait");
				this.wait();//when it came out of wait, processing will resume at next line from here.
				System.out.println("Came out of wait");
			}
			else {
				System.out.println("inside else");
			}
			System.out.println("test complete.");
		}
	}
	
	private void notifyTest() {
		System.out.println("inside notify test");
		synchronized (this) {
			System.out.println("acquired lock by notify test");
			if(!test) {
				System.out.println("going to notify all");
				this.notifyAll();
				test=true;
				System.out.println("notified all");
			}
			System.out.println("notify test complete.");
		}
	}
	
	public static void main(String[] args) {
		HowWaitNotifyWorks obj = new HowWaitNotifyWorks();
		Thread t1 = new Thread(new Runnable() {
 			@Override
			public void run() {
 				try {
					obj.waitTest();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
 			@Override
			public void run() {
 				obj.notifyTest();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(Exception e) {
			
		}
		System.out.println("Done.");
	}

}

