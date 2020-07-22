package com.employeeapplication.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapplication.employee.common.ValidateInputs;
import com.employeeapplication.employee.entity.Employee;
import com.employeeapplication.employee.exception.InvalidInputException;
import com.employeeapplication.employee.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@PostMapping(value = "/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		ValidateInputs.validateInputDetails(employee);
		Employee emp = employeeServiceImpl.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam String gender, @RequestParam Integer minage,
			@RequestParam Integer maxage) {

		ValidateInputs.validateGetEmployeeDetails(gender, minage, maxage);
		List<Employee> employees = employeeServiceImpl.getEmployees(gender, minage, maxage);
		if (employees != null) {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		} else {
			throw new InvalidInputException("No Data Found for provided Details");
		}

	}
}
