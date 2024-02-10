package chatApplication.com.chatApplication.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Component
@Entity
@Setter
@Getter
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private String text;
	private int userId;
}
