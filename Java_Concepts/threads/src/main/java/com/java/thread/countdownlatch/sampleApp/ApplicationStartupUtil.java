package com.java.thread.countdownlatch.sampleApp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Utility class to start Application after checking health of all subsystems.
 * 
 * @author harshul.varshney
 *
 */
public class ApplicationStartupUtil {
	
	static CountDownLatch latch;
	//List of service checkers
    private static List<BaseHealthCheckerTask> services;
    
    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();
    
	public static ApplicationStartupUtil getInstance() {
		return INSTANCE;
	}
	
	public static boolean checkExternalServices() throws Exception {
		latch = new CountDownLatch(2);
		services = new ArrayList<>();
		services.add(new BalancerHealthChecker(latch));
		services.add(new DatabaseHealthChecker(latch));
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		for(final BaseHealthCheckerTask task :services) {
			executor.submit(task);
		}
		
		latch.await();
		//Once count is 0, return the status of services.
		for(BaseHealthCheckerTask task : services) {
			if(!task.isServiceUp())
				return false;
		}
		
		return true;
	}

}
