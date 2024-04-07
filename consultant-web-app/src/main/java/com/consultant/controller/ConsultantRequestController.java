package com.consultant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consultant.dto.ConsultantRequestDTO;
import com.consultant.payload.response.ConsultantReqResponse;
import com.consultant.service.ConsultantRequestService;

@RestController
@RequestMapping("/consultantReq")
public class ConsultantRequestController {

	@Autowired
	private ConsultantRequestService consultantReqSer;

	// API to add consultant requests
	@PostMapping("/addConsultantReq")
	public ResponseEntity<ConsultantReqResponse> consultantReq(@RequestBody ConsultantRequestDTO consultantReqDto) {
		return new ResponseEntity<ConsultantReqResponse>(consultantReqSer.consultantReq(consultantReqDto),
				HttpStatus.CREATED);
	}

	// API to retrieve all consultant requests
	@GetMapping("/getAllConsultantReq")
	public ResponseEntity<?> getAllConsultantRequests() {
		return ResponseEntity.ok(consultantReqSer.getAllConsultantRequests());
	}

	// API to approve or reject a consultant request by ID
	@PutMapping("/{requestId}")
	public ResponseEntity<?> updateConsultantRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
		consultantReqSer.updateConsultantRequestStatus(requestId, status);
		return ResponseEntity.ok().build();
	}

}
