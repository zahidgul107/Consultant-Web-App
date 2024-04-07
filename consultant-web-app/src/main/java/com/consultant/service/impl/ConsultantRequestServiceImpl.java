package com.consultant.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultant.dto.ConsultantRequestDTO;
import com.consultant.entity.Consultant;
import com.consultant.entity.ConsultantRequest;
import com.consultant.exception.CustomException;
import com.consultant.payload.response.ConsultantReqResponse;
import com.consultant.repository.ConsultantRepository;
import com.consultant.repository.ConsultantRequestRepository;
import com.consultant.service.ConsultantRequestService;

@Service
public class ConsultantRequestServiceImpl implements ConsultantRequestService {

	@Autowired
	private ConsultantRequestRepository consultantReqRepo;
	@Autowired
	private ConsultantRepository consultantRepo;

	@Override
	public ConsultantReqResponse consultantReq(ConsultantRequestDTO consultantReqDto) {

		// Condition for checking duplicate of email
		if (consultantReqRepo.existsByEmail(consultantReqDto.getEmail())) {
			throw new CustomException("Email already exists!", "DUPLICATE_EMAIL", 400);
		}

		ConsultantRequest consultantReq = ConsultantRequest.builder().name(consultantReqDto.getName())
				.email(consultantReqDto.getEmail()).status("Requested").build();

		consultantReq = consultantReqRepo.save(consultantReq);

		return ConsultantReqResponse.builder().email(consultantReq.getEmail()).name(consultantReq.getName())
				.requestId(consultantReq.getRequestId()).status(consultantReq.getStatus()).build();
	}

	@Override
	public List<ConsultantReqResponse> getAllConsultantRequests() {
		List<ConsultantRequest> consultantReqList = consultantReqRepo.findAll();
		return consultantReqList.stream().map(n -> ConsultantReqResponse.builder().email(n.getEmail()).name(n.getName())
				.requestId(n.getRequestId()).status(n.getStatus()).build()).collect(Collectors.toList());
	}

	@Override
	public void updateConsultantRequestStatus(Long requestId, String status) {
		
		// Consultant request not found check
		ConsultantRequest consultantReq = consultantReqRepo.findById(requestId)
				.orElseThrow(() -> new CustomException("Consultant Request not found by given requestId: " + requestId,
						"CONSULTANT_REQUEST_NOT_FOUND", 404));
		
		// Check if status is already updated by Admin
		if (!"Requested".equals(consultantReq.getStatus())) {
			throw new CustomException("Consultant Request Status already updated!", "STATUS_ALREADY_UPDATED", 400);
		}
		consultantReq.setStatus(status);
		Consultant consultant = Consultant.builder().name(consultantReq.getName()).email(consultantReq.getEmail()).build();
		consultantRepo.save(consultant);
		consultantReqRepo.save(consultantReq);
	}

}