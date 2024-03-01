package chatApplication.com.chatApplication.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import chatApplication.com.chatApplication.util.ResponseStructure;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler
{
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userNotFoundException(UserNotFoundException ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("user does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> accountNotFoundException(AccountNotFoundException ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("account dose not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getmessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> postNotFoundException(PostNotFoundException ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Post dose not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getmessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> commentNotFoundException(CommentNotFoundException ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("comment dose not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getmessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> messageNotFoundException(MessageNotFoundException ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("message dose not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getmessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> emailorPassNotfound(emailOrPassWordnotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("email or pass  dose not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getmessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		ResponseStructure<Object> structure = new ResponseStructure<>();
		Map<String, String> hashmap = new HashMap<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashmap.put(field, message);
		}
		structure.setMessage("add proper details");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		structure.setData(hashmap);
		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);
}
	
}
