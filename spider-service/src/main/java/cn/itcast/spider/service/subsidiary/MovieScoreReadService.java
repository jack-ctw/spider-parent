package cn.itcast.spider.service.subsidiary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class MovieScoreReadService {

	@Autowired
	private MovieScoreMapper movieScoreMapper;
	@Autowired
	private MovieDetailsMapper movieDetailsMapper;

	/**
	 * 电影平均得分
	 * 
	 */
	public String getAvgScore(String mid) {
		// 总分
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
	 * @throws UserException 
	 */
	public List<MovieDetails> selectMovieDetailsByUserCode(String userCode) throws UserException {

		List<MovieDetails> movieDetailsList = new ArrayList<>();
		// 非空校验
		if (userCode != null) {
			List<MovieScore> MovieScoreList = movieScoreMapper.queryMovieScoreByUserCode(userCode);
			for (MovieScore movieScore : MovieScoreList) {
				String mid = movieScore.getMid();
				MovieDetails movieDetails = movieDetailsMapper.queryMovieDetailsByMid(mid).get(0);
				movieDetailsList.add(movieDetails);
			}
		} else{
			throw new UserException("登陆异常");
		}

		return movieDetailsList;
	}

}