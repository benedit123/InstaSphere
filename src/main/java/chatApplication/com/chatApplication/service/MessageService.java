package chatApplication.com.chatApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.MessageDao;
import chatApplication.com.chatApplication.entity.Message;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class MessageService {

	@Autowired
	MessageDao dao;
	
	public ResponseEntity<ResponseStructure<Message>> saveMessage(Message message)
	{
		ResponseStructure<Message> structure=new ResponseStructure<>();
		structure.setMessage("Message Saved successFully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMessage(message));
		return new ResponseEntity<ResponseStructure<Message>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Message>> findMessage(int messageId)
	{
		ResponseStructure<Message> structure=new ResponseStructure<>();
		Message exMessage=dao.findMessage(messageId);
		if (exMessage!=null) {
			structure.setMessage("Message Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(exMessage);
			return new ResponseEntity<ResponseStructure<Message>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Message>> deleteMessage(int messageId) 
	{
		ResponseStructure<Message> structure = new ResponseStructure<>();
		Message exMessage=dao.findMessage(messageId);
		if (exMessage!=null) 
		{
			structure.setMessage(" message Deleted success fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteMessage(messageId));
			return new ResponseEntity<ResponseStructure<Message>>(structure,HttpStatus.OK);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Message>> updateMessage(Message message , int messageId)
	{
		ResponseStructure<Message> structure=new ResponseStructure<>();
		Message exMessage=dao.findMessage(messageId);
		if (exMessage!=null) {
			structure.setMessage("Message Updated success Fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updatMessage(message, messageId));
			return new ResponseEntity<ResponseStructure<Message>>(structure,HttpStatus.OK);
		}
		return null;
	}
}
