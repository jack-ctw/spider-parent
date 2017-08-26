package cn.itcast.spider.service.master;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.jpa.MovieCommentDao;
import cn.itcast.spider.entity.MovieComment;
/**
 * 电影评论模块
 * 
 * @author jack
 *
 */
@Service
public class MovieCommentWriterService {

	@Autowired
	private MovieCommentDao moiveCommentDao;

	/**
	 * 增加评论
	 * 
	 */
	public void insertMovieComment(MovieComment movieComment) {
		moiveCommentDao.save(movieComment);
	}

}
