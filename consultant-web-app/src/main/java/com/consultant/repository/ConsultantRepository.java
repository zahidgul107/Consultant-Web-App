package com.consultant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consultant.entity.Consultant;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

}
