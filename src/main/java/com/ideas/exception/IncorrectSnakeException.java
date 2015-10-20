package com.ideas.exception;

public class IncorrectSnakeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String error="";
	
	public IncorrectSnakeException(String error)
	{
		this.error=error;
		System.out.println("Incorrect Snake inputs due to :: "+error);
	}

}
