package com.employee.api;

import java.util.Comparator;

import com.employee.api.entity.Employee;

public class EmpComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		  return emp1.getName().compareTo(emp2.getName());
	}

}
