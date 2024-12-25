package com.jindal.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8626786699261969315L;

	public ResourceNotFoundException() {
		super("Resource not found on server !!!");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
