package cn.itcast.spider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.service.MovieScoreService;

@Controller
public class MovieScoreController {
	
	@Autowired
	private MovieScoreService movieScoreService;
	/**
	 * 用户评分
	 * @param movieScore
	 * @return
	 */
	@RequestMapping("/insertMovieScore")
	public String insertMovieScore(MovieScore movieScore){
		movieScoreService.insertMovieScore(movieScore);
		return null;
	}
	
	/**
	 * 查询自己评分的电影
	 * @param userCode
	 * @return
	 */
	@RequestMapping("/MovieDetailsByUserCode")
	@ResponseBody
	public List<MovieDetails> selectMovieDetailsByUserCode(String userCode){
		List<MovieDetails> MovieDetailsList = movieScoreService.selectMovieDetailsByUserCode(userCode);
		return MovieDetailsList;
	}
}
