package com.example.demo2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.Employee;
import com.example.demo2.repository.EmployeeRepo;

@RestController
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@GetMapping(path="getAllEmployee")
	public List<Employee> findAllEmployee(){
		return employeeRepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {

		Optional<Employee> employeeOptional = employeeRepo.findById(id);

		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();

		employee.setId(id);
		
		employeeRepo.save(employee);

		return ResponseEntity.noContent().build();
	}
	
	
	

}
