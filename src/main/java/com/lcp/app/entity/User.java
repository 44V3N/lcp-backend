package com.lcp.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="user_id")
private Long userID;
@Column(name="name")
private String name;
@Column(name="lastname")
private String lastName;
@Column(name="latname2")
private String lastName2;
@Column(name="sex")
private String sex;
@Column(name="birthdate")
private String birthDate;
@Column(name="email")
private String email;
@Column(name="phonenumber")
private String phonenumber;
@Column(name="password")
private String password;
@ManyToOne
@JoinColumn(name="fk_role_id", nullable=false)
private Role roles;

}
