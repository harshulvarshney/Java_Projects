package com.harsh.core.immutable;

public class Mutable extends ImmutableParent {

	public Mutable(int data) {
		super(data);
	}
	
	public int getData() {
		return super.getData()+100;//Behavior changed
	}
	@Override
	public String toString() {
		return "This is mutable: " + getData();
	}
}
