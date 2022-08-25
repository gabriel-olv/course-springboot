package br.com.gabrieldeoliveira.udemycoursejpoo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gabrieldeoliveira.udemycoursejpoo.services.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		Integer status = HttpStatus.NOT_FOUND.value();
		String error = "Resource not found";
		String path = request.getRequestURI();
		
		Error err = new StandardError(Instant.now(), status, error, path, e.getMessage());
		
		return ResponseEntity.status(status).body(err);
	}
}
