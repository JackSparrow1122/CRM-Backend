package com.deep.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.springboot.entity.College;
import com.deep.springboot.entity.TrainerAssignment;
@Repository
public interface TrainerAssignmentRepository extends JpaRepository<TrainerAssignment, Long> {

	void deleteByCollege(College college);
}
