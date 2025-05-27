package com.deep.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.springboot.entity.Trainer;
import com.deep.springboot.entity.TrainerAssignment;
import com.deep.springboot.repository.TrainerAssignmentRepository;

@Service
public class TrainerAssignmentService {

    @Autowired
    private TrainerAssignmentRepository trainerAssignmentRepository;

    public List<TrainerAssignment> getAllAssignments() {
        return trainerAssignmentRepository.findAll();
    }

    public TrainerAssignment saveTrainerAssignment(TrainerAssignment trainerAssignment) {
        return trainerAssignmentRepository.save(trainerAssignment);
    }

    public void deleteTrainerAssignment(Long id) {
        if (trainerAssignmentRepository.existsById(id)) {
            trainerAssignmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Assignment not found with id: " + id);
        }
    }

    public List<TrainerAssignment> authTrainer(String email) {
        List<TrainerAssignment> byTrainer_Email = trainerAssignmentRepository.findByTrainer_Email(email);
        if(byTrainer_Email != null)
        	return byTrainer_Email;
        else
        	return null;
    }


}
