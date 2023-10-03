package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Payroll;

@Repository
public interface PayrollRepo extends JpaRepository<Payroll, Long> {
	
}

