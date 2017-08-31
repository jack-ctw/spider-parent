package cn.itcast.spider.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.itcast.spider.dao.jpa.MovieScoreDao;
import cn.itcast.spider.dao.mapper.MovieDetailsMapper;
import cn.itcast.spider.dao.mapper.MovieScoreMapper;
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
	private MovieScoreMapper movieScoreMapper;
	@Autowired
	private MovieDetailsMapper movieDetailsMapper;

	/**
	 * 插入评分
	 * 
	 * @throws UserException
	 * 
	 */
	@Transactional
	public void insertMovieScore(MovieScore movieScore) throws UserException {

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
		} else {
			throw new UserException("登陆异常");
		}
	}

	/**
	 * 计算平均得分
	 * 
	 */
	public String getAvgScore(String mid) {

		Integer countScore = 0;

		List<MovieScore> movieScoreList = movieScoreMapper.queryMovieScoreByMid(mid);
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
	 * 查看用户的已评分的所有电影
	 * 
	 * @throws UserException
	 */
	public List<MovieDetails> selectMovieDetailsByUserCode(String userCode) throws UserException {

		if (userCode != null) {
			
			List<MovieDetails> movieDetailsList = new ArrayList<>();
			List<MovieScore> MovieScoreList = movieScoreMapper.queryMovieScoreByUserCode(userCode);
			for (MovieScore movieScore : MovieScoreList) {
				String mid = movieScore.getMid();
				MovieDetails movieDetails = movieDetailsMapper.queryMovieDetailsByMid(mid).get(0);
				movieDetailsList.add(movieDetails);
			}
			return movieDetailsList;
		} else {
			throw new UserException("登陆异常");
		}

	}

}
