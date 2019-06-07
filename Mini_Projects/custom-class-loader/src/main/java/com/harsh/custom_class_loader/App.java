package com.harsh.custom_class_loader;


/**
 * @author harshul.varshney
 *
 */
public class App {

	/*
	 * How to determine class loader which loaded your class.
	 */
	public static void main(String[] args) {
		System.out.println("Integer class loader: " + Integer.class.getClassLoader());
		System.out.println("Integer class loader: " + App.class.getClassLoader());
	}
	/*
	 * Output:
	 * 	Integer class loader: null
		Integer class loader: sun.misc.Launcher$AppClassLoader@4e0e2f2a
		Integer class loader: sun.misc.Launcher$AppClassLoader@4e0e2f2a
		
		java.lang.Integer was loaded using the bootstrap class loader. 
		In most implementations getClassLoader() method returns null for the bootstrap class loader.
		
		Our App class is loaded by System class loader.
	 */
}
