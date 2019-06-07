package com.harsh.web_socket;

import java.text.DecimalFormat;
import java.util.Queue;

/**
 * Rate generator thread.
 * generates random rates and adds them to queue.
 * 
 * @author harshul.varshney
 */
public class RateGenerator implements Runnable {
	
	private Queue<Double> queue;

	public Queue<Double> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Double> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		DecimalFormat df = new DecimalFormat("#.##");
		while (true) {
			double d = 2 + Math.random();
			d = Double.parseDouble(df.format(d));
			
			queue.add(d);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
