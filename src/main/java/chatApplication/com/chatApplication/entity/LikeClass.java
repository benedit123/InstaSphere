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
@Getter
@Setter
public class LikeClass {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int like_Id;
	private int likeCount;
	private int userId;
}
