package com.example.EmployeeManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.exception.EmployeeNotFoundException;
import com.example.EmployeeManagementSystem.repository.EMSRepository;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EMSRepository repository;
	
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Page<Employee> getAllEmployees(int start, int end, String sortParameter, String direction) {
		
		Sort sort = direction.equalsIgnoreCase("desc") ?
					Sort.by(sortParameter).descending() :
					Sort.by(sortParameter).ascending();
		
		Pageable pageable = PageRequest.of(start, end, sort);
		return repository.findAll(pageable);
	}
	
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("No employee found with the id: "+id));
	}
	
	public String deleteEmployee(Long id) {
		Employee employeeFromDB = getEmployeeById(id);
		repository.delete(employeeFromDB);
		return "Employee "+id+" has been deleted";
	}
	
	public Employee updateEmployee(Employee employee, Long id) {
		Employee employeeFromDB = getEmployeeById(id);
		employeeFromDB.setFirstName(employee.getFirstName());
		employeeFromDB.setLastName(employee.getLastName());
		employeeFromDB.setEmail(employee.getEmail());
		employeeFromDB.setDepartment(employee.getDepartment());
		employeeFromDB.setSalary(employee.getSalary());
		employeeFromDB.setDoj(employee.getDoj());
		
		return repository.save(employeeFromDB);
	}
	
	public List<Employee> getByDepartment(String department) {
		return repository.findByDepartment(department);
	}

	
}
