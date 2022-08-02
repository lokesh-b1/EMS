package com.springboot.crud.controller;

import java.util.List;

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

import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {
private EmployeeService employeeService;

public EmployeeController(EmployeeService employeeService) {
	super();
	this.employeeService = employeeService;
}

// create/save employee details - Rest API
@PostMapping()
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	return new ResponseEntity<Employee> (employeeService.saveEmployee(employee), HttpStatus.CREATED);
}

// get all employees - REST API
@GetMapping()
public List<Employee> getAllEmployees(){
	return employeeService.getAllEmployees();
}
//build get employee by ID - REST API
@GetMapping("{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
	return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
}

// update employee - REST API
@PutMapping("{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id, @RequestBody Employee employee){
	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
}

// delete employee - REST API
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
	// delete employee from DB
	employeeService.deleteEmployee(id);
	return new ResponseEntity<String>("Employee Deleted Sucessfully!..", HttpStatus.OK);
}

}
