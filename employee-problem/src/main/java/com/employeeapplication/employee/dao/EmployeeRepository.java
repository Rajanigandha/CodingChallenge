package com.employeeapplication.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapplication.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("from Employee as a where a.gender=:gender and a.age>=:minAge and a.age<=:maxAge")
	public List<Employee> findEmployees(String gender, int minAge, int maxAge);
}
