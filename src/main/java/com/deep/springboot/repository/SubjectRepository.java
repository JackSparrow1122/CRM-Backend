package com.deep.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.springboot.entity.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	boolean existsBysubjectName(String subjectName);
}
