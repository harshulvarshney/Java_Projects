package com.java.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author harshul.varshney
 *
 */
@Getter
@Setter
public class Employee {
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String designation;
	
	private Long empId;
	
	private Short age;
	
	public static class EmployeeFilters {
		
		public static Predicate<Employee> filterByFirstName(String firstName) {
			return p -> ((StringUtils.isNotEmpty(p.getFirstName()) && StringUtils.isNotEmpty(firstName))
							? p.getFirstName().equalsIgnoreCase(firstName)
							: true);
		}

		public static Predicate<Employee> filterByLastName(String lastName) {
			return p -> ((StringUtils.isNotEmpty(p.getLastName()) && StringUtils.isNotEmpty(lastName))
							? p.getLastName().equalsIgnoreCase(lastName)
							: true);
		}

		public static Predicate<Employee> filterByDesignation(String designation) {
			return p -> ((StringUtils.isNotEmpty(p.getDesignation()) && StringUtils.isNotEmpty(designation))
							? p.getDesignation().equalsIgnoreCase(designation)
							: true);
		}

		public static Predicate<Employee> filterByAge(Integer age) {
			return p -> ((p.getAge() != null && age != null) 
							? (p.getAge().equals(age)) 
							: true);
		}
		
		public static List<Employee> filterEmployees(List<Employee> indices, EmpFilterCriteria fc) {
			return indices.parallelStream()
					.filter(filterByFirstName(fc.getFirstname()))
					.filter(filterByAge(fc.getAge()))
					.filter(filterByLastName(fc.getLastName()))
					.collect(Collectors.toList());
		}
	}

}
