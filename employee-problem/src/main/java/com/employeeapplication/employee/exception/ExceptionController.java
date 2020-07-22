package com.employeeapplication.employee.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Object> handleInvalidInput(InvalidInputException e){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
