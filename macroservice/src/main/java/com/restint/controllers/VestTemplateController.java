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

import com.restint.model.VestTemplate;
import com.restint.repository.VestTemplateDao;

@RestController
@RequestMapping("/vest-template")
public class VestTemplateController {

	@Autowired
    private VestTemplateDao vestTemplateDao;

    public VestTemplateController(VestTemplateDao vestTemplateDao){
        this.vestTemplateDao = vestTemplateDao;
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<VestTemplate> find(@ApiPathParam(name = "id") @PathVariable long id){
        return vestTemplateDao.findById(id);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<VestTemplate> all(){
        return vestTemplateDao.findAll();
    }

 
    @RequestMapping(method = RequestMethod.POST)
    @ApiMethod(description = "Create a vest template and save it to the database")
    public List<VestTemplate> create(@RequestBody VestTemplate vestTemplate){
    	
    	vestTemplateDao.save(vestTemplate);
    	return vestTemplateDao.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiMethod(description = "update a vest template and save it to the database")
    public List<VestTemplate> update(@RequestBody VestTemplate vestTemplate){
    	
    	vestTemplateDao.save(vestTemplate);
    	return vestTemplateDao.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Remove the vest template with the provided ID from the database")
    public List<VestTemplate> remove(@ApiPathParam(name = "id") @PathVariable long id){
    	
    	vestTemplateDao.deleteById(id);
        return vestTemplateDao.findAll();
    }
	


}
