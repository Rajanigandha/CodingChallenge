package com.employeeapplication.employee.common;

import com.employeeapplication.employee.entity.Employee;
import com.employeeapplication.employee.exception.InvalidInputException;

public class ValidateInputs {

	public static void validateInputDetails(Employee employee) {
	
		if(employee.getEmpId()==null || employee.getEmpId().length()==0) {
			throw new InvalidInputException("Please provide EmpId");
		}
		if(employee.getEmpName()==null|| employee.getEmpName().length()==0) {
			throw new InvalidInputException("Please provide EmpName");
		}
		if(employee.getGender()==null|| employee.getGender().length()==0) {
			throw new InvalidInputException("Please provide Gender");
		}
		if(employee.getAge()==null) {
			throw new InvalidInputException("Please provide Age");
		}else if(employee.getAge()<18) {
			throw new InvalidInputException("Please provide Age");
		}
	}
	
	public static void validateGetEmployeeDetails( String gender, Integer minAge, Integer maxAge) {
		if(gender==null || gender.length()==0) {
			throw new InvalidInputException("Please provide Gender");
		}
		if(minAge==null) {
			throw new InvalidInputException("Please provide minAge");

		}
		if(maxAge==null) {
			throw new InvalidInputException("Please provide maxAge");

		}
	}
}
