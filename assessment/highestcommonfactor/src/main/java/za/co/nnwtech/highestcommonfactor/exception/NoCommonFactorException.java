package za.co.nnwtech.highestcommonfactor.exception;

public class NoCommonFactorException extends Throwable
{

	public NoCommonFactorException(String message)
	{
		super(message);
	}
	
	public NoCommonFactorException(String message, Throwable ex)
	{
		super(message,ex);
	}
}
