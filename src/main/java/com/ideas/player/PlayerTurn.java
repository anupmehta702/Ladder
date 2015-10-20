package com.ideas.player;

public final class PlayerTurn {
	
	private int sequenceNumber=1;
	private int turnNumber=1;
	public static  int noOfPlayers=2;
	private  boolean isThereAWinner=false;
	
	private static PlayerTurn INSTANCE=new PlayerTurn();
	
	public static  PlayerTurn getInstance(){
		return INSTANCE;
	}
	private PlayerTurn()
	{
	}
	
	public boolean isThereAWinner() {
		return isThereAWinner;
	}
	public void setThereAWinner(boolean isThereAWinner) {
		this.isThereAWinner = isThereAWinner;
	}
	public int getTurnNumber() {
		return turnNumber;
	}
	
	public int incrementTurn()
	{
		turnNumber++;
		if(turnNumber>noOfPlayers)
			turnNumber=(turnNumber)%(noOfPlayers);
		return turnNumber;
	}
	
	public int initializeSequenceNumber() {
		
		
		if(sequenceNumber>noOfPlayers)
			sequenceNumber=sequenceNumber%noOfPlayers;//TODO throw exception PlayerLimitExceededException
		return sequenceNumber++;
		
	}
	
	
	
	public static void main(String[] args) {
		PlayerTurn pt=new PlayerTurn();
		System.out.println(pt.initializeSequenceNumber());
		System.out.println(pt.initializeSequenceNumber());
		System.out.println(pt.initializeSequenceNumber());
		System.out.println(pt.initializeSequenceNumber());
		System.out.println("Turn Number");
		
		System.out.println(pt.getTurnNumber());
		pt.incrementTurn();
		System.out.println(pt.getTurnNumber());
		pt.incrementTurn();
		System.out.println(pt.getTurnNumber());
		pt.incrementTurn();
		System.out.println(pt.getTurnNumber());
		pt.incrementTurn();
	}

}
