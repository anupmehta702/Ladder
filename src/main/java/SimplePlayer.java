
public class SimplePlayer {

	String name;
	int currentPosition=1;
	SimpleBoard board=SimpleBoard.INSTANCE;
	
	public SimplePlayer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void move(int diceNumber)
	{
		this.currentPosition=board.move(diceNumber, this.currentPosition);
	}
		
}
