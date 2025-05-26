package com.deep.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.deep.springboot.entity.Trainer;
import com.deep.springboot.services.TrainerService;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping(path= "/gettrainers")
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @PostMapping(path= "/addtrainers")
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerService.saveTrainer(trainer);
    }
    
    @PutMapping(path = "/updateTrainer/{editingId}")
    protected void updateTrainer(@PathVariable long editingId ,@RequestBody Trainer trainer) {
    	trainerService.updateTrainer(editingId,trainer);
	}
    
    @DeleteMapping(path = "deleteTrainer/{id}")
    protected Trainer deleteTrainer(@PathVariable long id) {
    	return trainerService.deleteTrainer(id);
	}
}
