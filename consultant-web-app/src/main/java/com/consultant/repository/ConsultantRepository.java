package com.consultant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consultant.entity.Consultant;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

	List<Consultant> findByNameContainingIgnoreCaseOrJobRoleContainingIgnoreCase(String name, String jobRole);

}
