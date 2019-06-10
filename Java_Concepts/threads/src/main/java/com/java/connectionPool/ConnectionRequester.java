package com.java.connectionPool;

import java.util.concurrent.TimeUnit;

public class ConnectionRequester implements Runnable {
	private ConnectionPoolManager mgr;

	public ConnectionRequester(ConnectionPoolManager mgr) {
		this.mgr = mgr;
	}

	@Override
	public void run() {
		String thread = Thread.currentThread().getName();
		System.out.println(thread + " is running");
		Connection conn = null;
		if (mgr.isConnectionAvailable()) {
			System.out.println(thread + " : connection is available");
			try {
				conn = mgr.getConnection();
				System.out.println(thread + " has taken connection: " + conn.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(thread + " : connection is not available at: " + System.currentTimeMillis());
			try {
				
				conn = mgr.getConnection();
				System.out.println(thread + " : got connection: "+ conn.getName() +", at: " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
			mgr.releaseConnection(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
