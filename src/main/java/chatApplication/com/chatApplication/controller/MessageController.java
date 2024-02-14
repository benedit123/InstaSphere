package chatApplication.com.chatApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chatApplication.com.chatApplication.entity.Message;
import chatApplication.com.chatApplication.service.MessageService;
import chatApplication.com.chatApplication.util.ResponseStructure;

@RestController
@RequestMapping("message")
public class MessageController
{

	@Autowired
    MessageService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Message>> saveMessage(@RequestBody Message message)
	{
		return service.saveMessage(message);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Message>> findMessage(@RequestParam int messageId)
	{
		return service.findMessage(messageId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Message>> deleteMessage(@RequestParam int messageId)
	{
		return service.deleteMessage(messageId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Message>> updateMessage(@RequestBody Message message ,@RequestParam int messageId)
	{
		return service.updateMessage(message, messageId);
	}
	@PutMapping("assignMessagetoAcc")
	public ResponseEntity<ResponseStructure<Message>> messageToaccount(int accountId,int messageId)
	{
		return service.messageToaccount(accountId, messageId);
	}

}
