package chatApplication.com.chatApplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chatApplication.com.chatApplication.entity.User;
import chatApplication.com.chatApplication.repo.userRepo;
@Repository
public class UserDao {
    @Autowired
	userRepo repo;
    
    public User saveUser(User user) 
    {
		return repo.save(user);
	}

    public User findUser( int userId) 
    {
    	Optional<User> Opuser= repo.findById(userId);
    	if (Opuser.isPresent())
    	{
			return Opuser.get();
		}
    	return null;
	}
    public User deleteUser(int userId)
    {
		User user=findUser(userId);
		repo.delete(user);
		return user;
	}
    public User updateUser(User user , int userId)
    {
    	User exUser=findUser(userId);
    	if (exUser!=null)
    	{
			user.setUserId(userId);
			return repo.save(user);
		}
    	return null;
    }
}
