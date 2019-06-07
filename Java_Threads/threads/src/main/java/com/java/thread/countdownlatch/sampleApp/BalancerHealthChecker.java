package com.java.thread.countdownlatch.sampleApp;

import java.util.concurrent.CountDownLatch;

public class BalancerHealthChecker extends BaseHealthCheckerTask {

	public BalancerHealthChecker(CountDownLatch latch) {
		super("Balancer_Health_Checker", latch);

	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getServiceName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName() + " is UP");
	}

}
