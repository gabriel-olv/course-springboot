package br.com.gabrieldeoliveira.udemycoursejpoo.resources.exceptions;

import java.time.Instant;

public class StandardError extends Error {
	private static final long serialVersionUID = 1L;

	private String message;

	public StandardError() {
	}

	public StandardError(Instant timestamp, Integer status, String error, String path, String message) {
		super(timestamp, status, error, path);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
