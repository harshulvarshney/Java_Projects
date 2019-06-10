package com.java.predicate;

import java.util.List;

public class EmpFilterDemo {
	
	public static void main(String[] args) {
		
		//prepare filter criteria
		EmpFilterCriteria fc = EmpFilterCriteria.builder().firstname("Anil").age(41).build();
		
		List<Employee> empList = null;//assuming this list will be provided
		
		List<Employee> filteredResult = Employee.EmployeeFilters.filterEmployees(empList, fc);
		
	}

}
