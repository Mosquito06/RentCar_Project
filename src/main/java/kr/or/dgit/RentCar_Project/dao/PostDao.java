package kr.or.dgit.RentCar_Project.dao;

import java.util.List;

import kr.or.dgit.RentCar_Project.dto.Post;

public interface PostDao {
	List<Post> selectPostByAll();
	List<Post> selectPostByDoro(Post post);
	List<Post> selectPostSido();
}
