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

import com.restint.model.Plan;
import com.restint.repository.PlanDao;

@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
    private PlanDao planDao;

    public PlanController(PlanDao planDao){
        this.planDao = planDao;
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Plan> find(@ApiPathParam(name = "id") @PathVariable long id){
        return planDao.findById(id);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Plan> all(){
        return this.planDao.findAll();
    }

 
    @RequestMapping( method = RequestMethod.POST)
    @ApiMethod(description = "Create a plan and save it to the database")
    public List<Plan> create(@RequestBody Plan plan){
    	
    	planDao.save(plan);
    	return planDao.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiMethod(description = "update a plan and save it to the database")
    public List<Plan> update(@RequestBody Plan plan){
    	
    	planDao.save(plan);
    	return planDao.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Remove the plan with the provided ID from the database")
    public List<Plan> remove(@ApiPathParam(name = "id") @PathVariable long id){
    	
    	planDao.deleteById(id);
        return planDao.findAll();
    }
	
}
