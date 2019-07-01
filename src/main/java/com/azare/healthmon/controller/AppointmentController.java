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

import com.azare.healthmon.model.Appointment;
import com.azare.healthmon.service.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    AppointmentService service;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointment() {
    	LOG.info("getAllAppointment");
        return service.getAll();
    }

    @PostMapping("/appointment")
    public Appointment createAppointment(@Valid @RequestBody Appointment appt) {
        return service.createAppointment(appt);
    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointmentById(@PathVariable(value = "id") Long apptId) {
        return service.getAppointmentById(apptId);
    }

    @PutMapping("/appointment/{id}")
    public Appointment updateAppointment(@PathVariable(value = "id") Long apptId,
                                           @Valid @RequestBody Appointment apptDetails) {
        return service.update(apptId, apptDetails);
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable(value = "id") Long apptId) {
        service.delete(apptId);
        return ResponseEntity.ok().build();
    }
}
