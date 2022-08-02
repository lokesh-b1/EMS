package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
