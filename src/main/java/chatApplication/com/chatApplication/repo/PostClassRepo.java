package chatApplication.com.chatApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import chatApplication.com.chatApplication.entity.PostClass;

public interface PostClassRepo extends JpaRepository<PostClass, Integer> {

}
