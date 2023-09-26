package com.lcp.app.service;

import java.util.List;

import com.lcp.app.entity.Appointment;

public interface AppointmentService {
	
	Appointment createAppointment( Appointment appointment);
	
	Appointment getAppointmentById(Long id);
	
	List<Appointment> getAllAppointments();
	
	Appointment updateAppointment(Appointment appointment, Long id);
	
	Appointment deleteAppointment(Long id);
	
}
