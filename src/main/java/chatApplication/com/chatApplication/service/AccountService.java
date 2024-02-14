package chatApplication.com.chatApplication.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.AccountDao;
import chatApplication.com.chatApplication.dao.MessageDao;
import chatApplication.com.chatApplication.dao.UserDao;
import chatApplication.com.chatApplication.dao.postDao;
import chatApplication.com.chatApplication.entity.Account;
import chatApplication.com.chatApplication.entity.Message;
import chatApplication.com.chatApplication.entity.PostClass;
import chatApplication.com.chatApplication.entity.User;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class AccountService {

	@Autowired
	AccountDao dao;
	@Autowired
	UserDao Udao;
	@Autowired
	postDao pdao;
	@Autowired
	MessageDao mdao;
	
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
	public ResponseEntity<ResponseStructure<Account>> assignuserToAccount( int accountId,int userId)
	{
		User user=Udao.findUser(userId);
		Account account=dao.findAccount(accountId);
		if (account!=null) {
			if (user!=null) {
				account.setUser(user);
				ResponseStructure<Account> structure = new ResponseStructure<>();
				structure.setMessage("user assigned success fully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.UpdateAccount(account, account.getAccountId()));
				return new ResponseEntity<ResponseStructure<Account>>(structure,HttpStatus.OK);
			}
			return null;
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Account>> accountToPostRelation(int accountId,int postId)
	{
		Account account=dao.findAccount(accountId);
		PostClass p= pdao.findPost(postId);
		List<PostClass> post=account.getPosts();
		if (account!=null) {
			if (p!=null) {
				   post.add(p);
					account.setPosts(post);
					ResponseStructure<Account> structure = new ResponseStructure<>();
					structure.setMessage("post assigned successfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dao.UpdateAccount(account, account.getAccountId()));
					return new ResponseEntity<ResponseStructure<Account>>(structure,HttpStatus.OK);
			}
		}return null;
	}
	public ResponseEntity<ResponseStructure<Account>> accountToMessageRelation(int messageId,int accountId)
	{
		Account account=dao.findAccount(accountId);
		Message message=mdao.findMessage(messageId);
		List<Message> newmessage=account.getMessage();
				
		if (account!=null) {
			if (message!=null) {
				newmessage.add(message);
					account.setMessage(newmessage);
					ResponseStructure<Account> structure = new ResponseStructure<>();
					structure.setMessage("message assigned successfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dao.UpdateAccount(account, account.getAccountId()));
					return new ResponseEntity<ResponseStructure<Account>>(structure,HttpStatus.OK);
			}
		}return null;
	}
}
