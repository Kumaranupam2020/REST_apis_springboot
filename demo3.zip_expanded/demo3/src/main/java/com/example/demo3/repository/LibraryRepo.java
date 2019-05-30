package com.example.demo3.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.model.Library;

public interface LibraryRepo extends JpaRepository<Library, Integer> {

}
