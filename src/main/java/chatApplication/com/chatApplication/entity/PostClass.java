package chatApplication.com.chatApplication.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
public class PostClass {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private PostType postType;
	private String postName;
	private String postText;
	@OneToMany(cascade = CascadeType.ALL)
	private List<LikeClass> post_like;
	@OneToMany(cascade =CascadeType.ALL)
	private List<Comment> comment;
}
