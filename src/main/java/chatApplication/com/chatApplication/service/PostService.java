package chatApplication.com.chatApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.postDao;
import chatApplication.com.chatApplication.entity.PostClass;
import chatApplication.com.chatApplication.util.ResponseStructure;

@Service
public class PostService {

	@Autowired
	postDao dao;
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
}
