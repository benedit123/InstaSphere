package chatApplication.com.chatApplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.AccountDao;
import chatApplication.com.chatApplication.dao.UserDao;
import chatApplication.com.chatApplication.dto.UserDto;
import chatApplication.com.chatApplication.entity.Account;
import chatApplication.com.chatApplication.entity.User;
import chatApplication.com.chatApplication.exception.AccountNotFoundException;
import chatApplication.com.chatApplication.exception.UserNotFoundException;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class userService {

	@Autowired
	UserDao dao;
	@Autowired
	AccountDao Adao;
	
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user)
	{
		UserDto userdto=new UserDto();
	    ModelMapper m1=new ModelMapper();
	    m1.map(dao.saveUser(user), userdto);
	    ResponseStructure<UserDto> structure= new ResponseStructure<>();
	    structure.setMessage("user is saved success fully");
	    structure.setStatus(HttpStatus.CREATED.value());
	    structure.setData(userdto);
	    return new  ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> findUser(int  userId)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		User Exuser=dao.findUser(userId);
		if (Exuser!=null)
		{
			structure.setMessage("user found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(Exuser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		throw new UserNotFoundException("user Not found with the given Id");
	}
	 public ResponseEntity<ResponseStructure<User>> deleteUser(int UserId) {
			ResponseStructure<User> structure =new ResponseStructure<>();
			User user = dao.findUser(UserId);
			if (user!=null) {
			structure.setMessage("deleted success fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteUser(UserId));
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			}
			throw new UserNotFoundException("user Not found with the given Id");
		}
	 public ResponseEntity<ResponseStructure<User>> updateUser(int userId , User user) {
		ResponseStructure<User> structure =new ResponseStructure<>();
		User exuser=dao.findUser(userId);
		if (exuser!=null) {
			structure.setMessage("update sucess fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateUser(user, userId));
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new UserNotFoundException("user Not found with the given Id");
	}
	 public ResponseEntity<ResponseStructure<User>> assignaccountToUser(int accountId,int userId)
	 {
		 User exUser=dao.findUser(userId);
		 Account exAccount=Adao.findAccount(accountId);
		 if (exUser!=null) {
			if (exAccount!=null) {
				exUser.setAccount(exAccount);
				ResponseStructure<User> structure =new ResponseStructure<>();
				structure.setMessage("account assigned success fully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updateUser(exUser, exUser.getUserId()));
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			}
			throw new AccountNotFoundException("account not found in this given id");
		}
		 throw new UserNotFoundException("user Not found with the given Id");
	 }
}
