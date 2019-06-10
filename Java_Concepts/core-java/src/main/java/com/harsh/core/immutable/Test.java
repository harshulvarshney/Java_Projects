package com.harsh.core.immutable;

public class Test {
	
	public static void main(String[] args) {
		ImmutableParent imm1 = new ImmutableParent(100);
		Mutable imm2 = new Mutable(100);
		
		test(imm1);
		test(imm2);
	}
	
	/**
	 * Accepts immutable object
	 * @param immutable
	 */
	static void test(ImmutableParent immutable) {
		System.out.println(immutable.toString());
	}

}
