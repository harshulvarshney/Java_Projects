package com.java.connectionPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPoolManager {
	
	private BlockingQueue<Connection> availableConnectionQueue;
	private BlockingQueue<Connection> busyConnectionQueue;
	private final int size;
	
	public ConnectionPoolManager(int size) {
		System.out.println("Starting connection pool manager");
		availableConnectionQueue = new ArrayBlockingQueue<>(size);
		busyConnectionQueue = new ArrayBlockingQueue<>(size);
		
		this.size = size;
		for(int i = 0; i < size; i++) {
			Connection con = new Connection("connection-"+i);
			availableConnectionQueue.offer(con);
		}
	}
	
	public boolean isConnectionAvailable() {
		return availableConnectionQueue.size() > 0;
	}
	
	public Connection getConnection() throws InterruptedException {
		Connection conn = null;
		System.out.println("Total connections: " + availableConnectionQueue.size());
		conn = availableConnectionQueue.take();
		busyConnectionQueue.offer(conn);
		return conn;
	}
	
	public void releaseConnection(Connection conn) throws InterruptedException {
		if(!busyConnectionQueue.contains(conn)) {
			throw new RuntimeException("Invalid connection");
		}
		System.out.println(conn.getName() + " released.");
		busyConnectionQueue.remove(conn);
		availableConnectionQueue.put(conn);
	}
	
	public void shutDown() {
		for(Connection conn : availableConnectionQueue)
			conn = null;
		for(Connection conn : busyConnectionQueue)
			conn = null;
	}

}
