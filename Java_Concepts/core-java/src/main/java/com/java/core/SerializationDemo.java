package com.java.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//IMP: every class must have a no-arg constructor, otherwise deserialization will fail
//if you have added an arg-constructor, add a no-arg constructor also

public class SerializationDemo {
	
	public static void main(String[] args) {
		String file = "C:/Users/harshul.varshney/Documents/sample.txt";
		Child obj = new Child("HVD");
//		obj.setName("HVD");
		obj.setAaName("Aanaaam");
		SerializationDemo demo = new SerializationDemo();
		demo.writeObject(obj, file);
		demo.readObject(obj, file);
		
		
	}
	
	private void writeObject(Child obj, String path) {
		
		try (FileOutputStream f = new FileOutputStream(path); ObjectOutputStream os = new ObjectOutputStream(f)) {
			System.out.println("writing object");
			os.writeObject(obj); 
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readObject(Child obj, String path) {
		
		try (FileInputStream f = new FileInputStream(path); ObjectInputStream os = new ObjectInputStream(f)) {
			System.out.println("reading object");
			Child s = (Child) os.readObject();
			System.out.println("original object: " + obj.toString());
			System.out.println("read object: " + s.toString());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {//readObject method throws ClassNotFoundException also.
			e.printStackTrace();
		}
	}


}



class GrandParent {
	private String AaName;
	public GrandParent() {
		System.out.println("GrandParent's no arg constructor called");
	}
	public GrandParent(String name) {
		System.out.println("GrandParent's arg constructor called.");
		this.setAaName(name);
	}
	public String getAaName() {
		return AaName;
	}
	public void setAaName(String aaName) {
		AaName = aaName;
	}
}

class Parent extends GrandParent implements Serializable {
	public Parent() {
		super("Parent");
		System.out.println("Parent's no arg constructor called");
	}
}

class Child extends Parent implements Serializable {
	
	private static final long serialVersionUID = 7146641555806045199L;
	
	private String name;
	private static String temp1 = "temp1";//deserialized object will have this variable populated
	private transient String temp2 = "temp2";//deserialized object will have this variable null
	
//	public Child() {
//		
//		System.out.println("Child's No arg constructor called");
//	}
	
//	public Object readResolve() {
//		System.out.println("read resolver called.");
//		return null;
//	}
	
	public Child(String name) {
		System.out.println("Child's Agr constructor called");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getTemp1() {
		return temp1;
	}
	public static void setTemp1(String temp1) {
		Child.temp1 = temp1;
	}
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	@Override
	public String toString() {
		return "name: "+name+" temp1: "+temp1+" temp2: "+temp2;
	}
	
}
