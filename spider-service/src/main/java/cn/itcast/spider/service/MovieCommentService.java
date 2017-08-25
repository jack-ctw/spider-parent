package cn.itcast.spider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.MovieCommentDao;
import cn.itcast.spider.entity.MovieComment;
/**
 * 电影评论模块
 * @author jack
 *
 */
@Service
public class MovieCommentService {
	
	@Autowired
	private MovieCommentDao moiveCommentDao;

	/**
	 * 根据用户查询评论
	 * 
	 */
	public List<MovieComment> QueryCommentsByUser(String userCode){
		List<MovieComment> Comments = moiveCommentDao.findByUserCode(userCode);
		return Comments;
	}
	
	/**
	 * 根据电影Mid查询该电影所有评论&评分
	 */
	public List<MovieComment> QueryCommentsByMid(){
		
		return null;
	}
	
}
