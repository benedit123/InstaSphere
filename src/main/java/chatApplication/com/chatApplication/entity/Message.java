package chatApplication.com.chatApplication.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Component
@Entity
@Getter
@Setter
public class Message {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int messageId;
	private String messageText;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Account accountmess;
	private int fromUserId;
	private int toUserId;
}
