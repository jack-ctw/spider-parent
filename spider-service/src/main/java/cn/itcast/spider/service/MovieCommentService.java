package cn.itcast.spider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.MovieCommentDao;
import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.entity.MovieComment;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.entity.MovieScore;

/**
 * 电影评论模块
 * 
 * @author jack
 *
 */
@Service
public class MovieCommentService {

	@Autowired
	private MovieCommentDao moiveCommentDao;
	@Autowired
	private MovieDetailsDao movieDetailsDao;
	
	/**
	 * 增加评论
	 * 
	 */
	public void insertMovieComment(MovieComment movieComment){
		moiveCommentDao.save(movieComment);
	}

	/**
	 * 用户查询自己评论过的电影
	 * TODO :名字和score的太像了
	 */
	public List<MovieDetails> queryMovieDetailsByUserCode(String userCode) {
		// 创建集合保存电影信息
		List<MovieDetails> movieDetailsList = new ArrayList<>();
		List<MovieComment> MoveCommentList = moiveCommentDao.findByUserCode(userCode);
		for (MovieComment movieComment : MoveCommentList) {
			String mid = movieComment.getMid();
			MovieDetails movieDetails = movieDetailsDao.findByMid(mid).get(0);
			movieDetailsList.add(movieDetails);
		}
		return movieDetailsList;
	}

	/**
	 * 根据该电影的所有评论
	 */
	public List<MovieComment> QueryCommentsByMid(String mid) {
		List<MovieComment> MovieCommentList = moiveCommentDao.findByMid(mid);
		return MovieCommentList;
	}

}
