package com.java.core;

public class AnInterestingCase {
	
	private int chairs = getChairs();
//	private int tempChairs = 4*tables;-- compile time error
	private int tables = 10;
	
	private int getChairs() {
		return 4*tables;
	}
	
	public static void main(String[] args) {
		AnInterestingCase o = new AnInterestingCase();
		System.out.println("chairs: " + o.chairs);//prints 0
		System.out.println("tables: " + o.tables);//prints 10
	}
	
	//by the time getChairs method is called, tables field is not set to 10 but created with it's default value.

}
