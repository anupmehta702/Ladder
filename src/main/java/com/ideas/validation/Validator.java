package com.ideas.validation;

import com.ideas.exception.IncorrectLadderException;
import com.ideas.exception.IncorrectSnakeException;

public class Validator {

	public static void validateLadderInputs(int from,int to,int maxSize)
	{
		if(to> maxSize || from > maxSize)
		{
			throw new IncorrectLadderException("Source / destination cannot be greater than max number on the board ");
		}
		if(from>to)
		{
			throw new IncorrectLadderException("Source cannot be greater than destination for ladder");
		}
		if(from == 1)
		{
			throw new IncorrectLadderException("Source of a ladder cannot be equal to start square on the board");
		}
		if(to==from)
		{
			throw new IncorrectLadderException("Source & destination  of a ladder cannot be equal");
		}
	}
	public static void validateSnakeInputs(int from,int to,int maxSize)
	{
		if(to> maxSize || from > maxSize)
		{
			throw new IncorrectSnakeException("Source / destination cannot be greater than max number on the board");
		}
		if(to>from)
		{
			throw new IncorrectSnakeException("Destination cannot be greater than source for snake");
		}
		if(from == maxSize)
		{
			throw new IncorrectSnakeException("Source of a snake cannot be equal to end square on the board");
		}
		if(to==from)
		{
			throw new IncorrectSnakeException("Source & destination  of a snake cannot be equal");
		}
		
		
	}

}
