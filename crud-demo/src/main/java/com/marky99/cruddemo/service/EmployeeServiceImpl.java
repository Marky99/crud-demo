package com.marky99.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marky99.cruddemo.dao.EmployeeDAO;
import com.marky99.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		
		this.employeeDAO = employeeDAO;
		
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDAO.findAll();
		
	}

	@Override
	@Transactional
	public Employee findEmployee(int id) {

		return employeeDAO.findEmployee(id);
		
	}

	@Override
	@Transactional
	public void save(Employee employee) {

		employeeDAO.save(employee);
		

	}

	@Override
	@Transactional
	public void deleteById(int id) {

		employeeDAO.deleteById(id);

	}

}
