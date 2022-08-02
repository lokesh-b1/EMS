package com.springboot.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.crud.entity.Employee;
import com.springboot.crud.exception.ResourceNotFoundException;
import com.springboot.crud.repository.EmployeeRepository;
import com.springboot.crud.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
				return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//existingEmployee.setPhoneNumber(employee.getPhoneNumber());
		
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist in DB or not
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
				employeeRepository.deleteById(id);
		
	}

}
