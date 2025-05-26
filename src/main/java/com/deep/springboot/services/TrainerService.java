package com.deep.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.springboot.entity.Trainer;
import com.deep.springboot.repository.TrainerRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
	
    @Autowired
    private TrainerRepo trainerRepo;

    public List<Trainer> getAllTrainers() {
        return trainerRepo.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return trainerRepo.findById(id).orElse(null);
    }

    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepo.save(trainer);
    }

	public Trainer deleteTrainer(long id) {
		return trainerRepo.deleteById(id);
	}

	public void updateTrainer(long editingId, Trainer trainer) {
	    Optional<Trainer> trainers = trainerRepo.findById(editingId);
	    if (trainers.isPresent()) {
	        Trainer existTrainer = trainers.get();
	        existTrainer.setAddress(trainer.getAddress());
	   
	        trainerRepo.save(existTrainer); 
	    }
	}

}
