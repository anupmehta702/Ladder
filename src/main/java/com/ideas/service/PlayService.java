package com.ideas.service;

import com.ideas.board.square.Square;
import com.ideas.player.Player;

public interface PlayService {

	Square initializePlayer(Player player);
	void play(int diceNumber,Player p);
	void locateAllPlayers();
	
}
