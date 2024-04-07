package com.consultant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "web_app_statistics")
public class WebAppStatistics {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name ="total_consultants")
    private int totalConsultants;
	
	@Column(name ="total_clients")
    private int totalClients;
	
	@Column(name ="total_session_booked")
    private int totalSessionsBooked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalConsultants() {
		return totalConsultants;
	}

	public void setTotalConsultants(int totalConsultants) {
		this.totalConsultants = totalConsultants;
	}

	public int getTotalClients() {
		return totalClients;
	}

	public void setTotalClients(int totalClients) {
		this.totalClients = totalClients;
	}

	public int getTotalSessionsBooked() {
		return totalSessionsBooked;
	}

	public void setTotalSessionsBooked(int totalSessionsBooked) {
		this.totalSessionsBooked = totalSessionsBooked;
	}

	public WebAppStatistics() {
		super();
	}

	public WebAppStatistics(Long id, int totalConsultants, int totalClients, int totalSessionsBooked) {
		super();
		this.id = id;
		this.totalConsultants = totalConsultants;
		this.totalClients = totalClients;
		this.totalSessionsBooked = totalSessionsBooked;
	}
    
    

}
