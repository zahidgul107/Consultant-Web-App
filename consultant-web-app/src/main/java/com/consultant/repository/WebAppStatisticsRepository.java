package com.consultant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultant.entity.WebAppStatistics;

public interface WebAppStatisticsRepository extends JpaRepository<WebAppStatistics, Long> {

}
