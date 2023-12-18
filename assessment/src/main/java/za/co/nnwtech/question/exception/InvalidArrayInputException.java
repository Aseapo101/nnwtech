package za.co.nnwtech.question.exception;

@SuppressWarnings("serial")
public class InvalidArrayInputException extends RuntimeException
{
	public InvalidArrayInputException(String message)
	{
		super(message);
	}
	
	public InvalidArrayInputException(String message, Throwable ex)
	{
		super(message,ex);
	}
}
