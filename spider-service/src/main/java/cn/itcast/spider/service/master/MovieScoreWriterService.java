package cn.itcast.spider.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.jpa.MovieScoreDao;
import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.info.UserException;

/**
 * 电影评分模块
 * 
 * @author jack
 *
 */
@Service
public class MovieScoreWriterService {

	@Autowired
	private MovieScoreDao movieScoreDao;

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

}
