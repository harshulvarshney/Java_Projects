package com.java.predicate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author harshul.varshney
 *
 */
@Getter
@Setter
@Builder
public class EmpFilterCriteria {
	
	private String firstname;
	private String lastName;
	private Integer age;

}
