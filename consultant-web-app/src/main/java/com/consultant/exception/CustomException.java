package com.consultant.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 5578324544115260230L;
	String errorCode;
	int status;
	public CustomException(String message, String errorCode, int status) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
	}
	
	

}
