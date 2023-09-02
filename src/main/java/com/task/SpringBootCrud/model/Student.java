package com.task.SpringBootCrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	
	@Column(name ="name")
	String name;
	
	@Column(name ="subject")
	String subject;
	
	@Column(name ="marks")
	String marks;
	
	@Column(name ="contact")
	String contact;

	public Long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = (long) id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Student(int id, String name, String subject, String marks, String contact) {
		super();
		this.id = (long) id;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
		this.contact = contact;
	}
	
	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject + ", marks=" + marks + ", contact="
				+ contact + "]";
	}
	
	

}
