package com.tyss.tyspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tyspringboot.dto.Employee;
import com.tyss.tyspringboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public boolean addEmployee(Employee employee) {
		repository.save(employee);
		return true;
	}

	@Override
	public boolean removeEmployee(int id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public boolean modifyEmployee(Employee employee) {
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		return repository.findById(id).get();
		//return repository.getOne(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

}
