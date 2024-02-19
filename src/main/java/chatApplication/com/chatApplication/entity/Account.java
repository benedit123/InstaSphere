package chatApplication.com.chatApplication.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
@NotBlank(message = "acc name cannot be blank")
@NotNull(message = "acc name cannot be null")
	private String accountName;
	private String profileContent;
	private int imageId;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	@OneToMany(cascade = CascadeType.ALL)
	private  List<PostClass> posts;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Message> message;
	
}
