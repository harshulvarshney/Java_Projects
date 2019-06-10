package com.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * This is a test case to verify if we can read an instance variable of an object when the lock is already taken.
 * 
 * conclusion: if writer has taken a lock, reader does not have to take lock, 
 * reader will always read the latest updated value.
 *
 */
public class ReadAndWriteConcurrently {
	
	public static void main(String[] args) {
		Employee ee = new Employee();
		ee.setName("Harshul");
		
		ReadAndWriteConcurrently o = new ReadAndWriteConcurrently();
		Runnable r1 = () -> {try {
			o.updateEmployeeName(ee);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}};
		Runnable r2 = () -> {try {
			o.getEmployeeName(ee);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void updateEmployeeName(Employee ee) throws InterruptedException {
		synchronized (ee) {
			System.out.println("taken lock on employee");
			TimeUnit.SECONDS.sleep(5);
			ee.setName("Harshul Varshney");
//			System.out.println("updated employee, new value = " + ee.getName());
			TimeUnit.SECONDS.sleep(5);
			System.out.println("releasing lock from employee");
		}
	}
	
	private void getEmployeeName(Employee ee) throws InterruptedException {
		while(true) {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Read employee name: " + ee.getName());
		}
	}

}

class Employee {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
