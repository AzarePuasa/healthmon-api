package com.azare.healthmon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azare.healthmon.model.Weight;

@RestController
@RequestMapping("/api")
public class WeightController {
	private static final Logger LOG = LoggerFactory.getLogger(WeightController.class);
	
	@GetMapping("/weights")
	public List<Weight> getAllRecord() {
		return new ArrayList<Weight>();
	}
	
	@PostMapping("/weight")
	public Weight createWeightRecord(@Valid @RequestBody Weight weight) {
		return new Weight();
	}
	
	@GetMapping("/weight/{id}")
	public Weight getWeightRecordById(@PathVariable(value = "id") Long weightId) {
		return new Weight();
	}
}
