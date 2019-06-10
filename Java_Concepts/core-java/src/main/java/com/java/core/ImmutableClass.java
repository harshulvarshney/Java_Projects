package com.java.core;

import java.util.Date;

/**
 * Sample immutable class.
 * 	-class is declared final so that it can not be sub-classed
 * 	-all instance variables are final and private
 * 	-No setters
 * 	-copied objects are returned for mutable objects
 * 	-making constructor private is not a mandatory requirement, although it can be done.
 * 
 * 	-http://howtodoinjava.com/core-java/related-concepts/how-to-make-a-java-class-immutable/
 * 
 * @author harshul.varshney
 *
 */
public final class ImmutableClass {

	private final String immField1;
	private final Integer immField2;
	private final Date mmField3;
	
	public ImmutableClass (String field1, Integer field2, Date field3) {
		this.immField1 = field1;
		this.immField2 = field2;
		this.mmField3 = field3;
	}

	public String getImmField1() {
		return immField1;
	}

	public Integer getImmField2() {
		return immField2;
	}

	public Date getMmField3() {
		return new Date(mmField3.getTime());
	}

}
