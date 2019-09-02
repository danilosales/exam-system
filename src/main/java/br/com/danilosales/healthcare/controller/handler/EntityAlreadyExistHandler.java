package br.com.danilosales.healthcare.controller.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.danilosales.healthcare.dto.ErrorResponse;
import br.com.danilosales.healthcare.service.exception.ExamAlreadyExistException;
import br.com.danilosales.healthcare.service.exception.HealthcareInstitutionAlreadyExistException;

@RestControllerAdvice
public class EntityAlreadyExistHandler {
	
	@ExceptionHandler({ HealthcareInstitutionAlreadyExistException.class, ExamAlreadyExistException.class })
	public ResponseEntity<ErrorResponse> healthcareInstitutionAlreadyExistException(Exception e) {
		
		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(LocalDateTime.now());
		error.getMessages().add(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
