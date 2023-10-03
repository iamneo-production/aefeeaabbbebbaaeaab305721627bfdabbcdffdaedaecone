package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Payroll {
    @Id
    private Long payrollId;

    private double amount;
    private int noOfDaysWorked;
    
    @OneToOne
    private Employee employee;

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getNoOfDaysWorked() {
		return noOfDaysWorked;
	}

	public void setNoOfDaysWorked(int noOfDaysWorked) {
		this.noOfDaysWorked = noOfDaysWorked;
	}
    @JsonIgnore
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Payroll(Long payrollId, double amount, int noOfDaysWorked, Employee employee) {
		super();
		this.payrollId = payrollId;
		this.amount = amount;
		this.noOfDaysWorked = noOfDaysWorked;
		this.employee = employee;
	}

	public Payroll() {
		super();
	}
    
   
 
}
