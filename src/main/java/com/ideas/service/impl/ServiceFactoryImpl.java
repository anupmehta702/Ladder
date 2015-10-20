package com.ideas.service.impl;

import com.ideas.service.BoardService;
import com.ideas.service.PlayService;

public class ServiceFactoryImpl {

	public static BoardService boardService=null;
	public static PlayService playService=null;
	
	public static BoardService getBoardServiceInstance()
	{
		if(boardService==null)
			boardService=new BoardServiceImpl();		
		return boardService;
	}
	public static PlayService getPlayServiceInstance()
	{
		if(playService==null)
			playService=new PlayServiceImpl();		
		return playService;
	}
	
	
}
