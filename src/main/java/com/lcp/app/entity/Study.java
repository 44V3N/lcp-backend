package com.lcp.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studies")
public class Study {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="study_id")
private Long studyId;
@Column(name="name", length=100, nullable=false)
private String name;
@Column(name="indications", length=1000, nullable=true)
private String indications;
@Column(name="wait_time", length=50, nullable=true)
private String waitTime;
@Column(name="active", columnDefinition="boolean default true", nullable=false)
private boolean isActive;
@ManyToOne
@JoinColumn(name="fk_category_id", nullable=false)
private Category category;
@ManyToMany(mappedBy = "studies")
@JsonIgnore
private List<Appointment> appointments = new ArrayList<>();

}