package com.ideas.board.square;

public class Default extends Square{

	

	public Default(int from) {
		this.from=from;
	}

	public int move() {
		to=from+to;
		System.out.println("Moved from ::"+from+" to ::"+to);
		return to;
	}

	@Override
	public String toString() {
		return "Default [from=" + from + "]";
	}

	 
}
