package com.consultant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.consultant.entity.Consultant;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

	Page<Consultant> findByNameContainingIgnoreCaseOrJobRoleContainingIgnoreCase(String name, String jobRole, Pageable pageable);

}
