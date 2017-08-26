package cn.itcast.spider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.spider.entity.MovieComment;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.MovieCommentWriterService;
import cn.itcast.spider.service.subsidiary.MovieCommentReadService;

@Controller
public class MovieCommentController {

	@Autowired
	private MovieCommentWriterService movieCommentWriterService;
	@Autowired
	private MovieCommentReadService movieCommentReadService;
	
	
	/**
	 * 新增评论
	 * @param movieComment
	 * @return
	 */
	@RequestMapping("/insertMovieComment")
	public String insertMovieComment(MovieComment movieComment){
		
		movieCommentWriterService.insertMovieComment(movieComment);
		return null;
	}
	
	/**
	 * 查询该电影所有的评论
	 * @param mid
	 * @return
	 * @throws UserException 
	 */
	@RequestMapping("/QueryCommentsByMid")
	@ResponseBody
	public List<MovieComment> QueryCommentsByMid(String mid) throws UserException{
		
		List<MovieComment> MoviecommentsList = movieCommentReadService.QueryCommentsByMid(mid);
		return MoviecommentsList;
	}
	
	/**
	 * 查询用户评论的电影
	 * @param userCode
	 * @return
	 * @throws UserException 
	 */
	@RequestMapping
	@ResponseBody
	public List<MovieDetails> queryMovieDetailsByUserCode(String userCode) throws UserException{
		
		List<MovieDetails> movieDetailsList = movieCommentReadService.queryMovieDetailsByUserCode(userCode);
		return movieDetailsList;
	}
}