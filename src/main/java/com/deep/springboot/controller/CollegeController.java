package com.deep.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deep.springboot.entity.College;
import com.deep.springboot.services.CollegeService;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @GetMapping(path = "/getcolleges")
    protected List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }
    
    @PostMapping(path = "/addCollege")
    protected College createCollege(@RequestBody College college) {
        College savedCollege = collegeService.saveCollege(college);
        if (savedCollege != null) {
        return savedCollege;
        }
        return null; 
    }
    
    @PutMapping(path="/updatecollege/{editingId}")
    public ResponseEntity<College> updateCollege(@PathVariable long editingId, @RequestBody College updatedCollege) {
        College college = collegeService.updateCollege(editingId, updatedCollege);
        if (college == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(college);
    }

    @DeleteMapping(path = "/deleteCollege/{id}")
    protected College deleteSubjecs(@PathVariable long id) {
        return collegeService.deleteCollege(id);
    }
}
