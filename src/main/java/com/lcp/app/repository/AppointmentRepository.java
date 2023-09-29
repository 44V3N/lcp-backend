package com.lcp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcp.app.entity.Appointment;

public interface AppointmentRepository extends JpaRepository < Appointment, Long>{

	Optional<Appointment> findByUuid(String uuid);
}
