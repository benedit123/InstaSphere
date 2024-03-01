package chatApplication.com.chatApplication.exception;

public class emailOrPassWordnotFound extends RuntimeException{

	String message;
	public String getmessage() 
	{
		return message;
	}
	public emailOrPassWordnotFound (String message)
	{
		this.message=message;
	}
}
