package com.java.thread.problems;

public class NoThread extends Thread {
	
	public static void main(String[] args) {
		NoThread obj = new NoThread();
		try {
			obj.run();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finished");
		}
		
	}

}
