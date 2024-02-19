package chatApplication.com.chatApplication.exception;

public class PostNotFoundException extends RuntimeException
{
	String message;
	public String getmessage()
	{
		return message;
	}
	public PostNotFoundException(String message)
	{
		this.message=message;
	}
}
