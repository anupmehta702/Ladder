
public class SimpleSquare {

	int currentNumber;
	int to;
	String type;
	public SimpleSquare(int currentNumber) {
		super();
		this.currentNumber = currentNumber;
		this.type="Simple";
	}
	
	public int getCurrentNumber() {
		return currentNumber;
	}
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
