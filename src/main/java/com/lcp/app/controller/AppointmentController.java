package com.lcp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lcp.app.entity.Appointment;
import com.lcp.app.service.AppointmentService;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public  ResponseEntity< Appointment > createAppointment(@RequestBody Appointment appointment) {
		Appointment newAppointment = appointmentService.createAppointment(appointment);
		return new ResponseEntity<>(newAppointment, HttpStatus.CREATED); // Status 201
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("private/{id}")
	public ResponseEntity< Appointment > getAppointmentById(@PathVariable Long id){
		Appointment appointment = appointmentService.getAppointmentById(id);
		return new ResponseEntity<>(appointment, HttpStatus.OK); // Status 200
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("{uuid}")
	public ResponseEntity< Appointment > getAppointmentByUuid(@PathVariable String uuid){
		Appointment appointment = appointmentService.getAppointmentByUuid(uuid);
		return new ResponseEntity<>(appointment, HttpStatus.OK); // Status 200
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity< List<Appointment> > getAllStudies(){
		List<Appointment> appointments = appointmentService.getAllAppointments();
		return new ResponseEntity<>( appointments, HttpStatus.OK );
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("{id}")
	public ResponseEntity< Appointment > updateAppointment(@PathVariable Long id,@RequestBody Appointment appointment){
		Appointment existingAppointment = appointmentService.updateAppointment(appointment, id);
		return new ResponseEntity<>(existingAppointment, HttpStatus.OK); // Status 200
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
	public ResponseEntity< Appointment > deleteAppointment(@PathVariable Long id){
		Appointment appointment = appointmentService.deleteAppointment(id);
		return new ResponseEntity<>(appointment, HttpStatus.OK); // Status 200
	}
	
}
