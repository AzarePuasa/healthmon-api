package com.azare.healthmon.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azare.healthmon.model.BPReading;

public interface BPReadingRepository extends JpaRepository<BPReading, Long>  {
	
	Optional<BPReading> findByDate(Date date);
}
