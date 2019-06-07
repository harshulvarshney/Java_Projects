package com.java.core;

/**
 * Diamond problem occurs when JVM can not identify which concrete method it has to call.
 * if interface A and B both have same method names, it is okey in class C, because class C's implementation will be called.
 * 
 * for default methods, super is called with the reference of interface.
 *
 */
public class DiamondProb {
	public static void main(String[] args) {
		C c = new C();
		c.print();
		c.same();
//		System.out.println(c.a); -- compile time error.
	}
}

interface A {
	int a = 10;
	default void print()  {
		System.out.println("default A");
	}
	void same();
}

interface B {
	int a = 20;
	default void print()  {
		System.out.println("default B");
	}
	void same();
}

class C implements A, B{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		A.super.print();
		B.super.print();
	}

	@Override
	public void same() {
		System.out.println("same method called");
	}
}
