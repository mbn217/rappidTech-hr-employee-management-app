package org.example.service;


import org.example.dao.EmployeesRepository;
import org.example.model.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

	@Autowired
	EmployeesRepository employeesRepository;


	public List<Employees> getAllEmployees() {
		return employeesRepository.findAll();
	}

	public Employees getEmployeeById(long id) {
		return employeesRepository.getEmployeeById(id);
	}

	public void deleteEmployeeById(long id) {
		employeesRepository.deleteEmployeeById(id);
	}

	public void saveEmployee(Employees employee) {
		employeesRepository.save(employee);
	}

	public int getEmployeeCount() {
		return employeesRepository.getEmployeeCount();

	}


}
