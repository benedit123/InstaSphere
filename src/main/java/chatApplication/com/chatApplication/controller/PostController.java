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
import chatApplication.com.chatApplication.entity.PostClass;
import chatApplication.com.chatApplication.service.PostService;
import chatApplication.com.chatApplication.util.ResponseStructure;

@RestController
@RequestMapping("post")
public class PostController
{

	@Autowired
	PostService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<PostClass>> savePost(@RequestBody PostClass post)
	{
		return service.savePost(post);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<PostClass>> findPost(@RequestParam int postId)
	{
		return service.findPost(postId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<PostClass>> deletePost(@RequestParam int postId)
	{
		return service.deletePost(postId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<PostClass>> updatePost(@RequestBody PostClass post ,@RequestParam int postId)
	{
		return service.updatePost(post, postId);
	}
	
}
