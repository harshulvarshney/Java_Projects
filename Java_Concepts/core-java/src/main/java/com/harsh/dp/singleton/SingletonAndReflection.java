package com.harsh.dp.singleton;

import java.lang.reflect.Constructor;

/**
 * To overcome issue raised by reflection, enums are used.
 * 
 * As enums don’t have any constructor so it is not possible for Reflection to utilize it. 
 * Enums have their by-default constructor, we can’t invoke them by ourself. 
 * JVM handles the creation and invocation of enum constructors internally. 
 * 
 * or, inside the private constructor of Singleton class, check if instance is not null, throw runtime-exception.
 *
 */
public class SingletonAndReflection {
	
	public static void main(String[] args) {
		SingletonAndReflection o = new SingletonAndReflection();
		o.breakSingleton();
	}
	
	private void breakSingleton() {
		EagerSingleton instance1 = EagerSingleton.getInstance();
		EagerSingleton instance2 = null;
		
		try {
			
			Constructor<EagerSingleton>[] constructors = (Constructor<EagerSingleton>[]) EagerSingleton.class
					.getDeclaredConstructors();			
			
			for(Constructor c : constructors) {
				c.setAccessible(true);
				instance2 = (EagerSingleton) c.newInstance();
				break;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("instance1: " + instance1.hashCode());
		System.out.println("instance2: " + instance2.hashCode());
		
		//above will print different hash-codes i.e. singleton is broken.
	}

}
