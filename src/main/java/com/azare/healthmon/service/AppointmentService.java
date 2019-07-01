package com.azare.healthmon.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.azare.healthmon.exception.ResourceNotFoundException;
import com.azare.healthmon.model.Appointment;
import com.azare.healthmon.repository.AppointmentRepository;


@Service
public class AppointmentService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppointmentService.class);

	@Autowired
	AppointmentRepository apptRepository;

	public List<Appointment> getAll() {
		LOG.info("getAll()");
		return apptRepository.findAll();
	}
	
    public Appointment createAppointment(Appointment appt) {
        return apptRepository.save(appt);
    }

	public Appointment getAppointmentById(Long apptId) {
		return apptRepository.findById(apptId).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", apptId));
	}

	public Appointment update( Long apptId, Appointment apptDetails) {

		Appointment appointment = apptRepository.findById(apptId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", apptId));

		appointment.setLocation(apptDetails.getLocation());
		appointment.setPurpose(apptDetails.getPurpose());

		Appointment updatedAppointment = apptRepository.save(appointment);
		return updatedAppointment;
	}
	
	 public ResponseEntity<?> delete(Long apptId) {
		 Appointment appointment = apptRepository.findById(apptId)
	                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", apptId));

	        apptRepository.delete(appointment);

	        return ResponseEntity.ok().build();
	    }

}
