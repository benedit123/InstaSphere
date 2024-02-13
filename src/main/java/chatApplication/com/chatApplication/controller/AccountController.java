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
import chatApplication.com.chatApplication.entity.Account;
import chatApplication.com.chatApplication.service.AccountService;
import chatApplication.com.chatApplication.util.ResponseStructure;

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Account>> saveAccount(@RequestBody Account account)
	{
		return service.saveAccount(account);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Account>> findUser(@RequestParam int accountId)
	{
		return service.findAccount(accountId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Account>> deleteUser(@RequestParam int accountId)
	{
		return service.deleteAccount(accountId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Account>> updateUser(@RequestBody Account account ,@RequestParam int accountId)
	{
		return service.updateAccount(account, accountId);
	}
}
