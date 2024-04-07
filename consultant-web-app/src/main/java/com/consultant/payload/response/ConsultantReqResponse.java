package com.consultant.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultantReqResponse {
	
	private Long requestId;
	private String name;
	private String email;
	private String status;
}
