package com.lcp.app.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcp.app.entity.Appointment;
//import com.lcp.app.entity.Customer;
import com.lcp.app.repository.AppointmentRepository;
import com.lcp.app.repository.CustomerRepository;
import com.lcp.app.service.AppointmentService;

@Service
public class AppoinmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Appointment createAppointment(Appointment appointment) {
		System.out.println(appointment.toString());
		appointment.setUuid(UUID.randomUUID().toString());
//		
//		Customer customer = customerRepository.findById((long) appointment.getCustomer().getCustomerID());
//		if(customer != null) customer.addAppointment();
		
		return saveAppointment(appointment);
	}
	
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment getAppointmentByUuid(String uuid) {
		return appointmentRepository.findByUuid(uuid)
				.orElseThrow( ()-> new IllegalStateException("Appointment does not exist with uuid " + uuid) );
	}
	
	@Override
	public Appointment getAppointmentById(Long id) {
		return appointmentRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Appointment does not exist with id " + id) );
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return (List<Appointment>) appointmentRepository.findAll();
	}

	@Override
	public Appointment updateAppointment(Appointment appointment, Long id) {
		Appointment existingAppointment = getAppointmentById(id);
		existingAppointment.setDateTime(  appointment.getDateTime()   );
		existingAppointment.setName(  appointment.getName()   );
		existingAppointment.setLastName(  appointment.getLastName()   );
		existingAppointment.setLastName2(  appointment.getLastName2()   );
		existingAppointment.setSex(  appointment.getSex()   );
		existingAppointment.setBirthDate(  appointment.getBirthDate()   );
		existingAppointment.setEmail(  appointment.getEmail()   );
		existingAppointment.setPhonenumber(  appointment.getPhonenumber()   );
		existingAppointment.setUrlAnalisis(  appointment.getUrlAnalisis()   );
		existingAppointment.setStudies(  appointment.getStudies()   );
		return saveAppointment( existingAppointment );
	}

	@Override
	public Appointment deleteAppointment(Long id) {
		Appointment existingAppointment = getAppointmentById(id);
		appointmentRepository.delete(existingAppointment);
		return existingAppointment;
	}

	@Override
	public List<Appointment> getAllAppointmentsByCustomerId(Long id) {
		return appointmentRepository.findAllByCustomerCustomerID(id)
				.orElseThrow( ()-> new IllegalStateException("User has no appointments") );
	}
	
}
