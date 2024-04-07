package com.consultant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "consultant")
public class Consultant {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultantId;

	@Column(name ="name")
    private String name;
	
	@Column(name ="age")
    private int age;
	
	@Column(name ="phone_number")
    private String phoneNo;
	
	@Column(name ="cv")
    private String cv;
	
	@Column(name ="e_mail")
    private String email;

}
