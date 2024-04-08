package com.consultant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consultant.dto.ConsultantDTO;
import com.consultant.payload.response.ConsultantResponse;
import com.consultant.service.ConsultantService;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

	@Autowired
	private ConsultantService consultantSer;

	// API to update consultant details
	@PutMapping("/updateConsultant")
	public ResponseEntity<ConsultantDTO> updateConsultant(@RequestBody ConsultantDTO consultantReq) {
		return new ResponseEntity<ConsultantDTO>(consultantSer.updateConsultant(consultantReq), HttpStatus.OK);
	}

	// API to retrieve page wise all consultant
	@GetMapping("/getAllConsultant")
	public ResponseEntity<?> getAllConsultantRequests(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pageSize) {
		return ResponseEntity.ok(consultantSer.getAllConsultant(page, pageSize));
	}
	
	// API to get details of a specific consultant by their name or job role (page wise)
	@GetMapping("/{search}")
    public ResponseEntity<List<ConsultantResponse>> getConsultantDetails(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pageSize, @PathVariable String search) {
        List<ConsultantResponse> consultants = consultantSer.getConsultantsByNameOrJobRole(page, pageSize, search);
        return ResponseEntity.ok(consultants);
    }

}
