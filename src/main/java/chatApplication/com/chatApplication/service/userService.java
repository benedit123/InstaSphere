package chatApplication.com.chatApplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.UserDao;
import chatApplication.com.chatApplication.dto.UserDto;
import chatApplication.com.chatApplication.entity.User;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class userService {

	@Autowired
	UserDao dao;
	
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
}
