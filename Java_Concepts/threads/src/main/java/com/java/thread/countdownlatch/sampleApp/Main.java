package com.java.thread.countdownlatch.sampleApp;

public class Main {
	
	public static void main(String[] ss) {
		ApplicationStartupUtil appUtil = ApplicationStartupUtil.getInstance();
		boolean res = false;
		try {
			res = ApplicationStartupUtil.checkExternalServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Application check complete: Are all service up? " + res);
	}

}
