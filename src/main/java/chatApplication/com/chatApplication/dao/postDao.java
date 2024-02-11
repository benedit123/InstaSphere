package chatApplication.com.chatApplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chatApplication.com.chatApplication.entity.PostClass;
import chatApplication.com.chatApplication.repo.PostClassRepo;
@Repository
public class postDao {
@Autowired
PostClassRepo repo;

public PostClass savePost(PostClass postc) 
{
	return repo.save(postc);
}
public PostClass findPost( int postId) 
{
	Optional<PostClass> Oppost= repo.findById(postId);
	if (Oppost.isPresent())
	{
		return Oppost.get();
	}
	return null;
}
public PostClass deletePost(int postId)
{
	PostClass post=findPost(postId);
	repo.delete(post);
	return post;
}
public PostClass updatePost(PostClass post , int postId)
{
	PostClass exPost=findPost(postId);
	if (exPost!=null)
	{
		post.setPostId(postId);
		return repo.save(post);
	}
	return null;
}
}
