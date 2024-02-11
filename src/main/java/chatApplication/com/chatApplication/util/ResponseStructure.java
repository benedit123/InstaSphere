package chatApplication.com.chatApplication.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private String message;
	private int Status;
	private T data;
}
