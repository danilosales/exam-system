package br.com.danilosales.healthcare.service.exception;

public class HealthcareInstitutionAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HealthcareInstitutionAlreadyExistException(String message) {
		super(message);
	}
	
}
