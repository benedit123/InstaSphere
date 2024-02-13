package chatApplication.com.chatApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.AccountDao;
import chatApplication.com.chatApplication.entity.Account;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class AccountService {

	@Autowired
	AccountDao dao;
	
	public ResponseEntity<ResponseStructure<Account>> saveAccount(Account account )
	{
		ResponseStructure<Account> structure =new ResponseStructure<>();
		structure.setMessage("Account saved success fully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAccount(account));
		return new  ResponseEntity<ResponseStructure<Account>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Account>> findAccount(int accountId)
	{
		ResponseStructure<Account> structure=new ResponseStructure<>();
		Account exAccount=dao.findAccount(accountId);
		if (exAccount!=null) {
			structure.setMessage("Account Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(exAccount);
			return new ResponseEntity<ResponseStructure<Account>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Account>> deleteAccount(int accountId)
	{
		ResponseStructure<Account> structure = new ResponseStructure<>();
		Account account=dao.findAccount(accountId);
		if (account!=null) {
			structure.setMessage("deleted success fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteAccount(accountId));
			return new ResponseEntity<ResponseStructure<Account>>(structure,HttpStatus.OK);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Account>> updateAccount(Account account,int accountId) {
		ResponseStructure<Account> structure = new ResponseStructure<>();
		Account exAccount= dao.findAccount(accountId);
		if (exAccount!=null) {
			structure.setMessage("Account Updated Success Fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.UpdateAccount(account, accountId));
			return new ResponseEntity<ResponseStructure<Account>>(structure,HttpStatus.OK);
		}
		return null;
	}
}
