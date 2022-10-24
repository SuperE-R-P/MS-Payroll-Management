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

import com.esprit.microservices.entity.Employee;
import com.esprit.microservices.exceptions.InvalidPayrollReferenceException;
import com.esprit.microservices.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin()
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
	public Long createEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee.getId();
	}
	
	@GetMapping("/viewAll")
	public Iterable<Employee> viewAllEmployees() {
		return employeeService.getEmployeeHistory();
	}
	
	@GetMapping("/view/{id}")
	public Employee viewEmployeeById(@PathVariable ("id") Long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
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
		public Employee modifyFacture(@PathVariable("id") long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
		}
}
