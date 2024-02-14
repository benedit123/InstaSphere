package chatApplication.com.chatApplication.entity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String Email;
	private String userPass;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", Email=" + Email + ", userPass=" + userPass
				+ "]";
	}
	
}
