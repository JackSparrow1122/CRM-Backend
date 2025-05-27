package com.deep.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.springboot.entity.Trainer;
@Repository
public interface TrainerRepo extends JpaRepository<Trainer,Long> {
	 Trainer deleteById(long id);

	 Optional<Trainer> findByEmailAndPassword(String email, String password);

}
