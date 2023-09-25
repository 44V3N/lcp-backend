package com.lcp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcp.app.entity.Appointment;

public interface AppointmentRepository extends JpaRepository < Appointment, Long>{

}
