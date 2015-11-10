package com.ideas.service.impl;

import com.ideas.board.Board;
import com.ideas.board.square.Default;
import com.ideas.board.square.Ladder;
import com.ideas.board.square.Snake;
import com.ideas.board.square.Square;
import com.ideas.service.BoardService;
import com.ideas.validation.Validator;

public class BoardServiceImpl implements BoardService{

	int noOfSnakes=0;
	int noOfLadders=0;
	
	Board board=Board.getInstance();
	public BoardServiceImpl()
	{
		initializeTheBoard();
	}
	
	@Override
	public void addSnake(int from, int to) {
		Validator.validateSnakeInputs(from, to, board.getMaxSize());
		Square snake=new Snake(from,to);
		board.addSquare(snake);
	}

	@Override
	public void addLadder(int from, int to) {
		Validator.validateLadderInputs(from, to, board.getMaxSize());
		Ladder ladder=new Ladder(from,to);
		board.addSquare(ladder);

	}

	@Override
	public void addDefault(int from) {
		Default defaultSquare =new Default(from);
		board.addSquare(defaultSquare);
	}

	public void setNoOfSqaureOnBoard(int size)
	{
		board.setMaxSize(size);
	}
	
	public void initializeTheBoard()
	{
		board.initialize();
	}
	public void printAll()
	{
		board.printAll();
	}
}
