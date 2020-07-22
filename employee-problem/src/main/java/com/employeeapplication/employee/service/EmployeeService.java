package com.employeeapplication.employee.service;

import java.util.List;

import com.employeeapplication.employee.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> getEmployees(String gender, Integer minAge, Integer maxAge);
}
