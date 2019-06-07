package com.java.core;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Demonstrates how to override hash code and equals in a clean in better way
 * using Java's Apache's utility class.
 * 
 * @author harshul
 *
 */
public class HashCodeAndEqualsWithApache {
	
	private String name;
	private int age;
	private Date dob;
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(name)
				.append(age)
				.append(dob)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof HashCodeAndEqualsWithApache))
			return false;
		HashCodeAndEqualsWithApache obj = (HashCodeAndEqualsWithApache)o;
		return new EqualsBuilder()
				.append(name, obj.name)
				.append(age, obj.age)
				.append(dob, obj.dob)
				.isEquals();
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
