package cn.itcast.spider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.MovieScoreWriterService;
import cn.itcast.spider.service.subsidiary.MovieScoreReadService;

@Controller
public class MovieScoreController {
	
	@Autowired
	private MovieScoreWriterService movieScoreWriterService;
	@Autowired
	private MovieScoreReadService MovieScoreReadService;
	
	/**
	 * 用户评分
	 * @param movieScore
	 * @return
	 * @throws UserException 
	 */
	@RequestMapping("/insertMovieScore")
	public String insertMovieScore(MovieScore movieScore) throws UserException{
		
		movieScoreWriterService.insertMovieScore(movieScore);
		return null;
	}
	
	/**
	 * 查询自己评分的电影
	 * @param userCode
	 * @return
	 * @throws UserException 
	 */
	@RequestMapping("/MovieDetailsByUserCode")
	@ResponseBody
	public List<MovieDetails> selectMovieDetailsByUserCode(String userCode) throws UserException{
		
		List<MovieDetails> MovieDetailsList = MovieScoreReadService.selectMovieDetailsByUserCode(userCode);
		return MovieDetailsList;
	}
}
