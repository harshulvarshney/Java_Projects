package com.java.thread.lock;

public class MyThread implements Runnable {
	
	private FairLock lock = null;
	public MyThread(FairLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			while(true) {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + " has taken lock");
				Thread.sleep(7000);
				System.out.println(Thread.currentThread().getName() + " is releasing lock");
				lock.unlock();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
