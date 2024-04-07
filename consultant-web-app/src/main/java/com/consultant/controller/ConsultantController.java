package com.consultant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultant.dto.ConsultantDTO;
import com.consultant.service.ConsultantService;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {
	
	@Autowired
	private ConsultantService consultantSer;
	
	@PutMapping("/updateConsultant")
	public ResponseEntity<ConsultantDTO> updateConsultant(@RequestBody ConsultantDTO consultantReq) {
		return new ResponseEntity<ConsultantDTO>(consultantSer.updateConsultant(consultantReq), HttpStatus.OK);
	}

}
