package chatApplication.com.chatApplication.entity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@NotBlank(message = "user name cannot be blank")
	@NotNull(message = "user name cannot be null")
	private String userName;
	@NotBlank(message = "user email cannot be blank")
	@NotNull(message = "user email cannot be null")
	@jakarta.validation.constraints.Email
	private String Email;
	@NotBlank(message = "user pass cannot be blank")
	@NotNull(message = "user pass cannot be null")
	@Pattern(
	        regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=!])(?=\\S+$).{8,}$",
	        message = "Password must be at least 8 characters long and include at least 1 digit, 1 lowercase letter, 1 uppercase letter, and 1 special character."
	    )
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
