package com.consultant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultant.entity.ConsultantRequest;

public interface ConsultantRequestRepository extends JpaRepository<ConsultantRequest, Long> {

	boolean existsByEmail(String email);

}
