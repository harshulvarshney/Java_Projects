package com.java.core;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Memory leak issue is solved in java 7 onwards.
 * Below example shows that a string and it's sub-string have different set of characters.
 * @author harshul.varshney
 *
 */
public class StringSubstring {
	
	public static void main(String[] s) throws Exception {
		String s1 = "I_love_java";
		String s2 = s1.substring(7);
		
		Field f = String.class.getDeclaredField("value");
		f.setAccessible(true);
		char[] c = (char[]) f.get(s1);
		System.out.println(Arrays.toString(c));
		
		char[] c2 = (char[]) f.get(s2);
		System.out.println(Arrays.toString(c2));
	}

}
