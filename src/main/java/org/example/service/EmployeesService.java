package org.example.service;


import org.example.dao.EmployeesRepository;
import org.example.model.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

	@Autowired
	private EmployeesRepository employeesRepository;


	public List<Employees> getAllEmployees() {
		return employeesRepository.findAll();
	}


}
