package com.harsh.dp.singleton;

/**
 * To overcome this issue, override clone() method and throw an exception from 
 * clone method that is CloneNotSupportedException.
 *
 */
public class SingletonAndClone {
	
	public static void main(String[] args) {
		
	}
	
	private void breakSingleton() {
		
		EagerSingleton inst1 = EagerSingleton.getInstance();
		EagerSingleton inst2 = null;
		//inst2 = inst1.clone(); -- this cant be done unless we override clone method in our 
		//EagerSingleton class.
		
		//so basically, singleton class is already clone safe.
		
	}

}
