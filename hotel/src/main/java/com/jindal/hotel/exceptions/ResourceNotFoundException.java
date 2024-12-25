package com.jindal.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException{


	private static final long serialVersionUID = -5531797125796188390L;

	public ResourceNotFoundException() {
		super("Resource not found on server !!!");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
