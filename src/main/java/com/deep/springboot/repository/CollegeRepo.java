package com.deep.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.springboot.entity.College;
@Repository
public interface CollegeRepo extends JpaRepository<College, Long> {

	boolean existsByNameAndLocation(String name, String location);
}
