package com.azare.healthmon.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.azare.healthmon.exception.ResourceNotFoundException;
import com.azare.healthmon.model.Weight;
import com.azare.healthmon.repository.WeightRepository;

@Service
public class WeightService {

	private static final Logger LOG = LoggerFactory.getLogger(WeightService.class);

	@Autowired
	WeightRepository weightRepository;

	public List<Weight> getAll() {
		LOG.info("Getting all Weight Records");
		return weightRepository.findAll();
	}
	
	public Weight createWeightRecord(Weight weight) {
		return weightRepository.save(weight);
	}

	public Weight getWeightRecordById(Long weightId) {
		return weightRepository.findById(weightId)
				.orElseThrow(() -> new ResourceNotFoundException("Weight", "id", weightId));
	}
	
	public Weight updateRecord(Long weightId, Weight weightDetails) {
		Weight weight = weightRepository.findById(weightId)
				.orElseThrow(() -> new ResourceNotFoundException("Weight", "id", weightId));

		weight.setDate(weightDetails.getDate());
		weight.setWeight(weightDetails.getWeight());
		
		Weight updatedWeight = weightRepository.save(weight);
		
		return updatedWeight;
	}
	
	public ResponseEntity<?> deleteRecord(Long weightId) {
		Weight weight = weightRepository.findById(weightId)
				.orElseThrow(() -> new ResourceNotFoundException("Weight", "id", weightId));

		weightRepository.delete(weight);
		
		return ResponseEntity.ok().build();
	}
}
