package cn.itcast.spider.service;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.MovieScoreDao;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.entity.MovieScore;

/**
 * 电影评分模块
 * 
 * @author jack
 *
 */
@Service
public class MovieScoreService {

	@Autowired
	private MovieScoreDao movieScoreDao;

	/**
	 * 插入评分
	 * 
	 */
	public void insertMovieScore(MovieScore movieScore) {
		// 判断是否已评分
		String mid = movieScore.getMid();
		String userCode = movieScore.getUserCode();
		List<MovieScore> existMovieScoreList = movieScoreDao.findByMidAndUserCode(mid, userCode);
		if (existMovieScoreList == null || existMovieScoreList.size() == 0) {
			movieScoreDao.save(movieScore);
		} else {
			System.out.println("只能进行一次评分");
		}
	}

	/**
	 * 电影平均得分
	 * 
	 */
	public String getAvgScore(String mid) {
		List<MovieScore> movieScoreList = movieScoreDao.findByMid(mid);
		Integer countScore = 0;
		for (MovieScore movieScore : movieScoreList) {
			countScore += movieScore.getScore();
		}
		Double tempAvgScore = (double) (countScore / (movieScoreList.size()));
		DecimalFormat df = new DecimalFormat("0.0");
		String avgScore = df.format(tempAvgScore);
		return avgScore;
	}
	
	/**
	 * 查看用户的已评分的所有电影
	 * 
	 */
	
}
