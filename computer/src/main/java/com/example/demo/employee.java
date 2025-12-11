package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	private String dept;
	private int salary;
	
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public long getPhone() {
	return phone;
	}
	public void setPhone(long phone) {
	this.phone = phone;
	}
	public String getDept() {
	return dept;
	}
	public void setDept(String dept) {
	this.dept = dept;
	}
	public int getSalary() {
	return salary;
	}
	public void setSalary(int salary) {
	this.salary = salary;
	}
}
