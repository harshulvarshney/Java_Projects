package com.harsh.timer_task_demo_app;

import java.util.Date;
import java.util.TimerTask;

/**
 * Demo class to schedule tasks.
 * @author harshul.varshney
 *
 */
public class MyTimerTask extends TimerTask {

	private String name;
	private MyTimerTask(String taskName) {
		this.name = taskName;
	}
	
	public static MyTimerTask of(String name) {
		return new MyTimerTask(name);
	}

	@Override
	public void run() {
		//Send e-mail every day at 12.00 AM
		System.out.println("Email sent by " + this.name + " thread at " + new Date());
		
	}

}
