package com.java.core;

public class ClonableClass implements Cloneable {

	@Override
	public ClonableClass clone() {
		try {
			return (ClonableClass) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
