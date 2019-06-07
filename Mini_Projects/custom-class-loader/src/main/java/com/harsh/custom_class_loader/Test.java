package com.harsh.custom_class_loader;

public class Test {
	
	public static void main(String[] args) throws Exception {
		ClassLoader cl = new MyClassLoader(Integer.class.getClassLoader());
		
		Class<?> c = cl.loadClass("com.harsh.util.customClassLoader.Sample");
		Object instance = c.newInstance();
		c.getMethod("run", null).invoke(instance, null);
	}
	
	/*
	 * Output:
	 * 	loading class 'com.harsh.util.classLoader.Sample'
		loading class 'java.lang.Object'
		loading class 'java.lang.System'
		loading class 'java.io.PrintStream'
		Sample class loaded
	 */

}
