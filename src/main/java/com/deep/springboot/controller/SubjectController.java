package com.deep.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deep.springboot.entity.Subject;
import com.deep.springboot.services.SubjectService;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping(path = "/getsubject")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping(path = "/addSubject")
    public Subject createSubjects(@RequestBody Subject subjects) {
        return subjectService.saveAllSubjects(subjects);
    }
    
    @PutMapping(path="/updateSubject/{editingId}")
    public ResponseEntity<Subject>  updateSubject(@PathVariable long editingId, @RequestBody Subject subject) {
    	Subject subject1 = subjectService.updateSubject(editingId, subject);
        if (subject1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subject1);
    }
    
    @DeleteMapping(path = "/deletesubject/{id}")
    public Subject deleteSubjecs(@PathVariable long id) {
        return subjectService.deleteSubjecs(id);
    }

}
