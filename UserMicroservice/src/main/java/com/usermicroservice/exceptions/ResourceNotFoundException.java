package com.usermicroservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	
	//extra properties you want to manage
	public ResourceNotFoundException ()
	{
		super("Resource not found on Server  ...!!");
	}
	public ResourceNotFoundException (String message)
	{
		super(message);
	}
}
