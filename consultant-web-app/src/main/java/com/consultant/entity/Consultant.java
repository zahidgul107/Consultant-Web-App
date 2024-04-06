package com.consultant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultant")
public class Consultant {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultantId;

    private String name;
    private int age;
    private String phoneNo;
    private String cv;
    private String status;
    
    

}
