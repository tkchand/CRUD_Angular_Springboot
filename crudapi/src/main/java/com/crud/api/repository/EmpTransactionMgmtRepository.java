package com.crud.api.repository;

import java.util.List;

import com.crud.api.entity.Employees;

public interface EmpTransactionMgmtRepository {

	 public List<Employees> getAllEmployees();
	
	 public Employees getEmployeeById(int id);
	
	 public Long saveOrUpdate(Employees employee);
	 
	 public int delete(Long id);
	 
}
