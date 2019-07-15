package com.azare.healthmon.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.azare.healthmon.exception.ResourceNotFoundException;
import com.azare.healthmon.model.BPReading;
import com.azare.healthmon.repository.BPReadingRepository;

@Service
public class BPReadingService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BPReadingService.class);
	
	@Autowired
	BPReadingRepository bpReadingRepository;

	/**
	 * Get all columns
	 * @return
	 */
	public List<BPReading> getAllBPReading() {
		LOG.info("Get all BP Reading");
		return bpReadingRepository.findAll();
	}
	
	//get a single BPReading by Id.
	public BPReading getBPReadingById(Long bpReadingId) {
		return bpReadingRepository.findById(bpReadingId)
				.orElseThrow(
						() -> new ResourceNotFoundException("BPReading", "id", bpReadingId));
	}
	
	//Testing this endpoint. Not sure whether syntax is correct.
	public Optional<BPReading> getBPReadingByDate(Date date) {
		Optional<BPReading> result = bpReadingRepository.findByDate(date);
		return result;
	}
	
	/**
	 * Post new BPReading.
	 * @param bpReading
	 * @return
	 */
	public BPReading createBPReading(BPReading bpReading) {
		LOG.info("Post BP Reading");
		return bpReadingRepository.save(bpReading);
	}
	
	
	//Put method to update BPReading.
	public BPReading update(Long bpReadingId, BPReading bpDetails) {
		BPReading bpReading = bpReadingRepository.findById(bpReadingId)
				.orElseThrow(
						() -> new ResourceNotFoundException("BPReading", "id", bpReadingId));

		bpReading.setBpreading(bpDetails.getBpreading());
		bpReading.setType(bpDetails.getType());
		
		BPReading updatedBPReading = bpReadingRepository.save(bpReading);
		
		return updatedBPReading;
	}
	
	/**
	 * Delete method to delete a record.
	 * @param bpReadingId
	 * @return
	 */
	public ResponseEntity<?> delete(Long bpReadingId) {
		BPReading bpReading = bpReadingRepository.findById(bpReadingId)
				.orElseThrow(() -> new ResourceNotFoundException("BPReading", "id", bpReadingId));

		bpReadingRepository.delete(bpReading);

		return ResponseEntity.ok().build();
	}
	
//	public Optional<BPReading> getBPReadingByDate1(Date date) {
//		Optional<BPReading> bpReading = bpReadingRepository.findByDate(date);
//		
//		return bpReading;
//				
//	}
	
	//Experiment on Exist
	/* eg. from https://www.baeldung.com/spring-data-exists-query
	 *  Car probe = new Car();
		probe.setModel("bmw");
		Example<Car> example = Example.of(probe, modelMatcher);
		boolean exists = repository.exists(example);
	 */
}
