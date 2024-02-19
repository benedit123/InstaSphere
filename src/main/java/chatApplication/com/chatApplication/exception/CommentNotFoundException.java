package chatApplication.com.chatApplication.exception;

public class CommentNotFoundException extends RuntimeException
{
	String message;
	public String getmessage()
	{
		return message;
	}
	public CommentNotFoundException(String message)
	{
		this.message=message;
	}
}
