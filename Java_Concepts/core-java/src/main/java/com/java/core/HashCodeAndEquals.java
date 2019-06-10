package com.java.core;

import java.util.Date;
import java.util.Objects;

/**
 * Demonstrates how to override hash code and equals in a clean in better way
 * using Java's Objects utility class.
 * 
 * @author harshul
 *
 */
public class HashCodeAndEquals {
	
	private String name;
	private int age;
	private Date dob;
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age, dob);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(!(o instanceof HashCodeAndEquals))
			return false;
		if(o == this)
			return true;
		HashCodeAndEquals obj = (HashCodeAndEquals)o;
		return Objects.equals(name, obj.name) &&
				Objects.equals(age, obj.age) &&
				Objects.equals(dob, obj.dob);
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	

}
