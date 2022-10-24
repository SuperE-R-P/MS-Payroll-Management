package com.esprit.microservices.exceptions;

public class InvalidPayrollReferenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidPayrollReferenceException(String errorMessage) {
		super(errorMessage);
	}

}