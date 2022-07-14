package com.example.demo.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.BadRequestExceptionDetails;
import com.example.demo.exception.ValidationExceptionDetails;


@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {

		return new ResponseEntity<>(BadRequestExceptionDetails.builder().timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value()).title("").details(bre.getMessage())
				.developerMessage(bre.getClass().getName()).build(), HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exe) {

		 List<FieldError> fieldError = exe.getBindingResult().getFieldErrors();
		 String fields = fieldError.stream().map(FieldError::getField).collect(Collectors.joining(" , "));
		 String fieldsMessage = fieldError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" , "));
	
		return new ResponseEntity<>(ValidationExceptionDetails.builder().
				timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("BadRequest Exception, Invalid Fields")
				.details("Check the field(S) errors")
				.fields(fields)
				.fieldsMessage(fieldsMessage)
				.developerMessage(exe.getClass().getName()).build(), HttpStatus.BAD_REQUEST);

	}
}
