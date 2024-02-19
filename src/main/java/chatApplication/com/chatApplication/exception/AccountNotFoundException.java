package chatApplication.com.chatApplication.exception;

public class AccountNotFoundException extends RuntimeException
{

	String message;
	public String getmessage() 
	{
		return message;
	}
	public AccountNotFoundException (String message)
	{
		this.message=message;
	}
}
