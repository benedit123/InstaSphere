package chatApplication.com.chatApplication.exception;
public class UserNotFoundException extends RuntimeException
{

	String message ;
	
	public String getmessage() 
	{
		return message;
	}
	public  UserNotFoundException(String message)
	{
		this.message=message;
	}
}
