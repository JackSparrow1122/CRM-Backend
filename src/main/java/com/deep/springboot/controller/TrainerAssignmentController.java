package com.deep.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deep.springboot.entity.TrainerAssignment;
import com.deep.springboot.services.TrainerAssignmentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TrainerAssignmentController {

    @Autowired
    private TrainerAssignmentService trainerAssignmentService;

    @GetMapping(path = "/getAssi")
    public List<TrainerAssignment> getAllAssignments() {
        return trainerAssignmentService.getAllAssignments();
    }

    // POST /assignments
    @PostMapping(path="/addAssi")
    public TrainerAssignment createAssignment(@RequestBody TrainerAssignment trainerAssignment) {
        return trainerAssignmentService.saveTrainerAssignment(trainerAssignment);
    }


    // DELETE /assignments/{id}
    @DeleteMapping("deleteAssi/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        trainerAssignmentService.deleteTrainerAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
