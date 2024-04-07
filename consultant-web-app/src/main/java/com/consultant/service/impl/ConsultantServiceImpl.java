package com.consultant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultant.dto.ConsultantDTO;
import com.consultant.entity.Consultant;
import com.consultant.exception.CustomException;
import com.consultant.repository.ConsultantRepository;
import com.consultant.service.ConsultantService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	private ConsultantRepository consultantRepo;
	@Autowired
    private ObjectMapper objectMapper;

	@Override
	public ConsultantDTO updateConsultant(ConsultantDTO consultantReq) {
		Consultant consultant = consultantRepo.findById(consultantReq.getConsultantId())
				.orElseThrow(() -> new CustomException(
						"Consultant not found by given Id: " + consultantReq.getConsultantId(), "CONSULTANT_NOT_FOUND",
						404));
		
		// Map data from DTO to entity using ObjectMapper
        try {
			objectMapper.updateValue(consultant, consultantReq);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
        consultant = consultantRepo.save(consultant);
		return objectMapper.convertValue(consultant, ConsultantDTO.class);
	}

}
