package chatApplication.com.chatApplication.entity;

import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	private String accountName;
	private String profileContent;
	private int imageId;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	private  List<Post> posts;
	@OneToMany(cascade = CascadeType.ALL)
	private Message message;
	
}
