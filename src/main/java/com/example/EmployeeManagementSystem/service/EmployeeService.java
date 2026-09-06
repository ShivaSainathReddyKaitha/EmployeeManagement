package com.example.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.entity.Employee;

@Service
public interface EmployeeService {

	Employee addEmployee(Employee employee);
	
	Page<Employee> getAllEmployees(int start, int end, String sortParameter, String direction);
	
	Employee getEmployeeById(Long id);
	
	String deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee, Long id);
	
	List<Employee> getByDepartment(String department);
	

}
