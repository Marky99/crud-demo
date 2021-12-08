package com.marky99.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marky99.cruddemo.entity.Employee;
import com.marky99.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findEmployee(@PathVariable int id) {
		Employee employee = employeeService.findEmployee(id);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("employees/{id}")
	public Employee deleteById(@PathVariable int id, @RequestBody Employee employee) {
		
		employee = employeeService.findEmployee(id);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		
		employeeService.deleteById(id);
		
		return employee;
		
	}
	
	@PutMapping("employees")
	public Employee updateById(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
		
	}
}
