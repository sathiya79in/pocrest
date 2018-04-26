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
import com.restint.model.Award;
import com.restint.repository.AwardDao;


@RestController
@RequestMapping("/award")
public class AwardsController {

	@Autowired
    private AwardDao awardDao;

    public AwardsController(AwardDao awardsDao){
        this.awardDao = awardsDao;
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Award> find(@ApiPathParam(name = "id") @PathVariable long id){
        return awardDao.findById(id);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Award> all(){
        return this.awardDao.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    @ApiMethod(description = "Create a award and save it to the database")
    public List<Award> create(@RequestBody Award award){
    	
    	awardDao.save(award);
    	return awardDao.findAll();
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Remove the award with the provided ID from the database")
    public List<Award> remove(@ApiPathParam(name = "id") @PathVariable long id){
    	
    	awardDao.deleteById(id);
        return awardDao.findAll();
    }
	
}
