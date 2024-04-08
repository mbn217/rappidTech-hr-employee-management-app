package org.example.dao;

import org.example.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

//	void saveEmployee(Employees employee);
	Employees getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
