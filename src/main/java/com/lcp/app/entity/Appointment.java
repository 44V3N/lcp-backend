package com.lcp.app.entity;


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
@Column(name="datetime")
private String dateTime;
@Column(name="name")
private String name;
@Column(name="lastname")
private String lastName;
@Column(name="lastname2")
private String lastName2;
@Column(name="sex")
private String sex;
@Column(name="birthdate")
private String birthDate;
@Column(name="email")
private String email;
@Column(name="phonenumber")
private String phonenumber;
@Column(name="url_analysis_results")
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
