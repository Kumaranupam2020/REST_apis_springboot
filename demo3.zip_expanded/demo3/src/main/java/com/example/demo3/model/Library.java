package com.example.demo3.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String book;
	
	public Library() {
		
	}
	
	public Library(int id, String name, String book) {
		this.id=id;
		this.name=name;
		this.book=book;		
	}

	public int getId() {
		return this.id;
	}
	
	public String getname() {
		return this.name;
	}
	
	public String getbook() {
		return this.book;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setBook(String book) {
		this.book=book;
	}
	

}

