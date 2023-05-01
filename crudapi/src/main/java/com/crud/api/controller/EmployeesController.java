package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.entity.Employees;
import com.crud.api.service.EmployeesService;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/emp")
@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
public class EmployeesController {

	@Autowired
	EmployeesService employeesService;
	
	@GetMapping("/view")
	@ResponseBody
    private List<Employees> getAllEmployees() {
        return employeesService.getAllEmployees();
    }
	
	@GetMapping("/getbyid/{id}")
    private Employees getEmployeeById(@PathVariable("id") int id) {
        return employeesService.getEmployeeById(id);
    }
	
	@PostMapping(value = "/add",  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})	
	@ResponseBody
    private ResponseEntity createEmployee(@RequestBody Employees employees) {
       System.out.println(employees.getFirstName());
		try {
            employeesService.saveOrUpdate(employees);
        } catch (Exception exception) {
        	System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New employee created with id: " + employees.getId(), HttpStatus.CREATED);
    }
	
	@DeleteMapping("/delete/{id}")
    private ResponseEntity deleteById(@PathVariable("id") Long id) {
        try {
        	employeesService.delete(id);
        } catch (Exception exception) {
        	exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id: " + id, HttpStatus.OK);
    }
	
	 
  
}
