package com.consultant.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.consultant.dto.ConsultantRequestDTO;
import com.consultant.entity.Consultant;
import com.consultant.entity.ConsultantRequest;
import com.consultant.entity.WebAppStatistics;
import com.consultant.exception.CustomException;
import com.consultant.payload.response.ConsultantReqResponse;
import com.consultant.repository.ConsultantRepository;
import com.consultant.repository.ConsultantRequestRepository;
import com.consultant.repository.WebAppStatisticsRepository;
import com.consultant.service.ConsultantRequestService;

@Service
public class ConsultantRequestServiceImpl implements ConsultantRequestService {

	@Autowired
	private ConsultantRequestRepository consultantReqRepo;
	@Autowired
	private ConsultantRepository consultantRepo;
	@Autowired
	private WebAppStatisticsRepository statisticRepo;

	/**
	 * Creates a new consultant request based on the provided DTO.
	 * 
	 * @param consultantReqDto The DTO containing the details of the consultant request.
	 * @return The response containing the details of the newly created consultant request.
	 * @throws CustomException If the email already exists.
	 */
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

	/**
	 * Retrieves a list of consultant requests in a paginated manner.
	 * 
	 * @param page     The page number.
	 * @param pageSize The number of items per page.
	 * @return A list of consultant request responses.
	 */
	@Override
	public List<ConsultantReqResponse> getAllConsultantRequests(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page -1, pageSize);
		Page<ConsultantRequest> consultantReqList = consultantReqRepo.findAll(pageable);
		return consultantReqList.stream().map(n -> ConsultantReqResponse.builder().email(n.getEmail()).name(n.getName())
				.requestId(n.getRequestId()).status(n.getStatus()).build()).collect(Collectors.toList());
	}

	/**
	 * Updates the status of a consultant request and updates the total number of consultants in the web app statistics.
	 * 
	 * @param requestId The ID of the consultant request to update.
	 * @param status    The new status of the consultant request.
	 * @throws CustomException If the consultant request is not found or if the status is already updated.
	 */
	@Override
	public void updateConsultantRequestStatus(Long requestId, String status) {
		
		// Checking condition for Consultant request not found
		ConsultantRequest consultantReq = consultantReqRepo.findById(requestId)
				.orElseThrow(() -> new CustomException("Consultant Request not found by given requestId: " + requestId,
						"CONSULTANT_REQUEST_NOT_FOUND", 404));
		
		// Checking condition if the status is already updated.
		if (!"Requested".equals(consultantReq.getStatus())) {
			throw new CustomException("Consultant Request Status already updated!", "STATUS_ALREADY_UPDATED", 400);
		}
		consultantReq.setStatus(status);
		Consultant consultant = Consultant.builder().name(consultantReq.getName()).email(consultantReq.getEmail()).build();
		List<WebAppStatistics> statisticsList = statisticRepo.findAll();
		
		WebAppStatistics statistics = null;
		// Condition for checking if WebStatistics is already saved
		if (statisticsList.isEmpty()) {
            statistics = new WebAppStatistics();
            statistics.setTotalConsultants(1);
        } else {
            statistics = statisticsList.get(0);
            statistics.setTotalConsultants(statistics.getTotalConsultants() + 1);
        }
        statisticRepo.save(statistics);
		// Saving Consultant when status is updated
		consultantRepo.save(consultant);
		// Saving updated Consultant Request
		consultantReqRepo.save(consultantReq);
	}

}
