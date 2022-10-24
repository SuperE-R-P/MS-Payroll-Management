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

import com.esprit.microservices.entity.Payroll;
import com.esprit.microservices.exceptions.InvalidPayrollReferenceException;
import com.esprit.microservices.service.PayrollService;

@RestController
@RequestMapping(value = "/api/payrolls")
@CrossOrigin()
public class PayrollController {

	@Autowired
	PayrollService payrollService;
	
	@PostMapping("/create")
	public Long createPayroll(@RequestBody Payroll payroll) {
		payrollService.savePayroll(payroll);
		return payroll.getId();
	}
	
	@GetMapping("/viewAll")
	public Iterable<Payroll> viewAllPayrolls() {
		return payrollService.getPayrollHistory();
	}
	
	@GetMapping("/view/{id}")
	public Payroll viewPayrollById(@PathVariable ("id") Long id) {
		Optional<Payroll> payroll = payrollService.getPayroll(id);
		if(payroll.isPresent()) {
			return payroll.get();
		}
		
		throw new InvalidPayrollReferenceException("Invalid Payroll reference provided");
	}
		@DeleteMapping("/remove/{id}")
		@ResponseBody
		public void removeFacture(@PathVariable("id") long id) {
			payrollService.deletePayroll(id);
		}
		
		@PutMapping("/modify/{id}")
		@ResponseBody
		public Payroll modifyFacture(@PathVariable("id") long id, @RequestBody Payroll payroll) {
		return payrollService.updatePayroll(id, payroll);
		}
}
