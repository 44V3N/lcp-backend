package com.lcp.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
@Column(name="customer_id")
private Long customerID;
@Column(name="name", length=100, nullable=false)
private String name;
@Column(name="lastname", length=100, nullable=false)
private String lastName;
@Column(name="lastname2", length=100)
private String lastName2;
@Column(name="sex", length=10, nullable=false)
private String sex;
@Column(name="birthdate", columnDefinition = "date" , nullable=false)
private String birthDate;
@Column(name="email", length=200, unique = true, nullable=false)
private String email;
@Column(name="phonenumber", length=15, nullable=false)
private String phonenumber;
@Column(name="password", length=64, nullable=false)
private String password;
@ManyToOne
@JoinColumn(name="fk_role_id", nullable=false)
private Role roles;

}
