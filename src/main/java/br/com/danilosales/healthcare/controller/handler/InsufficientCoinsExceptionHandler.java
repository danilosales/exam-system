package br.com.danilosales.healthcare.controller.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.danilosales.healthcare.dto.ErrorResponse;
import br.com.danilosales.healthcare.service.exception.InsufficientCoinsException;

@RestControllerAdvice
public class InsufficientCoinsExceptionHandler {

	@ExceptionHandler({ InsufficientCoinsException.class })
	public ResponseEntity<ErrorResponse> insufficientCoins(InsufficientCoinsException e) {
		
		ErrorResponse error = new ErrorResponse();
		error.setCode(HttpStatus.FORBIDDEN.value());
		error.setTimestamp(LocalDateTime.now());
		error.getMessages().add(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}
}

