package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Payroll;
import com.examly.springapp.model.Employee;
import com.examly.springapp.service.ApiService;

@RestController
public class ApiController {

	@Autowired
	private ApiService apiService;
	
	@PostMapping("/employee")
	public ResponseEntity<Boolean> save(@RequestBody Employee employee) {

		boolean s = apiService.saveEmployee(employee);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.ALREADY_REPORTED);
	}
	
	@PostMapping("/employee/{employeeId}/payroll")
	public ResponseEntity<Boolean> savePayroll(@PathVariable Long employeeId,@RequestBody Payroll payroll) {

		boolean s = apiService.savePayroll(payroll, employeeId);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.ALREADY_REPORTED);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAll() {

		List<Employee> employee = apiService.getAllEmployee();
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {

		Employee Employee = apiService.getEmployeeById(employeeId);
		return new ResponseEntity<>(Employee, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{employeeId}/payroll")
	public ResponseEntity <Payroll> getPayrollById(@PathVariable Long employeeId ) {

		Payroll payroll = apiService.getByPayrollId(employeeId);
		return new ResponseEntity<>(payroll, HttpStatus.OK);
	}
	
	
}
