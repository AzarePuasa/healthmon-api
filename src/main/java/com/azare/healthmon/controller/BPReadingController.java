package com.azare.healthmon.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azare.healthmon.model.BPReading;
import com.azare.healthmon.service.BPReadingService;

@RestController
@RequestMapping("/api")
public class BPReadingController {

	private static final Logger LOG = LoggerFactory.getLogger(BPReadingController.class);

	@Autowired
	BPReadingService bpService;

	/**
	 * Get all BP Readings
	 * 
	 * @return
	 */
	@GetMapping("/bpreadings")
	public List<BPReading> getAllRecord() {
		return bpService.getAllBPReading();
	}

	// Get one BP Reading
	@GetMapping("/bpreading/{id}")
	public BPReading getBPReadingById(@PathVariable(value = "id") Long id) {
		return bpService.getBPReadingById(id);
	}

	@GetMapping("/getreadingbydate/{date}")
	public BPReading getBPReadingByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

		Optional<BPReading> bpReading = bpService.getBPReadingByDate(date);

		if (bpReading.isPresent()) {
			return bpReading.get();
		}

		return null;
	}

	// Create BP Reading
	@PostMapping("/bpreading")
	public BPReading createBPReading(@Valid @RequestBody BPReading bpReading) {
		return bpService.createBPReading(bpReading);
	}

	// Update BP Reading
	@PutMapping("/bpmorning/{id}")
	public BPReading updateMorningBP(@PathVariable(value = "id") Long id, @PathVariable(value = "id") String reading) {
		return bpService.updateBPMorning(id, reading);
	}

	@PutMapping("/bpafternoon/{id}")
	public BPReading updateAfternoonBP(@PathVariable(value = "id") Long id,
			@PathVariable(value = "id") String reading) {
		return bpService.updateBPAfternoon(id, reading);
	}

	@PutMapping("/bpevening/{id}")
	public BPReading updateEveningBP(@PathVariable(value = "id") Long id, @PathVariable(value = "id") String reading) {
		return bpService.updateBPEvening(id, reading);
	}

	// Delete BP Reading
	@DeleteMapping("/bpreading/{id}")
	public ResponseEntity<?> deleteRecord(@PathVariable(value = "id") Long id) {
		return bpService.delete(id);
	}

}
