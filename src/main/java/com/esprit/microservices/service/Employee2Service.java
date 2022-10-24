package com.esprit.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservices.entity.Employee2;
import com.esprit.microservices.repository.Employee2Repository;

@Service
public class Employee2Service {

	@Autowired
	Employee2Repository employeeRepository;
	
	public void saveEmployee(Employee2 employee) {
		employeeRepository.save(employee);
	}
	
	public Iterable<Employee2> getEmployeeHistory() {
		return employeeRepository.findAll();
	}
	
	public Optional<Employee2> getEmployee(Long id) {
		return employeeRepository.findById(id);
	}
	
	public Employee2 updateEmployee(Long id, Employee2 newEmployee) {
		if(employeeRepository.findById(id).isPresent()) {
			Employee2 existingEmployee = employeeRepository.findById(id).get();
			existingEmployee.setName(newEmployee.getName());
			existingEmployee.setEmail(newEmployee.getEmail());
			existingEmployee.setJobTitle(newEmployee.getJobTitle());
			existingEmployee.setPhone(newEmployee.getPhone());
			existingEmployee.setSalary(newEmployee.getSalary());
			existingEmployee.setImageUrl(newEmployee.getImageUrl());
			
			return employeeRepository.save(existingEmployee);
		}
		else {
			return null;
		}
	}
	
	
	public String deleteEmployee(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "Le Employee avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le Employee avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	public  List<Employee2> GetEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee2 findEmployee(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			Employee2 existingEmployee = employeeRepository.findById(id).get();
			return existingEmployee;
		}
		else {
			return null;
		}
	}
}
