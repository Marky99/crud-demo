package com.marky99.cruddemo.dao;

import java.util.List;

import com.marky99.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findEmployee(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
}
