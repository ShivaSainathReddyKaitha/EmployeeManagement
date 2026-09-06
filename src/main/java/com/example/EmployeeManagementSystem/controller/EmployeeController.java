package com.example.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private final EmployeeService service;
	
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) { 
		return ResponseEntity.ok(service.addEmployee(employee));
	}
	
	@GetMapping
	public ResponseEntity<Page<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "id") String sortParameter,
			@RequestParam(defaultValue = "asc")  String direction) {
		return ResponseEntity.ok(service.getAllEmployees(pageNumber, pageSize, sortParameter, direction));
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long id) {
		return service.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return "Employee "+id+" has been deleted";
	}
	
	@GetMapping("/department/{department}")
	public List<Employee> getByDepartment(@PathVariable String department) {
		return service.getByDepartment(department);
	}

}
