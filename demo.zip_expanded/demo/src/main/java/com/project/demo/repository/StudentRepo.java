package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demo.model.Student;
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
