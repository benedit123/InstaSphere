package chatApplication.com.chatApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import chatApplication.com.chatApplication.entity.LikeClass;

public interface LikeRepo extends JpaRepository<LikeClass, Integer> {

}
