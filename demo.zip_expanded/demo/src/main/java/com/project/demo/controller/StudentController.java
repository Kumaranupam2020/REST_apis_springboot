package com.project.demo.controller;

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

import com.project.demo.model.Student;
import com.project.demo.repository.StudentRepo;

@RestController
@RequestMapping
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping(path="getAllStudent")
	public List<Student> findAllStudent(){
		return studentRepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable int id) {

		Optional<Student> studentOptional = studentRepo.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		studentRepo.save(student);

		return ResponseEntity.noContent().build();
	}
	
	
	

}
