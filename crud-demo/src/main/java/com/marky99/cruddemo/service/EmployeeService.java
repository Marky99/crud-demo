package com.marky99.cruddemo.service;

import java.util.List;

import com.marky99.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findEmployee(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
