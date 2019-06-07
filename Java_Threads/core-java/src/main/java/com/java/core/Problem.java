package com.java.core;

import java.io.IOException;

public class Problem {
	
	public static void main(String[] args) {
		System.out.println(args.length);
		Problem p = new Problem();
		System.out.println(p.test());
	}
	
	int test() {
		try {
			System.out.println("try");
			return 0;
		} catch(Exception e) {
			System.out.println("exception");
			return 1;
		} finally {
			System.out.println("finally");
			return 2;
		}
	}

}
