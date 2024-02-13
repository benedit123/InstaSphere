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
import chatApplication.com.chatApplication.entity.LikeClass;
import chatApplication.com.chatApplication.service.LikeService;
import chatApplication.com.chatApplication.util.ResponseStructure;

@RestController
@RequestMapping("like")
public class LikeController
{

	@Autowired
	LikeService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<LikeClass>> saveLike(@RequestBody LikeClass like)
	{
		return service.saveLike(like);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<LikeClass>> findLike(@RequestParam int likeId)
	{
		return service.findLike(likeId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<LikeClass>> deleteLike(@RequestParam int likeId)
	{
		return service.deleteLike(likeId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<LikeClass>> updateLike(@RequestBody LikeClass like ,@RequestParam int likeId)
	{
		return service.updateLike(like, likeId);
	}
}
