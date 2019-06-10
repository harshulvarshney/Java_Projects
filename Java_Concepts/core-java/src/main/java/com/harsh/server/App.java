package com.harsh.server;

public class App {
	
	public static void main(String[] args) {
		MyServer server = new MyServer(9010);
		Thread t = new Thread(server);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
