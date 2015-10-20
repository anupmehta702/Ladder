package com.ideas.player;

import com.ideas.board.Board;
import com.ideas.exception.WinConditionAttainedException;
import com.ideas.service.BoardService;
import com.ideas.service.PlayService;
import com.ideas.service.impl.ServiceFactoryImpl;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayServiceImpl {

	PlayService playService=ServiceFactoryImpl.getPlayServiceInstance();
	Board board=Board.getInstance();
	BoardService boardService =ServiceFactoryImpl.getBoardServiceInstance(); 
	@Test
	public void testPlayMethod()
	{
		Player one =new Player("ONE");
		int diceNumber=3;
		board.initialize();
		boardService.addLadder(3, 4);
		boardService.addSnake(5, 2);
		playService.play(diceNumber, one);
		assertTrue("Failure for ladder",one.getSquare().getFrom()==4);
		
		diceNumber=1;
		playService.play(diceNumber, one);
		assertTrue("For snake",one.getSquare().getFrom()==2);
		
		
	}
	@Test(expected=WinConditionAttainedException.class)
	public void testPlayFOrWinningCondition()
	{
		Player one =new Player("ONE");
		int diceNumber=3;
		board.initialize();
		boardService.addLadder(3, 9);
		playService.play(diceNumber, one);

		diceNumber=3;
		playService.play(diceNumber, one);
	}
	
}
