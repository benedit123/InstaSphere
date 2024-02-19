package chatApplication.com.chatApplication.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@NotBlank(message = "posttype cannot be blank")
@NotNull(message = "post type cannot be null")
	private PostType postType;
@NotBlank(message = "post name cannot be blank")
@NotNull(message = "post name cannot be null")
	private String postName;
	private String postText;
	@OneToMany(cascade = CascadeType.ALL)
	private List<LikeClass> post_like;
	@OneToMany(cascade =CascadeType.ALL)
	private List<Comment> comment;
}
