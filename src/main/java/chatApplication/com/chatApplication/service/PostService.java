package chatApplication.com.chatApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.CommentDao;
import chatApplication.com.chatApplication.dao.LikeDao;
import chatApplication.com.chatApplication.dao.postDao;
import chatApplication.com.chatApplication.entity.Account;
import chatApplication.com.chatApplication.entity.Comment;
import chatApplication.com.chatApplication.entity.LikeClass;
import chatApplication.com.chatApplication.entity.PostClass;
import chatApplication.com.chatApplication.repo.LikeRepo;
import chatApplication.com.chatApplication.repo.PostClassRepo;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class PostService {

	@Autowired
	postDao dao;
	@Autowired
	PostClassRepo repo;
	@Autowired
	LikeDao ldao;
	@Autowired
	LikeRepo lrepo;
	@Autowired
	CommentDao cdao;
	public ResponseEntity<ResponseStructure<PostClass>> savePost(PostClass post )
	{
		ResponseStructure<PostClass> structure =new ResponseStructure<>();
		structure.setMessage("post saved success fully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.savePost(post));
		return new  ResponseEntity<ResponseStructure<PostClass>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<PostClass>> findPost(int postId)
	{
		ResponseStructure<PostClass> structure=new ResponseStructure<>();
		PostClass exPost=dao.findPost(postId);
		if (exPost!=null) {
			structure.setMessage("post Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(exPost);
			return new ResponseEntity<ResponseStructure<PostClass>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<PostClass>> deletePost(int postId)
	{
		ResponseStructure<PostClass> structure = new ResponseStructure<>();
		PostClass post=dao.findPost(postId);
		if (post!=null) {
			structure.setMessage("deleted success fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deletePost(postId));
			return new ResponseEntity<ResponseStructure<PostClass>>(structure,HttpStatus.OK);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<PostClass>> updatePost(PostClass post,int postId) {
		ResponseStructure<PostClass> structure = new ResponseStructure<>();
		PostClass exPost= dao.findPost(postId);
		if (exPost!=null) {
			structure.setMessage("post Updated Success Fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updatePost(post, postId));
			return new ResponseEntity<ResponseStructure<PostClass>>(structure,HttpStatus.OK);
		}
		return null;
	}
//	public ResponseEntity<ResponseStructure<List<PostClass>>> findAllPost() 
//	{
//		ResponseStructure<List<PostClass>> structure=new ResponseStructure<>();
//		List<PostClass> post =repo.findAll();
//		if (post!=null) {
//			structure.setMessage("its found");
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setData(post);
//			return new ResponseEntity<ResponseStructure<List<PostClass>>>(structure,HttpStatus.FOUND);
//		}
//		return null;
//	}
	public ResponseEntity<ResponseStructure<PostClass>> assignLikeToPost(int postId,int likeId)
	{
		PostClass post=dao.findPost(postId);
		LikeClass like = ldao.findLike(likeId);
		List<LikeClass> likec =post.getPost_like();
		if (post!=null) {
			if (like!=null) {
				likec.add(like);
				post.setPost_like(likec);
				ResponseStructure<PostClass> structure = new ResponseStructure<>();
				structure.setMessage("like assigned successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updatePost(post, post.getPostId()));
				return new ResponseEntity<ResponseStructure<PostClass>>(structure,HttpStatus.OK);
			}
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<PostClass>> assignCommentToPost(int postId,int commentId)
	{
		PostClass post=dao.findPost(postId);
		Comment comment=cdao.findComment(commentId);
		List<Comment> mycomment =post.getComment();
		if (post!=null) {
			if (comment!=null) {
				mycomment.add(comment);
				post.setComment(mycomment);
				ResponseStructure<PostClass> structure = new ResponseStructure<>();
				structure.setMessage("like assigned successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updatePost(post, post.getPostId()));
				return new ResponseEntity<ResponseStructure<PostClass>>(structure,HttpStatus.OK);
			}
		}
		return null;
	}
}
