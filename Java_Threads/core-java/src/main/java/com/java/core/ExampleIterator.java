package com.java.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ExampleIterator {

	public static void main(String args[]) {
		ExampleIterator object = new ExampleIterator();
		CountDownLatch latch = new CountDownLatch(1);

		List<String> collection = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			collection.add("" + i);
		}
		//below example shows if 2 iterators work on same collection and an element is removed by 1 iterator
		//the other iterator will throw ConcurrentModificationException when it finds out that undelying 
		//collection has changed.
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Thread one started");
					latch.await();
					Iterator<String> itr = collection.iterator();
					System.out.println("Thread 1 running: itr="+itr);
					while (itr.hasNext()) {
						String next = itr.next();
						System.out.println("thread 1: element: " + next);
						itr.remove();
					}
				} catch (InterruptedException ie) {

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Thread two started");
					latch.await();
					Iterator<String> itr = collection.iterator();
					System.out.println("Thread 2 running: itr="+itr);
					while (itr.hasNext()) {
						String next = itr.next();
						System.out.println("thread 2: element: " + next);
						itr.remove();
					}
				} catch (InterruptedException ie) {

				}
			}
		});

		t1.start();
		t2.start();

		try {
			latch.countDown();
//			t1.join();
//			t2.join();
		} catch (Exception ie) {

		}

	}


	private static void iteratorExample() {
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");// existing object is updated but no change
									// in collection
				// myMap.put("4", "4");//a new object is added to collection -
				// ConcurrentModificationException
			}
		}
	}

}
