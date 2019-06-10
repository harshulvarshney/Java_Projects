package com.harsh.dp.observer;

/**
 * Demonstrate how to implement Observer design patten by using java.util.Observer interface 
 * and java.util.Observable class.
 * 
 * The class whose change of state we want to observe should extend observable class.
 * This class has implemented methods for updating/notifying the Observers about the changes made to the Observable.
 * public void addObserver(Observer o) Add an Observer.
 * public void deleteObserver(Observer o) Delete an Observer.
 * public void notifyObservers() notify observers of changes.
 * 
 * All the observers should implenent Observer interface and override update() method.
 * 
 * This is a behavioral pattern and provides decoupling in code.
 * 
 * 
 * @author harshul.varshney
 *
 */
public class App {
	
	public static void main(String[] args) {
		Item item = new Item();					//Subject class
		Notifier notifier = new Notifier();		//Observer
		item.addObserver(notifier);				//registering observer
		
		System.out.println("Items in stock? " + item.inStock());
		System.out.println("Adding items.");
		item.addItem();
	}

}
