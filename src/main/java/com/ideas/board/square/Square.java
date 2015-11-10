package com.ideas.board.square;

public abstract class Square implements Cloneable {

	protected int from=1;
	protected int to=1;
	protected boolean isSquareSpecial=false;
	
	public abstract int move();
	
	public int getFrom() {
		return from;
	}
	protected void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	

	public boolean isSquareSpecial() {
		return isSquareSpecial;
	}

	protected void setSquareSpecial(boolean isSquareSpecial) {
		this.isSquareSpecial = isSquareSpecial;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	
}
