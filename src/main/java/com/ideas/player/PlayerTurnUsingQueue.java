package com.ideas.player;

import java.util.PriorityQueue;
import java.util.Queue;

import com.ideas.exception.WinConditionAttainedException;

public class PlayerTurnUsingQueue {

	
	public static  int noOfPlayers=2;
	Queue<Player> playerQueue=new PriorityQueue<Player>(noOfPlayers);
	private static PlayerTurnUsingQueue INSTANCE=new PlayerTurnUsingQueue();
	private int sequenceNumber=1;
	private static boolean isThereAWinner=false;
	
	
	public static boolean isThereAWinner() {
		return isThereAWinner;
	}
	
	public static  PlayerTurnUsingQueue getInstance(){
		return INSTANCE;
	}
	private PlayerTurnUsingQueue()
	{
	}
	
	public void addAndQueueNewPlayer(String name)
	{
		Player p = new Player(name);
		registerPlayerForItsTurn(p);
	}
	
	public void registerPlayerForItsTurn(Player p)
	{
		p.setSequenceNumber(sequenceNumber++);
		playerQueue.add(p);
		
		
	}
	public void registerPlayerForItsNextTurn(Player p)
	{
		registerPlayerForItsTurn(p);
	}
	
	public void playUsersTurnWise()
	{
		while(!playerQueue.isEmpty() && !PlayerTurnUsingQueue.isThereAWinner){
			Player p=playerQueue.poll();
			try{
				p.rollDice();
				registerPlayerForItsNextTurn(p);
			}catch (WinConditionAttainedException e) {
				PlayerTurnUsingQueue.isThereAWinner=true;
			}
			
		}
		
	}
}
