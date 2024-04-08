package com.consultant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultant.dto.StatisticsDTO;
import com.consultant.service.StatisticsService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	
	@Autowired
    private StatisticsService statisticsSer;

	// API to get statistics
    @GetMapping
    public ResponseEntity<StatisticsDTO> getWebAppStatistics() {
        StatisticsDTO statistics = statisticsSer.getWebAppStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

}
