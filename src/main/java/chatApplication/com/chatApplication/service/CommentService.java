package chatApplication.com.chatApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import chatApplication.com.chatApplication.dao.CommentDao;
import chatApplication.com.chatApplication.entity.Comment;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class CommentService {

	@Autowired
	CommentDao dao;
	
	public ResponseEntity<ResponseStructure<Comment>> saveComment(Comment comment)
	{
		ResponseStructure<Comment> structure=new ResponseStructure<>();
		structure.setMessage("comment Saved success fully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveComment(comment));
		return new ResponseEntity<ResponseStructure<Comment>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Comment>> findComment(int commentId)
	{
		ResponseStructure<Comment> structure=new ResponseStructure<>();
		Comment comment= dao.findComment(commentId);
		if (comment!=null) {
			structure.setMessage("comment found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(comment);
			return new ResponseEntity<ResponseStructure<Comment>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Comment>> deleteComment(int commentId)
	{
		ResponseStructure<Comment> structure = new ResponseStructure<>();
		Comment comment=dao.findComment(commentId);
		if (comment!=null) {
			structure.setMessage("deleted success fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deletecommComment(commentId));
			return new ResponseEntity<ResponseStructure<Comment>>(structure,HttpStatus.OK);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Comment>> updateComment(Comment comment,int commentId) {
		ResponseStructure<Comment> structure = new ResponseStructure<>();
		Comment exComment= dao.findComment(commentId);
		if (exComment!=null) {
			structure.setMessage("Comment Updated Success Fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateComment(comment, commentId));
			return new ResponseEntity<ResponseStructure<Comment>>(structure,HttpStatus.OK);
		}
		return null;
	}
}
