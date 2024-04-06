package com.consultant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultant_request")
public class ConsultantRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private String name;

    @Column(unique = true)
    private String id;

    // Other fields
    private String status;
    
    private String email;

}
