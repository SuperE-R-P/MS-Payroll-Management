package com.esprit.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservices.entity.Payroll;
import com.esprit.microservices.repository.PayrollRepository;

@Service
public class PayrollService {

	@Autowired
	PayrollRepository payrollRepository;
	
	public void savePayroll(Payroll payroll) {
		payrollRepository.save(payroll);
	}
	
	public Iterable<Payroll> getPayrollHistory() {
		return payrollRepository.findAll();
	}
	
	public Optional<Payroll> getPayroll(Long id) {
		return payrollRepository.findById(id);
	}
	
	public Payroll updatePayroll(Long id, Payroll newPayroll) {
		if(payrollRepository.findById(id).isPresent()) {
			Payroll existingPayroll = payrollRepository.findById(id).get();
			//existingPayroll.setEmployee(newPayroll.getEmployee());
			existingPayroll.setPayrollMonth(newPayroll.getPayrollMonth());
			existingPayroll.setSalary(newPayroll.getSalary());
			existingPayroll.setTotalWorkingDays(newPayroll.getTotalWorkingDays());
			existingPayroll.setEarnings(newPayroll.getEarnings());
			existingPayroll.setDeductions(newPayroll.getDeductions());
			
			return payrollRepository.save(existingPayroll);
		}
		else {
			return null;
		}
	}
	
	
	public String deletePayroll(Long id) {
		if(payrollRepository.findById(id).isPresent()) {
			payrollRepository.deleteById(id);
			return "Le Payroll avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le Payroll avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	public  List<Payroll> GetPayrolls() {
		return payrollRepository.findAll();
	}
	
	public Payroll findPayroll(Long id) {
		if(payrollRepository.findById(id).isPresent()) {
			Payroll existingPayroll = payrollRepository.findById(id).get();
			return existingPayroll;
		}
		else {
			return null;
		}
	}
	
}
