package chatApplication.com.chatApplication.exception;

public class MessageNotFoundException extends RuntimeException
{
	String message;
	public String getmessage()
	{
		return message;
	}
	public MessageNotFoundException(String message)
	{
		this.message=message;
	}
}
