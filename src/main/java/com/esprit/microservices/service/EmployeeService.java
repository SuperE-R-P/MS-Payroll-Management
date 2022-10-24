package com.esprit.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservices.entity.Employee;
import com.esprit.microservices.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Iterable<Employee> getEmployeeHistory() {
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployee(Long id) {
		return employeeRepository.findById(id);
	}
	
	public Employee updateEmployee(Long id, Employee newEmployee) {
		if(employeeRepository.findById(id).isPresent()) {
			Employee existingEmployee = employeeRepository.findById(id).get();
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
	
	
	public  List<Employee> GetEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee findEmployee(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			Employee existingEmployee = employeeRepository.findById(id).get();
			return existingEmployee;
		}
		else {
			return null;
		}
	}
}
