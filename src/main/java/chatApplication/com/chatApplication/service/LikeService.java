package chatApplication.com.chatApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatApplication.com.chatApplication.dao.LikeDao;
import chatApplication.com.chatApplication.entity.LikeClass;
import chatApplication.com.chatApplication.util.ResponseStructure;
@Service
public class LikeService {

	@Autowired
	LikeDao dao;
	public ResponseEntity<ResponseStructure<LikeClass>> saveLike(LikeClass like )
	{
		ResponseStructure<LikeClass> structure =new ResponseStructure<>();
		structure.setMessage("like saved success fully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveLike(like));
		return new  ResponseEntity<ResponseStructure<LikeClass>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<LikeClass>> findLike(int likeId)
	{
		ResponseStructure<LikeClass> structure=new ResponseStructure<>();
		LikeClass exLike=dao.findLike(likeId);
		if (exLike!=null) {
			structure.setMessage("like Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(exLike);
			return new ResponseEntity<ResponseStructure<LikeClass>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<LikeClass>> deleteLike(int likeId)
	{
		ResponseStructure<LikeClass> structure = new ResponseStructure<>();
		LikeClass like=dao.findLike(likeId);
		if (like!=null) {
			structure.setMessage("deleted success fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteLike(likeId));
			return new ResponseEntity<ResponseStructure<LikeClass>>(structure,HttpStatus.OK);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<LikeClass>> updateLike(LikeClass like,int likeId) {
		ResponseStructure<LikeClass> structure = new ResponseStructure<>();
		LikeClass exlike= dao.findLike(likeId);
		if (exlike!=null) {
			structure.setMessage("like Updated Success Fully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateLike(like, likeId));
			return new ResponseEntity<ResponseStructure<LikeClass>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
}
