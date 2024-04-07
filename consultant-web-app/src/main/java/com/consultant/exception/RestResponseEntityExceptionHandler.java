package com.consultant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.consultant.payload.response.ErrorRes;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorRes> handleCustomeException(CustomException exception) {
		new ErrorRes();
		return new ResponseEntity<>(ErrorRes.builder().errorMessage(exception.getMessage()).errorCode(exception.getErrorCode()).build(), HttpStatus.valueOf(exception.getStatus()));
	}

}
