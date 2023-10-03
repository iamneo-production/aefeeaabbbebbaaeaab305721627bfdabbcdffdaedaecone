package com.examly.springapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employee {
    @Id
    private Long employeeId;

    private String employeeName; 
    private int age; 
    private long mobile;

    @OneToOne(cascade = CascadeType.ALL)
    private Payroll payroll;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	public Employee(Long employeeId, String employeeName, int age, long mobile) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.mobile = mobile;
	}

	public Employee() {
		super();
	}
    
    
}
