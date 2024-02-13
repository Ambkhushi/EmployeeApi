package com.employee.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.entity.Employee;
import com.employee.api.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<Employee>addemp(@RequestBody Employee emp){
		Employee e1 = empService.addemp(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(e1);
	}
	
	@GetMapping
    public List<Employee> getAllEmployees() {
        return empService.getAllEmp();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee>getEmployee(@PathVariable Long id){
		Employee emp=empService.getEmp(id);
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable Long id,@RequestBody Employee emp){
		Employee e1=empService.updateEmp(emp);
		return ResponseEntity.ok(e1);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteEmp(@PathVariable  Long id){
		empService.delete(id);
		return new ResponseEntity<String>("Employee Deleted Succesfully!!",HttpStatus.OK);
	}
}
