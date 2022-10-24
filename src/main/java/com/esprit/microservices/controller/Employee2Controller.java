package com.esprit.microservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservices.entity.Employee2;
import com.esprit.microservices.exceptions.InvalidPayrollReferenceException;
import com.esprit.microservices.service.Employee2Service;

@RestController
@RequestMapping(value = "/api/employee2")
@CrossOrigin()
public class Employee2Controller {
	@Autowired
	Employee2Service employeeService;
	
	@PostMapping("/create")
	public Long createEmployee(@RequestBody Employee2 employee) {
		employeeService.saveEmployee(employee);
		return employee.getId();
	}
	
	@GetMapping("/viewAll")
	public Iterable<Employee2> viewAllEmployees() {
		return employeeService.getEmployeeHistory();
	}
	
	@GetMapping("/view/{id}")
	public Employee2 viewEmployeeById(@PathVariable ("id") Long id) {
		Optional<Employee2> employee = employeeService.getEmployee(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new InvalidPayrollReferenceException("Invalid Employee reference provided");
		
	}
		@DeleteMapping("/remove/{id}")
		@ResponseBody
		public void removeFacture(@PathVariable("id") long id) {
			employeeService.deleteEmployee(id);
		}
		
		@PutMapping("/modify/{id}")
		@ResponseBody
		public Employee2 modifyFacture(@PathVariable("id") long id, @RequestBody Employee2 employee) {
		return employeeService.updateEmployee(id, employee);
		}
}
