package com.employee.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.api.entity.Employee;
import com.employee.api.services.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController empcontoller;

	@Mock
	EmployeeService empService;

	@Test
	public void getAllEmp() {
		Employee emp1 = new Employee(007L, "khushi Amb", "IT", 60000.0);
		Employee emp2 = new Employee(010L, "PrincySingh", "IT", 60000.0);
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		when(empService.getAllEmp()).thenReturn(employees);
		assertNotNull(empcontoller.getAllEmployees());
	}

	@Test
	public void getEmpById() {
		Employee emp = new Employee(007L, "khushi Amb", "IT", 60000.0);
		when(empService.getEmp(007L)).thenReturn(emp);
		assertNotNull(empcontoller.getEmployee(007L));
	}

	@Test
	public void addEmp() {
		Employee emp = new Employee(007L, "khushi Amb", "IT", 60000.0);
		when(empService.addemp(emp)).thenReturn(emp);
		Employee responseEmp = (Employee) empcontoller.addemp(emp).getBody();
		assertEquals(emp, responseEmp);
	}

	@Test
	public void updateEmp() {
		Employee emp = new Employee(007L, "khushi Amb", "IT", 60000.0);
		when(empService.updateEmp(emp)).thenReturn(emp);
		Employee responseEmp = (Employee) empcontoller.updateEmployee(007L, emp).getBody();
		assertEquals(emp, responseEmp);
	}

	@Test
	public void delete() {
		empcontoller.deleteEmp(007L);
		verify(empService).delete(007L);
	}
}
