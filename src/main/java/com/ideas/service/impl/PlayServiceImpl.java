package com.ideas.service.impl;

import com.ideas.board.Board;
import com.ideas.board.square.Square;
import com.ideas.exception.WinConditionAttainedException;
import com.ideas.player.Player;
import com.ideas.service.PlayService;

public class PlayServiceImpl implements PlayService {

	Board board=Board.getInstance();
	
	@Override
	public Square initializePlayer(Player player) {

		Square square=board.getSquare(1);
		board.subscribePlayer(player);
		return square;
	}
	
	@Override
	public void play(int diceNumber, Player p) {
		
		Square destinationSquare=move(diceNumber,p);
		p.setSquare(destinationSquare);
		while(destinationSquare!=null && destinationSquare.isSquareSpecial())
		{
			int newCurrentNumber=destinationSquare.move();
			destinationSquare=board.getSquare(newCurrentNumber);
			p.setSquare(destinationSquare);
		}
		
		
	}
	private Square move(int diceNumber,Player p)
	{
		p.getSquare().setTo(diceNumber);
		int destinationNo=p.getSquare().move();
		//winning condition
		if(destinationNo>=board.getMaxSize())
		{
			p.setSquare(board.getSquare(board.getMaxSize()));
			System.out.println();
			System.out.println("Player :: "+p.getName()+" has finished the game !!");
			p.printHistory();
			locateAllPlayers();
			System.out.println();
			throw new WinConditionAttainedException(p.getName());
		}
		if(board.doesSquareExist(destinationNo))
		{
			return board.getSquare(destinationNo);	
		}
		return null;
	}

	@Override
	public void locateAllPlayers() {
		board.locateAllPlayers();
	}

	

}
