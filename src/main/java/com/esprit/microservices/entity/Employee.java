package com.esprit.microservices.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{
	private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue
	private Long id;
	private String name, email, jobTitle, phone, imageUrl;
	private float salary;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Employee(String name, String email, String jobTitle, String phone, String imageUrl, float salary) {
		super();
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.salary = salary;
	}
	public Employee(Long id, String name, String email, String jobTitle, String phone, String imageUrl, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", jobTitle=" + jobTitle + ", phone="
				+ phone + ", imageUrl=" + imageUrl + ", salary=" + salary + "]";
	}
	
	
}
