package com.consultant.service;

import java.util.List;

import com.consultant.dto.ConsultantDTO;
import com.consultant.payload.response.ConsultantResponse;

public interface ConsultantService {

	ConsultantDTO updateConsultant(ConsultantDTO consultantReq);
	List<ConsultantResponse> getAllConsultant();

}
