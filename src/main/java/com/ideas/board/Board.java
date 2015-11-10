package com.ideas.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ideas.board.square.Default;
import com.ideas.board.square.Ladder;
import com.ideas.board.square.Snake;
import com.ideas.board.square.Square;
import com.ideas.player.Player;

public final class Board {

	private  final Map<Integer,Square> boardMap=new HashMap<Integer,Square>();
	private int MAX_SIZE=10;
	private static final Board INSTANCE=new Board(10);
	private final List<Player> playerList=new ArrayList<Player>();
	
	public  static Board getInstance()
	{
		return INSTANCE;
	}
	public Board(int MAX_SIZE) {
		super();
		this.MAX_SIZE = MAX_SIZE;
		initialize();
	}
	public void initialize()
	{
		for(int i=1;i<=MAX_SIZE;i++)
		{
			 Square defaultSquare=new Default(i);
			boardMap.put(i, defaultSquare);
		}
	}
	public void subscribePlayer(Player p)
	{
		playerList.add(p);
	}
	public void locateAllPlayers()
	{
		System.out.println("Current location of all players ::");
		for(Player p : playerList)
		{
			System.out.print(p);
		}
	}
	
	public void addSquare(Square square)
	{
		boardMap.put(square.getFrom(), square);
	}
	public Square getSquare(int squareNumber) 
	{
		Square square=boardMap.get(squareNumber);
		Square clonedSquare;
		if(square!=null)
		{
			try {
				clonedSquare = (Square)square.clone();
				return clonedSquare;
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	void removeSquareProperty(int squareNumber)
	{
		Square square=boardMap.get(squareNumber);
		if (!(square instanceof Default)) {
			boardMap.put(squareNumber,new Default(squareNumber) );
		}
	}
	public void printAll()
	{
		for(int i=1;i<=MAX_SIZE;i++)
		{
			System.out.println(boardMap.get(i));
		}
	}
	public  boolean doesSquareExist(int destinationNo)
	{
		if(boardMap.size()>= destinationNo)
			return true;
		else
			return false;
	}
	
	public boolean isSquareANonDefault(Square square)
	{
		if(square instanceof Snake || square instanceof Ladder){
			return true;
		}
		else
		{
			return false;
		}
	}
	public void setMaxSize(int size)
	{
		this.MAX_SIZE=size;
	}
	public int getMaxSize()
	{
		return MAX_SIZE;
	}
	
}
