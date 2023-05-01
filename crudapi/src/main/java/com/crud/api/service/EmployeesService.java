package com.crud.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.entity.Employees;
import com.crud.api.repository.BaseRepository;
import com.crud.api.repository.EmpTransactionMgmtRepository;
 
@Service
public class EmployeesService {
 
	@Autowired
	BaseRepository baseRepository;
	
	 public List<Employees> getAllEmployees() {	 
		  
		 List<Employees> employees =  baseRepository.getAllEmployees();
		
	        return employees;
	 }
 
	   public Employees getEmployeeById(int id) {
	    	Employees emp = baseRepository.getEmployeeById(id);
	        return emp;
	    }
	    
	   
	    public Long saveOrUpdate(Employees employee) {
	    	 Long id = baseRepository.saveOrUpdate(employee);
	    	 
	    	 return id;
	    }
	    
	    
	    public int delete(Long id) {
	       
	    	int deletedCount = baseRepository.delete(id);
	    	
	    	return deletedCount;
	    }
	
}
