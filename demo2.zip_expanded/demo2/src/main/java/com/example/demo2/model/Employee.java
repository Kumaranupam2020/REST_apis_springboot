package com.example.demo2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, int salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;		
	}

	public int getId() {
		return this.id;
	}
	
	public String getname() {
		return this.name;
	}
	
	public int getsalary() {
		return this.salary;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setSalary(int salary) {
		this.salary=salary;
	}
	

}
