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
@Table(name = "consultant_request")
public class ConsultantRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

	@Column(name ="name")
    private String name;
 
	@Column(name ="status")
    private String status;
    
    @Column(name = "e_mail", length = 50)
    private String email;
    
}
