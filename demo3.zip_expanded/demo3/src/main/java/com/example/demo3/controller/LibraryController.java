package com.example.demo3.controller;


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

import com.example.demo3.model.Library;
import com.example.demo3.repository.LibraryRepo;

@RestController
@RequestMapping
public class LibraryController {
	
	@Autowired
	LibraryRepo libraryRepo;
	
	@GetMapping(path="getAllData")
	public List<Library> findAllLibrary(){
		return libraryRepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addData")
	public Library addData(@RequestBody Library library) {
		return libraryRepo.save(library);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		libraryRepo.deleteById(id);
		return "Successfully Deleted";
	}
	
	@PutMapping("/updateData/{id}")
	public ResponseEntity<Object> updateData(@RequestBody Library library, @PathVariable int id) {

		Optional<Library> libraryOptional = libraryRepo.findById(id);

		if (!libraryOptional.isPresent())
			return ResponseEntity.notFound().build();

		library.setId(id);
		
		libraryRepo.save(library);

		return ResponseEntity.noContent().build();
	}
	
	
	

}

