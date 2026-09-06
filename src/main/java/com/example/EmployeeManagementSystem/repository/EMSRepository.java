package com.example.EmployeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.entity.Employee;

public interface EMSRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartment(String department);
	

}
