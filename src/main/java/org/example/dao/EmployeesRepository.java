package org.example.dao;

import org.example.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

	Employees getEmployeeById(long id);
	void deleteEmployeeById(long id);

	@Query("SELECT COUNT(e) FROM Employees e")
	int getEmployeeCount();
}
