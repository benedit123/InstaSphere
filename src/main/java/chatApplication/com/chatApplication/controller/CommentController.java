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
import chatApplication.com.chatApplication.entity.Comment;
import chatApplication.com.chatApplication.service.CommentService;
import chatApplication.com.chatApplication.util.ResponseStructure;

@RestController
@RequestMapping("comment")
public class CommentController
{

	@Autowired
	CommentService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Comment>> saveComment(@RequestBody Comment comment)
	{
		return service.saveComment(comment);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Comment>> findComment(@RequestParam int commentId)
	{
		return service.findComment(commentId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Comment>> deleteComment(@RequestParam int commentId)
	{
		return service.deleteComment(commentId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Comment>> updateComment(@RequestBody Comment comment ,@RequestParam int commentId)
	{
		return service.updateComment(comment, commentId);
	}
}
