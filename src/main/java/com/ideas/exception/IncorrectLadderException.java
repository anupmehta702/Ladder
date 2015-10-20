package com.ideas.exception;

public class IncorrectLadderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String error="";
	
	public IncorrectLadderException(String error)
	{
		this.error=error;
		System.out.println("Incorrect Ladder inputs due to :: "+error);
	}

}
