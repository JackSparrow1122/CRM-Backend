package com.deep.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.springboot.entity.Subject;
import com.deep.springboot.repository.SubjectRepository;

@Service
public class SubjectService {

	 @Autowired
	    private SubjectRepository subjectRepository;

	    public List<Subject> getAllSubjects() {
	        return subjectRepository.findAll();
	    }

	    public Subject getSubjectById(Long id) {
	        return subjectRepository.findById(id).orElse(null);
	    }

	    public Subject saveAllSubjects(Subject subjects) {
	    	boolean exists=subjectRepository.existsBysubjectName(subjects.getSubjectName());
	    	if(exists)
	    		return null;
	    	else
	        return subjectRepository.save(subjects);
	    }

		public Subject deleteSubjecs(long id) {
			subjectRepository.deleteById(id);
			return null;
		}

		public Subject updateSubject(long editingId, Subject subject) {
		    Optional<Subject> exist = subjectRepository.findById(editingId);
		    if (exist.isPresent()) {
		        Subject existingSubject = exist.get();
		        existingSubject.setSubjectName(subject.getSubjectName()); 
		        return subjectRepository.save(existingSubject);
		    } else {
		        return null;
		    }
		}

 
}
