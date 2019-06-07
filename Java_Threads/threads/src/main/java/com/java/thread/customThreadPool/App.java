package com.java.thread.customThreadPool;

public class App {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(2);
		for(int i = 1; i <= 10; i++) {
			try {
				pool.submit(new Task(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == 10)
				System.out.println("10 task submitted.");
		}

	}

}
