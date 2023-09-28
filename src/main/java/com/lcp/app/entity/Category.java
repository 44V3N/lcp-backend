package com.lcp.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="category_id")
private Long categoryId;
@Column(name="name", length=100, nullable=false)
private String name;
@Column(name="url", length=200, nullable=false)
private String urlCategory;

}