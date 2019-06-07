package com.java.core;

public class AnInterestingCase2 {
	
	AnInterestingCase2() {
		this.tables=20;
	}
	
	private int tables = 10;
	private int chairs = getChairs();
	
	private int getChairs() {
		return 4*tables;
	}
	
	public static void main(String[] args) {
		AnInterestingCase2 o = new AnInterestingCase2();
		System.out.println("chairs: " + o.chairs);//prints 40
		System.out.println("tables: " + o.tables);//prints 20
	}
	
	//it prints chairs: 40 because, when chairs field is initialized, tables was initialized with 10 and constructor
	//was not yet called.
	
	//constructor is called after all instance fields are initialized with either their default
	//or assigned value.

}
