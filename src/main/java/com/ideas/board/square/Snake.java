package com.ideas.board.square;

public class Snake extends SpecialSquare{

	
	public Snake(int from,int to ) {
		this.to=to;
		this.from=from;
	}

	public int move()
	{
		System.out.println("Snake detected .Player moved from -->"+from+" to -->"+to);
		return to;
	}
	
	@Override
	public String toString() {
		return "SNAKE   [from=" + from + ", to=" + to + "]";
	}
	
}
