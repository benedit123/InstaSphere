package chatApplication.com.chatApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
