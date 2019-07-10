package com.azare.healthmon.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azare.healthmon.model.Weight;
import com.azare.healthmon.service.WeightService;

@RestController
@RequestMapping("/api")
public class WeightController {

	private static final Logger LOG = LoggerFactory.getLogger(WeightController.class);

	@Autowired
	WeightService weightService;

	@GetMapping("/weights")
	public List<Weight> getAllRecord() {
		LOG.info("Getting All Weight Records");
		return weightService.getAll();
	}

	@PostMapping("/weight")
	public Weight createWeightRecord(@Valid @RequestBody Weight weight) {
		return weightService.createWeightRecord(weight);
	}

	@GetMapping("/weight/{id}")
	public Weight getWeightRecordById(@PathVariable(value = "id") Long weightId) {
		return weightService.getWeightRecordById(weightId);
	}

	@PutMapping("/weight/{id}")
	public Weight updateRecord(@PathVariable(value = "id") Long weightId, @Valid @RequestBody Weight weightDetails) {
		return weightService.updateRecord(weightId, weightDetails);
	}

	@DeleteMapping("/weight/{id}")
	public ResponseEntity<?> deleteWeight(@PathVariable(value = "id") Long weightId) {
		weightService.deleteRecord(weightId);
		return ResponseEntity.ok().build();
	}
}
