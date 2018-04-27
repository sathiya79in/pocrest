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

import com.restint.model.Company;
import com.restint.repository.CompanyDao;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
    private CompanyDao  companyDao ;

    public CompanyController(CompanyDao  companyDao){
        this.companyDao = companyDao;
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Company> find(@ApiPathParam(name = "id") @PathVariable long id){
        return companyDao.findById(id);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Company> all(){
        return this.companyDao.findAll();
    }

 
    @RequestMapping(method = RequestMethod.POST)
    @ApiMethod(description = "Create a company and save it to the database")
    public List<Company> create(@RequestBody Company company){
    	
    	companyDao.save(company);
    	return companyDao.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiMethod(description = "update a company and save it to the database")
    public List<Company> update(@RequestBody Company company){
    	
    	companyDao.save(company);
    	return companyDao.findAll();
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Remove the company with the provided ID from the database")
    public List<Company> remove(@ApiPathParam(name = "id") @PathVariable long id){
    	
    	companyDao.deleteById(id);
        return companyDao.findAll();
    }
	


}
