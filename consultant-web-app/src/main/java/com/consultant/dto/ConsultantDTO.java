package com.consultant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultantDTO {
	
	private Long consultantId;
    private String name;
    private int age;
    private String phoneNo;
    private String cv;

}
