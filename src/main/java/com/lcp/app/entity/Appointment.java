package com.lcp.app.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="apointment_id")
private Long appointmentId;
@Column(name="datetime", columnDefinition = "timestamp", nullable=false)
private LocalDateTime dateTime;
@Column(name="name", length=100, nullable=false)
private String name;
@Column(name="lastname", length=100, nullable=false)
private String lastName;
@Column(name="lastname2", length=100, nullable=true)
private String lastName2;
@Column(name="sex", length=10, nullable=false)
private String sex;
@Column(name="birthdate", columnDefinition = "date", nullable=false)
private LocalDate birthDate;
@Column(name="email", length=200, nullable=false)
private String email;
@Column(name="phonenumber", length=15, nullable=false)
private String phonenumber;
@Column(name="url_analysis_results", length=200, nullable=true)
private String urlAnalisis;
@ManyToOne
@JoinColumn(name="fk_customer_id", nullable=true)
@JsonIgnore
private Customer customer;
@ManyToMany
@Fetch(FetchMode.JOIN)
@JoinTable(
		  name = "appointment_has_studies", 
		  joinColumns = @JoinColumn(name = "appointment_id"), 
		  inverseJoinColumns = @JoinColumn(name = "study_id"))
private List<Study> studies;
}
