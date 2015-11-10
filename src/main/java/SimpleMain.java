import java.io.InputStreamReader;
import java.util.Scanner;




public class SimpleMain {
	static SimpleBoard board=SimpleBoard.INSTANCE;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		enterSpecialSquareDetails(scanner);
		SimplePlayer player=enterPlayerDetails(scanner);
		rollDice(scanner, player);
		scanner.close();
	}
	
	public static void enterSpecialSquareDetails(Scanner scanner)
	{
		System.out.println("Enter special Squares (Ladder/Snake) on the board using format (from,to,Type) ::");
		while(true)
		{
			String input=scanner.nextLine();
			if(input.equalsIgnoreCase("exit"))
				break;
			else{
				String inputArr[]=input.split(" ");
				board.addSpecialSquare(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]),inputArr[2]);
			}
		}
	}
	public static SimplePlayer enterPlayerDetails(Scanner scanner)
	{
		System.out.println("Enter the player name ::");
		String playerName=scanner.nextLine();
		SimplePlayer player=new SimplePlayer(playerName);
		return player;
	}
	
	public static void rollDice(Scanner scanner,SimplePlayer player)
	{
		System.out.println("Roll the dice with number (Press 0 to exit )::");
		while(true)
		{
			int rolledDice=scanner.nextInt();
			if(rolledDice==0)
				break;
			else
				player.move(rolledDice);
			System.out.println("Player position -->"+player.getCurrentPosition());
		}
	}
}
