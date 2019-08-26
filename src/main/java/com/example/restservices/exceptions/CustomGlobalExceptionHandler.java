package com.example.restservices.exceptions;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//MethodArgumentNotValidException
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"In MethodArgumentNotValidException from GlobalExceptionHandler", 
				ex.getMessage());
		
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	//HttpRequestMethodNotSupportedException
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"Method not allowed", 
				ex.getMessage());
		
		return new ResponseEntity<>(customErrorDetails,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	//UserNameNotFoundExcpetion
	@ExceptionHandler(UserNameNotFoundException.class)
	protected final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex, WebRequest request){
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), 
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(customErrorDetails,HttpStatus.NOT_FOUND);
	}
	
	//ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
protected final ResponseEntity<Object> handleUserNameNotFoundException(ConstraintViolationException ex, WebRequest request){
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), 
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}	
	
	
}