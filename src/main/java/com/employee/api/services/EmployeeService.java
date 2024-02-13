package com.employee.api.services;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.api.EmpComparator;
import com.employee.api.Repository.EmployeeRepo;
import com.employee.api.entity.Employee;
import com.employee.api.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee addemp(Employee emp) {
		return employeeRepo.save(emp);
	}

	public List<Employee> getAllEmp() {
		 List<Employee> empList = employeeRepo.findAll();
	        Collections.sort(empList, new EmpComparator());
	        return empList;
	}

	public Employee getEmp(Long id) {
		return employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	}

	public Employee updateEmp(Employee emp) {
		return employeeRepo.save(emp);
	}

	public void delete(Long id) {
		employeeRepo.deleteById(id);
	}

}
