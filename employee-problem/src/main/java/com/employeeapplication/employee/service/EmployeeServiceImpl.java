package com.employeeapplication.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapplication.employee.dao.EmployeeRepository;
import com.employeeapplication.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		Employee employeeObj=new Employee();
		employeeObj.setEmpId(employee.getEmpId());
		employeeObj.setEmpName(employee.getEmpName());
		employeeObj.setGender(employee.getGender());
		employeeObj.setAge(employee.getAge());
		Employee employeeResponse=employeeRepository.save(employeeObj);
		return employeeResponse;
	}

	@Override
	public List<Employee> getEmployees(String gender, Integer minAge, Integer maxAge) {
			
		return employeeRepository.findEmployees(gender, minAge, maxAge);
	}

}
