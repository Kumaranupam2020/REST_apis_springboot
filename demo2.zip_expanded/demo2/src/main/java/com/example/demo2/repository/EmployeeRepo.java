package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
