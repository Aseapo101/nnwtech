package za.co.nnwtech.parser.exception;

@SuppressWarnings("serial")
public class InvalidAddressException extends RuntimeException
{

	public InvalidAddressException(String message)
	{
		super(message);
	}
	
	public InvalidAddressException(String message,Throwable e)
	{
		super(message,e);
	}
}
