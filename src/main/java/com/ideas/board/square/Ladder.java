package com.ideas.board.square;

public class Ladder extends SpecialSquare {
	
	public Ladder(int from ,int to) {
		this.to=to;
		this.from=from;
	}
	public int move()
	{
		System.out.println("Ladder detected .Player moved from -->"+from+" to -->"+to);
		return to;
	}

	@Override
	public String toString() {
		return "LADDER  [from=" + from + ", to=" + to + "]";
	}

}
