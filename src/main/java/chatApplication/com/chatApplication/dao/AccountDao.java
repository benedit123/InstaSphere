package chatApplication.com.chatApplication.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chatApplication.com.chatApplication.entity.Account;
import chatApplication.com.chatApplication.repo.AccountRepo;
@Repository
public class AccountDao {

	@Autowired
	AccountRepo accountrepo;
	
	public Account saveAccount(Account account) 
	{
		return accountrepo.save(account);
	}
	public Account findAccount( int accountId) 
    {
    	Optional<Account> Opacc= accountrepo.findById(accountId);
    	if (Opacc.isPresent())
    	{
			return Opacc.get();
		}
    	return null;
	}
	public Account deleteAccount(int accountId)
	{
		Account account =findAccount(accountId);
		accountrepo.delete(account);
		return account;
	}
	public Account UpdateAccount(Account account,int accountId)
	{
		Account exaccount= findAccount(accountId);
		if (exaccount!=null) 
		{
			account.setAccountId(accountId);
			return accountrepo.save(account);
		}return null;
	}
	
}
