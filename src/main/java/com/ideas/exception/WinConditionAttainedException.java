package com.ideas.exception;


public class WinConditionAttainedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String playerName="";
	
	public WinConditionAttainedException(String playerName) {
		super();
		this.playerName = playerName;
	}
	
	

}
