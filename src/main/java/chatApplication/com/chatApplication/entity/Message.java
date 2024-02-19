package chatApplication.com.chatApplication.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@NotBlank(message = "message cannot be blank")
@NotNull(message = "message cannot be null")
	private String messageText;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Account accountmess;
	@NotBlank(message = "fromuser cannot be blank")
	@NotNull(message = "from user cannot be null")
	private int fromUserId;
	@NotBlank(message = "touser  cannot be blank")
	@NotNull(message = "touser  cannot be null")
	private int toUserId;
}
