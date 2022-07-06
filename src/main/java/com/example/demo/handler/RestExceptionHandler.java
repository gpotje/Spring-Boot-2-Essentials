package com.example.demo.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.BadRequestExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {

		return new ResponseEntity<>(BadRequestExceptionDetails.builder().timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value()).title("").details(bre.getMessage())
				.developerMessage(bre.getClass().getName()).build(), HttpStatus.BAD_REQUEST);

	}
}
