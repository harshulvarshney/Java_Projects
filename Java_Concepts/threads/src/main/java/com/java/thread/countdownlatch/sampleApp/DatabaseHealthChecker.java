package com.java.thread.countdownlatch.sampleApp;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthCheckerTask {

	public DatabaseHealthChecker(CountDownLatch latch) {
		super("Database_Health_Checker", latch);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			System.out.println("Wait in DB healthchecker");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + " is UP");
	}

}
