package com.ideas.player;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ideas.board.Board;
import com.ideas.exception.IncorrectLadderException;
import com.ideas.exception.IncorrectSnakeException;
import com.ideas.service.BoardService;
import com.ideas.service.impl.ServiceFactoryImpl;

public class TestValidator {

	BoardService boardService=ServiceFactoryImpl.getBoardServiceInstance();
	Board board=Board.getInstance();
	
	public void initializeBoard()
	{
		board.setMaxSize(10);
		board.initialize();
	}

	@Test
	public void TestAddLadderException()
	{
		initializeBoard();
		try{
			boardService.addLadder(11,11);
		}catch(IncorrectLadderException e)
		{
			assertTrue(e.error.equals("Source / destination cannot be greater than max number on the board "));
		}
		try{
			boardService.addLadder(4,4);
		}catch(IncorrectLadderException e)
		{
			assertTrue(e.error.equals( "Source & destination  of a ladder cannot be equal"));
		}
		try{
			boardService.addLadder(5,3);
		}catch(IncorrectLadderException e)
		{
			assertTrue(e.error.equals("Source cannot be greater than destination for ladder"));
		}
		try{
			boardService.addLadder(1,3);
		}catch(IncorrectLadderException e)
		{
			assertTrue(e.error.equals("Source of a ladder cannot be equal to start square on the board"));
		}
		//boardService.addLadder(2,4);
	}

	@Test
	public void TestAddSnakeException()
	{
		initializeBoard();
		try{
			boardService.addSnake(11,11);
		}catch(IncorrectSnakeException e)
		{
			assertTrue(e.error.equals("Source / destination cannot be greater than max number on the board"));
		}
		try{
			boardService.addSnake(4,4);
		}catch(IncorrectSnakeException e)
		{
			assertTrue(e.error.equals( "Source & destination  of a snake cannot be equal"));
		}
		try{
			boardService.addSnake(5,10);
		}catch(IncorrectSnakeException e)
		{
			assertTrue(e.error.equals("Destination cannot be greater than source for snake"));
		}
		try{
			boardService.addSnake(10,3);
		}catch(IncorrectSnakeException e)
		{
			assertTrue(e.error.equals("Source of a snake cannot be equal to end square on the board"));
		}

	}

}
