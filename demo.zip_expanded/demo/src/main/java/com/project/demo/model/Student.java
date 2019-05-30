package com.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String branch;
	private String year;
	
	public Student() {
		
	}
	
	public Student(int id, String name, String branch, String year) {
		this.id=id;
		this.name=name;
		this.branch=branch;
		this.year=year;
	}

	public int getId() {
		return this.id;
	}
	
	public String getname() {
		return this.name;
	}
	
	public String getbranch() {
		return this.branch;
	}
	
	public String getyear() {
		return this.year;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setbranch(String branch) {
		this.branch=branch;
	}
	
	public void setyear(String year) {
		this.year=year;
	}
}

