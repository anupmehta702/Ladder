package com.ideas.player;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ideas.board.Board;
import com.ideas.board.square.Ladder;
import com.ideas.board.square.Snake;
import com.ideas.board.square.Square;
import com.ideas.exception.IncorrectLadderException;
import com.ideas.exception.IncorrectSnakeException;
import com.ideas.service.BoardService;
import com.ideas.service.impl.ServiceFactoryImpl;


public class TestBoardServiceImpl {

	BoardService boardService=ServiceFactoryImpl.getBoardServiceInstance();
	Board board=Board.getInstance();
	
	public void initializeBoard()
	{
		board.setMaxSize(10);
		board.initialize();
	}
	@Test
	public void TestBoardInitialize()
	{
		initializeBoard();
		assertTrue(board.getSquare(10).getFrom()==10);
		assertTrue(board.getSquare(11)==null);
	}

	
	@Test
	public void TestAddSnake()
	{
		initializeBoard();
		boardService.addSnake(5, 3);
		Square snakeSquare=new Snake(5, 3);
		assertTrue(board.getSquare(5).getFrom()==snakeSquare.getFrom());
		assertTrue(board.getSquare(5).getTo()==snakeSquare.getTo());
	}
	
	@Test
	public void TestAddLadder()
	{
		initializeBoard();
		boardService.addLadder(3,4);
		Square ladderSquare=new Ladder(3, 4);
		assertTrue(board.getSquare(3).getFrom()==ladderSquare.getFrom());
		assertTrue(board.getSquare(3).getTo()==ladderSquare.getTo());
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
