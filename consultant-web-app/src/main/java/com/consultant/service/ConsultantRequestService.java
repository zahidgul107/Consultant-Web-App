package com.consultant.service;

import java.util.List;

import com.consultant.dto.ConsultantRequestDTO;
import com.consultant.payload.response.ConsultantReqResponse;

public interface ConsultantRequestService {

	ConsultantReqResponse consultantReq(ConsultantRequestDTO consultantReqDto);
	List<ConsultantReqResponse> getAllConsultantRequests(int page, int pageSize);
	void updateConsultantRequestStatus(Long requestId, String status);

}
