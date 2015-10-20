package com.ideas.test;

import java.io.InputStreamReader;
import java.util.Scanner;

import com.ideas.exception.IncorrectLadderException;
import com.ideas.exception.IncorrectSnakeException;
import com.ideas.player.Player;
import com.ideas.player.PlayerTurn;
import com.ideas.player.PlayerTurnUsingQueue;
import com.ideas.service.BoardService;
import com.ideas.service.impl.ServiceFactoryImpl;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		BoardService boardService=ServiceFactoryImpl.getBoardServiceInstance();
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.println("Please enter no of squares on the board ::");
		int boardSize = scanner.nextInt();
		boardService.setNoOfSqaureOnBoard(boardSize); 
		addSnakeDetails(scanner,boardService);
		addLadderDetails(scanner,boardService);
		System.out.println("--------------------");
		boardService.printAll();
		System.out.println("--------------------");
		initializingPlayerDetails(scanner);
		
		scanner.close();
	}
	
	public static void initializingPlayerDetails(Scanner scanner) throws InterruptedException
	{
		System.out.println("Please enter no of players  ::");
	     int noOfPlayers = scanner.nextInt();
	     PlayerTurn.noOfPlayers=noOfPlayers;
	     //List<Player> playerList=new ArrayList<Player>();
	     PlayerTurnUsingQueue playerTurn=PlayerTurnUsingQueue.getInstance();
	     for(int i=0;i<noOfPlayers;i++)
	     {
	    	System.out.println("Enter first player's name ::");
	    	String nameOfPlayer=scanner.next();
	 		Player player=new Player(nameOfPlayer);
	 		//playerList.add(player);
	 		playerTurn.registerPlayerForItsTurn(player);
	     }
	     System.out.println("Press Y to start the game ::");
	     String status=scanner.next();
	     if(status.equalsIgnoreCase("Y"))
	     {
	    	 playerTurn.playUsersTurnWise();
	     }
	}
	public static void addSnakeDetails(Scanner scanner,BoardService serviceImpl)
	{
		System.out.println("Please enter snake Details ::");
		
		int noOfSnakes=0;
		while(true)
		{
			System.out.println("No of snakes to add ::");
			noOfSnakes=scanner.nextInt();
			if(noOfSnakes>BoardService.maxNoOfSnakes)
			{
				System.out.println("Please enter number of snakes less than ::"+BoardService.maxNoOfSnakes);
			}
			else{
				break;
			}
		}
		System.out.println("Please enter snake Details in format --> 'to from' ::");
		for(int i=0;i<noOfSnakes;i++)
		{
			int count=i+1;
			System.out.println(count+" th snake[from,to] ::");
			while(scanner.hasNextInt())
			{
				try{
					serviceImpl.addSnake(scanner.nextInt(),scanner.nextInt());
					break;
				}catch(IncorrectSnakeException e){
					System.out.println("Incorrect snake inputs due to error :: "+e.error);
				}
				
			}
		}
	}
	public static void addLadderDetails(Scanner scanner,BoardService serviceImpl)
	{
		System.out.println("Please enter ladder Details ::");
		System.out.println("No of ladder to add ::");
		int noOfLadders=scanner.nextInt();
		while(true)
		{
			if(noOfLadders>BoardService.maxNoOfLadders)
			{
				System.out.println("Please enter number of ladder less than ::"+BoardService.maxNoOfSnakes);
			}
			else{
				break;
			}
		}
		System.out.println("Please enter ladder Details in format --> 'to from' ::");
		for(int i=0;i<noOfLadders;i++)
		{
			int count=i+1;
			System.out.println(count+" th ladder[from,to] ::");
			try{
				while(scanner.hasNextInt())
				{
					try{
						serviceImpl.addLadder(scanner.nextInt(),scanner.nextInt());
						break;
					}catch(IncorrectSnakeException e){
						System.out.println("Incorrect snake inputs due to error :: "+e.error);
					}				}
			}catch(IncorrectLadderException e){
				System.out.println("Incorrect ladder inputs due to error :: "+e.error);
			}
		
		}
	}
}
