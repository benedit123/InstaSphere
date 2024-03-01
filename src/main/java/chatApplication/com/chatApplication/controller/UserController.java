package chatApplication.com.chatApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chatApplication.com.chatApplication.dto.UserDto;
import chatApplication.com.chatApplication.entity.User;
import chatApplication.com.chatApplication.service.userService;
import chatApplication.com.chatApplication.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {
@Autowired
	userService service;
@PostMapping
public ResponseEntity<ResponseStructure<UserDto>> saveUser(@RequestBody User user) {
	return service.saveUser(user);
}
@GetMapping
public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int userId)
{
	return service.findUser(userId);
}
@DeleteMapping
public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int userId)
{
	return service.deleteUser(userId);
}
@PutMapping
public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user ,@RequestParam int userId)
{
	return service.updateUser(userId, user);
}
@PutMapping("assignacountuser")
public ResponseEntity<ResponseStructure<User>> assignaccountToUser(@RequestParam int accountId,@RequestParam int userId)
{
	return service.assignaccountToUser(accountId, userId);
}
@GetMapping("login")
public ResponseEntity<ResponseStructure<User>> login(@RequestParam String email,@RequestParam String password)
{
	return service.login(email, password);
}
}
