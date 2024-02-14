package chatApplication.com.chatApplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chatApplication.com.chatApplication.entity.Message;
import chatApplication.com.chatApplication.repo.MessageRepo;

@Repository
public class MessageDao {

	@Autowired
	MessageRepo messagerepo;
	public Message saveMessage(Message message) 
    {
		return messagerepo.save(message);
	}

    public Message findMessage( int messageId) 
    {
    	Optional<Message> Opmessage= messagerepo.findById(messageId);
    	if (Opmessage.isPresent())
    	{
			return Opmessage.get();
		}
    	return null;
	}
    public Message deleteMessage(int messageId)
    {
		Message message=findMessage(messageId);
	    messagerepo.delete(message);
		return message;
	}
    public Message updatMessage(Message message , int messageId)
    {
    	Message exMessage=findMessage(messageId);
    	if (exMessage!=null)
    	{
			message.setFromUserId(messageId);
			return messagerepo.save(message);
		}
    	return null;
    }
}
