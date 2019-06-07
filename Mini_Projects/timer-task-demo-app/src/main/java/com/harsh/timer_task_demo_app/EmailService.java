package com.harsh.timer_task_demo_app;

import java.time.Instant;
import java.util.Date;
import java.util.Timer;

/**
 * Demonstrate how to schedule a task to send email at regular intervals.
 * Makes user of {@link java.util.TimerTask} class which implements runnable.
 * It also provides various methods to execute a task once at a specific time or
 * execute the task at regular intervals over the period of time.
 * 
 * @author harshul.varshney
 *
 */
public class EmailService {
	
	public static void main(String[] s) {
		EmailService service = new EmailService();
		service.newWay();
		service.oldWay();
	}
	
	private void newWay() {
		Timer timer = new Timer();
		timer.schedule(MyTimerTask.of("my-email"), Date.from(Instant.now().plusSeconds(5)),5000);
	}
	
	private void oldWay() {
		Object lock = new Object();
		EmailSender emailSender = new EmailSender();
		
		Runnable task = () -> {
			while(true) {
				synchronized(lock) {
					emailSender.sendEmail();
					try {
						lock.wait(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t = new Thread(task);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
