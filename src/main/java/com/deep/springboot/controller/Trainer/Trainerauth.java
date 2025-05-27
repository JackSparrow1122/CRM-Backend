package com.deep.springboot.controller.Trainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deep.springboot.entity.Trainer;
import com.deep.springboot.entity.TrainerAssignment;
import com.deep.springboot.services.TrainerAssignmentService;
import com.deep.springboot.services.TrainerService;
@RestController
@CrossOrigin(origins = "*")
public class Trainerauth {

	@Autowired
	private TrainerAssignmentService assignmentService;
	
	@Autowired
	private TrainerService service;
	
    @GetMapping(path = "/auth/{email}")
    public List<TrainerAssignment> authTrainer(@PathVariable String email)  {
        return assignmentService.authTrainer(email);
    }
    
    @PostMapping (path = "/authentication")
    public boolean authentication(@RequestParam String email, @RequestParam String password )  {
    	 Trainer isValid = service.authentication(email, password);
    	 if(isValid != null)
    		 return true;
    	 else 
    		 return false;

         
    }
	
}
