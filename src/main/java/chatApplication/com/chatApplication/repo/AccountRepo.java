package chatApplication.com.chatApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import chatApplication.com.chatApplication.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
