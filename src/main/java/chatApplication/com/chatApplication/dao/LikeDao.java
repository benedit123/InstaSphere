package chatApplication.com.chatApplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chatApplication.com.chatApplication.entity.LikeClass;
import chatApplication.com.chatApplication.repo.LikeRepo;
@Repository
public class LikeDao {

	@Autowired
	LikeRepo repo;
	
	public LikeClass saveLike(LikeClass like)
	{
		return repo.save(like);		
	}
	public LikeClass findLike(int likeId)
	{
		Optional<LikeClass> opLike=repo.findById(likeId);
		if (opLike.isPresent())
		{
			return opLike.get();
		}
		return null;
	}
	public LikeClass deleteLike(int likeId)
	{
		LikeClass like =findLike(likeId);
		repo.delete(like);
		return like;
	}
	public LikeClass updateLike(LikeClass like , int likeId) 
	{
		LikeClass exLike=findLike(likeId);
		if (exLike!=null) {
			like.setLike_Id(likeId);
			return repo.save(like);
		}
		return null;
	}
}
