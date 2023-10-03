package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Payroll;
import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.PayrollRepo;
import com.examly.springapp.repository.EmployeeRepo;


@Service
public class ApiService {
	
	@Autowired
	private PayrollRepo payrollRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public boolean savePayroll(Payroll p, Long employeeId) {
		if(employeeRepo.existsById(employeeId))
		{
			Employee emp= employeeRepo.findById(employeeId).get();
			emp.setPayroll(p);
			return employeeRepo.save(emp)!= null ? true : false;
			
			}
		return false;
	}
	
	public boolean saveEmployee(Employee t) {
		return employeeRepo.save(t) != null ? true : false;
	}
	
	public List<Employee> getAllEmployee() {

		List<Employee> list = employeeRepo.findAll();
		return list;
	}
	
	public Employee getEmployeeById(Long employeeId) {

		if (employeeRepo.existsById(employeeId)) {
			Employee employee = employeeRepo.findById(employeeId).get();
			return employee;
		}
		return null;
	}
	
	public Payroll getByPayrollId(Long employeeId) { 

		if(employeeRepo.existsById(employeeId))
		{
			Employee emp= employeeRepo.findById(employeeId).get();
			long payrollId= emp.getPayroll().getPayrollId();
			Payroll list = payrollRepo.findById(payrollId).get();
			return list;
		}
		return null;
	}
	
	
}
