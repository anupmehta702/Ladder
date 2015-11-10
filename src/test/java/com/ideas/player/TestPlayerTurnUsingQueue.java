package com.ideas.player;



import com.ideas.board.Board;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestPlayerTurnUsingQueue {

	PlayerTurnUsingQueue playerTurn=PlayerTurnUsingQueue.getInstance();
	@Test
	public void testSequenceNumberGeneratedInPlayer()
	{
		Player one =new Player("ONE");
		playerTurn.registerPlayerForItsTurn(one);
		assertTrue("Not equal",one.getSequenceNumber()==1);
		playerTurn.registerPlayerForItsNextTurn(one);
		assertTrue("Not equal",one.getSequenceNumber()==2);

	}
	@Test
	public void TestForSequenceOfPlayer()
	{
		Player one =new Player("ONE");
		playerTurn.registerPlayerForItsTurn(one);
		Player two =new Player("TWO");
		playerTurn.registerPlayerForItsTurn(two);
		Board board=Board.getInstance();
		board.initialize();
		playerTurn.playUsersTurnWise();
		assertEquals(PlayerTurnUsingQueue.isThereAWinner(), true);
	}



}
