package com.azare.healthmon.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
