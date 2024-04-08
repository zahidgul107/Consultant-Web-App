package com.consultant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultant.dto.StatisticsDTO;
import com.consultant.entity.WebAppStatistics;
import com.consultant.repository.WebAppStatisticsRepository;
import com.consultant.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private WebAppStatisticsRepository statisticRepo;

	@Override
	public StatisticsDTO getWebAppStatistics() {
		List<WebAppStatistics> statisticsList = statisticRepo.findAll();
		return new StatisticsDTO(statisticsList.get(0).getTotalConsultants(), statisticsList.get(0).getTotalClients(),
				statisticsList.get(0).getTotalSessionsBooked());
	}

}
