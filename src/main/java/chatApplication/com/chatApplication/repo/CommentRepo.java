package chatApplication.com.chatApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import chatApplication.com.chatApplication.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
