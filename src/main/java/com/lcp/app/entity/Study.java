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
@Column(name="name")
private String name;
@Column(name="description")
private String description;
@Column(name="indications")
private String indications;
@Column(name="wait_time")
private String waitTime;
@Column(name="url")
private String urlStudy;
@ManyToOne
@JoinColumn(name="fk_category_id", nullable=false)
private Category category;
@ManyToMany(mappedBy = "studies")
@JsonIgnore
private List<Appointment> appointments = new ArrayList<>();

}