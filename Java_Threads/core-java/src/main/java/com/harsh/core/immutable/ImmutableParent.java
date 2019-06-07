package com.harsh.core.immutable;

public class ImmutableParent {
	
	private int data;
	
	public int getData() {
		return data;
	}
	
	public ImmutableParent(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "This is immutable: " + data;
	}

}
