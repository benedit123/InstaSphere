package chatApplication.com.chatApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import chatApplication.com.chatApplication.entity.User;

public interface userRepo extends JpaRepository<User, Integer> {

}
