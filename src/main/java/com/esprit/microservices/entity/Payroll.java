package com.esprit.microservices.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Payroll implements Serializable{
	private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Employee2 employee;
	private String payrollMonth;
	private int totalWorkingDays;
	private float salary;
	private float deductions;
	private float earnings;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Payroll() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee2 getEmployee() {
		return employee;
	}
	public void setEmployee(Employee2 employee) {
		this.employee = employee;
	}
	public String getPayrollMonth() {
		return payrollMonth;
	}
	public void setPayrollMonth(String payrollMonth) {
		this.payrollMonth = payrollMonth;
	}
	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}
	public void setTotalWorkingDays(int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getDeductions() {
		return deductions;
	}
	public void setDeductions(float deductions) {
		this.deductions = deductions;
	}
	public float getEarnings() {
		return earnings;
	}
	public void setEarnings(float earnings) {
		this.earnings = earnings;
	}
	public Payroll(Employee2 employee, String payrollMonth, int totalWorkingDays, float salary, float deductions,
			float earnings) {
		super();
		this.employee = employee;
		this.payrollMonth = payrollMonth;
		this.totalWorkingDays = totalWorkingDays;
		this.salary = salary;
		this.deductions = deductions;
		this.earnings = earnings;
	}
	public Payroll(Employee2 employee, float salary) {
		super();
		this.employee = employee;
		this.salary = salary;
	}
	
}
