package com.java.core;

public class App {
	
	public static void main(String[] args) {
		ClonableClass o = new ClonableClass();
		ClonableClass c = o.clone();
		
		if(o != c) {
			System.out.println("cloned");
		}
		
	}

}
