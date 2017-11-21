package kr.or.dgit.RentCar_Project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.RentCar_Project.dao.PostDao;
import kr.or.dgit.RentCar_Project.dto.Post;
import kr.or.dgit.RentCar_Project.util.MyBatisSqlSessionFactory;

public class PostService implements PostDao {
	private static final PostService INSTANCE = new PostService();
	private PostDao postDao;
	
	public static PostService getInstance() {
		return INSTANCE;
	}
	
	private PostService() {}

	@Override
	public List<Post> selectPostByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			postDao = sqlSession.getMapper(PostDao.class);
			return postDao.selectPostByAll();
		}
	}



	@Override
	public List<Post> selectPostSido() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			postDao = sqlSession.getMapper(PostDao.class);
			return postDao.selectPostSido();
		}
	}

	@Override
	public List<Post> selectPostByDoro(Post post) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession()){
			postDao = sqlSession.getMapper(PostDao.class);
			return postDao.selectPostByDoro(post);
		}
	}


	


}
