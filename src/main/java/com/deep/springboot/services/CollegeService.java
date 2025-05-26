package com.deep.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.springboot.entity.College;
import com.deep.springboot.repository.CollegeRepo;
import com.deep.springboot.repository.TrainerAssignmentRepository;

@Service
public class CollegeService {

	@Autowired
    private CollegeRepo collegeRepository;
	
	@Autowired
	private TrainerAssignmentRepository assignmentRepository;

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }

    public College saveCollege(College college) {
        boolean exists = collegeRepository.existsByNameAndLocation(college.getName(), college.getLocation());
        if (exists) {
        return null;
        }
        return collegeRepository.save(college);
    }

    public College deleteCollege(long id) {
    	College college = collegeRepository.findById(id).get();
    	assignmentRepository.deleteByCollege(college);
    	collegeRepository.delete(college);
		return college;
	}

	public College updateCollege(long editingId, College updatedCollege) {
		Optional<College> optionalCollege = collegeRepository.findById(editingId);
        if (!optionalCollege.isPresent()) {
            return null;  
        }
        College existingCollege = optionalCollege.get();
        existingCollege.setName(updatedCollege.getName());
        existingCollege.setLocation(updatedCollege.getLocation());

        return collegeRepository.save(existingCollege);
    }
}
