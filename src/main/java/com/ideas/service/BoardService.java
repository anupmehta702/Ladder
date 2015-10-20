package com.ideas.service;

public interface BoardService {

	public static int maxNoOfSnakes=7;
	public static int maxNoOfLadders=7;
	
	void addSnake(int from,int to);
	void addLadder(int from ,int to);
	void addDefault(int from );
	void setNoOfSqaureOnBoard(int size);
	 void printAll();
}
