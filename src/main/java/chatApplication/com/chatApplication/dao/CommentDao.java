package chatApplication.com.chatApplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chatApplication.com.chatApplication.entity.Comment;
import chatApplication.com.chatApplication.repo.CommentRepo;

@Repository
public class CommentDao {

	@Autowired
	CommentRepo repo;
	
	public Comment saveComment(Comment comment)
	{
		return repo.save(comment);
	}
	public Comment findComment(int commentId)
	{
		Optional<Comment> opComment=repo.findById(commentId);
		if (opComment.isPresent()) 
		{
			return opComment.get();
		}
		return null;
	}
	public Comment deletecommComment(int commentId)
	{
		Comment comment=findComment(commentId);
		repo.delete(comment);
		return comment;
	}
	public Comment updateComment(Comment comment ,int commentId)
	{
		Comment exComment=findComment(commentId);
		if (exComment!=null)
		{
			comment.setCommentId(commentId);
			return repo.save(comment);
		}
		return null;
	}
}
