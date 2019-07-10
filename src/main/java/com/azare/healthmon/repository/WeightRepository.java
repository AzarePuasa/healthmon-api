package com.azare.healthmon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azare.healthmon.model.Weight;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {

}
