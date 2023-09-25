package com.lcp.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Study {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="study_id")
private Long studyId;
@Column(name="name")
private String name;
@Column(name="description")
private String descrition;
@Column(name="indications")
private String indications;
@Column(name="wait_time")
private String waitTime;
@Column(name="url")
private String urlStudies;
@ManyToOne
@JoinColumn(name="fk_category_id", nullable=false)
private Category category;

}