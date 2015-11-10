import java.util.HashMap;
import java.util.Map;



public class SimpleBoard {

	private  final Map<Integer,SimpleSquare> boardMap=new HashMap<Integer,SimpleSquare>();
	
	public static final SimpleBoard INSTANCE=new SimpleBoard();
	
	private SimpleBoard()
	{
		for(int i=1;i<=64;i++)
		{
			boardMap.put(i, new SimpleSquare(i) );
		}
	}
	
	public void addSpecialSquare(int number,int to,String type)
	{
		SimpleSquare sq=new SimpleSquare(number);	
		sq.setTo(to);
		sq.setType(type);
		boardMap.put(number,sq );
	}
	
	public int move(int steps,int currentNumber)
	{
		int moveTo=currentNumber+steps;
		SimpleSquare sq=boardMap.get(moveTo);
		while(!sq.getType().equalsIgnoreCase("simple"))
		{
			sq=boardMap.get(sq.getTo());
		}
		return sq.currentNumber;
	}
}
