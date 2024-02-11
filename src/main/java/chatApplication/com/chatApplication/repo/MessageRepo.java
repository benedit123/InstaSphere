package chatApplication.com.chatApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import chatApplication.com.chatApplication.entity.Message;

public interface MessageRepo extends JpaRepository<Message, Integer> {

}
