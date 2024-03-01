package chatApplication.com.chatApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import chatApplication.com.chatApplication.entity.User;

public interface userRepo extends JpaRepository<User, Integer>
{
	@Query("select u from User u where u.Email=?1 ")
    public User findByEmail(String Email);
}