
package com.ideas.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ideas.board.square.Square;
import com.ideas.exception.WinConditionAttainedException;
import com.ideas.service.PlayService;
import com.ideas.service.impl.ServiceFactoryImpl;

public class PlayerWithThreadsImpl extends Player implements Runnable {

	private String name="Default";
	private Square square;
	private int sequenceNumber=0;
	private PlayService playService=ServiceFactoryImpl.getPlayServiceInstance();
	private PlayerTurn playerTurn=PlayerTurn.getInstance();
	private Random r = new Random();
	private List<Square> playerHistory=new ArrayList<Square>();
	
	public PlayerWithThreadsImpl(String name) {
		super(name);
		this.setName(name);
		this.square=playService.initializePlayer(this);
		sequenceNumber=playerTurn.initializeSequenceNumber();
		playerHistory.add(square);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
		addPatientHistory(square);
	}
	

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	
	public void rollDice() throws WinConditionAttainedException
	{
		System.out.println("Player :: "+this.getName()+" 's turn");
		int diceNumber = r.nextInt(6-1) + 1;
		System.out.println("Dice rolled to number ::"+diceNumber);
		playService.play(diceNumber, this);

	}
	public void addPatientHistory(Square square)
	{
		playerHistory.add(square);
	}
	
	public void printHistory()
	{	System.out.println();
		System.out.print("Player"+name+"'s moves [");
		for(Square square : playerHistory)
		{
			System.out.print(square.getFrom()+"--> ");
		}
		System.out.println(" ]");
	}

	
	@Override
	public void run() {
		while(!playerTurn.isThereAWinner()){
			try{
				synchronized(playerTurn)
				{
	
					if(playerTurn.getTurnNumber()==this.sequenceNumber)
					{
						System.out.println("Player :: "+this.name+" 's turn");
						try{
							rollDice();
						}catch (WinConditionAttainedException e) {
							System.out.println();
							System.out.println("Player :: "+this.name+" is the WINNER !!!! .Aborting all other player movements");
							printHistory();
							playerTurn.setThereAWinner(true);
							playService.locateAllPlayers();
							
						}
	
						playerTurn.incrementTurn();
						playerTurn.notifyAll();						
					}
					else
					{
						System.out.println("Player :: "+this.name+" waiting");
						playerTurn.wait();				
					}
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	@Override
	public String toString() {
		return "Player [name=" + name + ", square=" + square.getFrom()
				+ ", sequenceNumber=" + sequenceNumber 
				+", turnNumber="+ playerTurn.getTurnNumber()
				+ "]";
	}

	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sequenceNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerWithThreadsImpl other = (PlayerWithThreadsImpl) obj;
		if (sequenceNumber != other.sequenceNumber)
			return false;
		return true;
	}

	
}
