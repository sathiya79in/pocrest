package com.restint.controllers;

import java.util.List;
import java.util.Optional;

import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restint.repository.EmployeeDao;
import com.restint.model.Employee;

    @RestController
	@RequestMapping("/employee")
	public class EmployeeController {
	
	    @Autowired
	    private EmployeeDao employeeDao;

	    public EmployeeController(EmployeeDao employeeDao){
	        this.employeeDao = employeeDao;
	    }

	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public Optional<Employee> find(@ApiPathParam(name = "id") @PathVariable long id){
	        return employeeDao.findById(id);
	    }
	    
	    @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public Iterable<Employee> all(){
	        return this.employeeDao.findAll();
	    }
	
	   // Post methods uses the postman app 
	    @RequestMapping(method = RequestMethod.POST)
	    @ApiMethod(description = "Create a employee and save it to the database")
	    public List<Employee> create(@RequestBody Employee employee){
	    	employeeDao.save(employee);

	        return employeeDao.findAll();
	    }

	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    @ApiMethod(description = "Remove the employee with the provided ID from the database")
	    public List<Employee> remove(@ApiPathParam(name = "id") @PathVariable long id){
	    	employeeDao.deleteById(id);

	        return employeeDao.findAll();
	    }
}