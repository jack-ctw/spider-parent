package cn.itcast.spider.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.dao.MovieScoreDao;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.info.UserException;

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
	@Autowired
	private MovieDetailsDao movieDetailsDao;

	/**
	 * 插入评分
	 * @throws UserException 
	 * 
	 */
	public void insertMovieScore(MovieScore movieScore) throws UserException {

		// 非空判断
		if (movieScore != null && movieScore.getUserCode() != null) {
			// 判断是否已评分
			String mid = movieScore.getMid();
			String userCode = movieScore.getUserCode();
			List<MovieScore> existMovieScoreList = movieScoreDao.findByMidAndUserCode(mid, userCode);
			if (existMovieScoreList == null || existMovieScoreList.size() == 0) {
				movieScoreDao.save(movieScore);
			} else {
				System.out.println("只能进行一次评分");
			}
		}else{
			throw new UserException("登陆异常");
		}
	}

	/**
	 * 电影平均得分
	 * 
	 */
	public String getAvgScore(String mid) {
		// 总分
		Integer countScore = 0;
		List<MovieScore> movieScoreList = movieScoreDao.findByMid(mid);
		for (MovieScore movieScore : movieScoreList) {
			countScore += movieScore.getScore();
		}
		if (countScore != 0) {
			Double tempAvgScore = (double) (countScore / (movieScoreList.size()));
			DecimalFormat df = new DecimalFormat("0.00");
			String avgScore = df.format(tempAvgScore);
			return avgScore;
		} else {
			return "未评分";
		}

	}

	/**
	 * 查看用户的已评分的所有电影 TODO : 返回值是否是一个电影信息??
	 * @throws UserException 
	 */
	public List<MovieDetails> selectMovieDetailsByUserCode(String userCode) throws UserException {

		List<MovieDetails> movieDetailsList = new ArrayList<>();
		// 非空校验
		if (userCode != null) {
			List<MovieScore> MovieScoreList = movieScoreDao.findByUserCode(userCode);
			for (MovieScore movieScore : MovieScoreList) {
				String mid = movieScore.getMid();
				MovieDetails movieDetails = movieDetailsDao.findByMid(mid).get(0);
				movieDetailsList.add(movieDetails);
			}
		} else{
			throw new UserException("登陆异常");
		}

		return movieDetailsList;
	}

}
