package com.consultant.payload.response;

import com.consultant.dto.ConsultantDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultantResponse {
	
	private Long consultantId;
    private String name;
    private int age;
    private String phoneNo;
    private String cv;
    private String email;

}
