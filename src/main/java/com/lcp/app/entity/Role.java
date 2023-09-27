package com.lcp.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="role_id")
private Long RoleId;
@Column(name="role_name")
private String roleName;


}