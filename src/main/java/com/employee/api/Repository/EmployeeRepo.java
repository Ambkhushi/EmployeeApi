package com.employee.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.api.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	
	
}
