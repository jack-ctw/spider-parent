package cn.itcast.spider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.itcast.spider.dao.jpa.MovieCommentDao;
import cn.itcast.spider.dao.mapper.MovieCommentMapper;
import cn.itcast.spider.dao.mapper.MovieDetailsMapper;
import cn.itcast.spider.entity.MovieComment;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.info.UserException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
	private MovieCommentMapper movieCommentMapper;
	@Autowired
	private MovieDetailsMapper movieDetailsMapper;
	@Autowired
	private JedisPool jedisPool;

	/**
	 * 增加评论
	 * 
	 */
	@Transactional
	public void insertMovieComment(MovieComment movieComment) {
		moiveCommentDao.save(movieComment);

		Jedis jedis = jedisPool.getResource();
		String mid = movieComment.getMid();
		String userCode = movieComment.getUserCode();
		// 更新用户查询自己评论过的电影 _缓存 : spider_queryMovieDetailsByUserCode_
		String jsonByUserCode = jedis.get("spider_queryMovieDetailsByUserCode_" + userCode);
		if (jsonByUserCode != null) {
			List<MovieDetails> dataByuserCode = JSON.parseArray(jsonByUserCode, MovieDetails.class);
			dataByuserCode.add(movieDetailsMapper.queryMovieDetailsByMid(mid).get(0));
			jedis.set("spider_queryMovieDetailsByUserCode_" + userCode, JSON.toJSONString(dataByuserCode));
		}
		// 更新该电影的所有评论_缓存: spider_QueryCommentsByMid_
		String jsonByMid = jedis.get("spider_QueryCommentsByMid_" + mid);
		if (jsonByMid != null) {
			List<MovieComment> dataByMid = JSON.parseArray(jsonByMid, MovieComment.class);
			dataByMid.add(movieComment);
			jedis.set("spider_QueryCommentsByMid_" + mid, JSON.toJSONString(dataByMid));
		}
	}

	/**
	 * 用户查询自己评论过的电影
	 * 
	 * @throws UserException
	 */
	public List<MovieDetails> queryMovieDetailsByUserCode(String userCode) throws UserException {

		if (userCode != null) {
			Jedis jedis = jedisPool.getResource();
			String data = jedis.get("spider_queryMovieDetailsByUserCode_" + userCode);
			if (data != null) {
				System.out.println("读取缓存数据" + data);
				return JSON.parseArray(data, MovieDetails.class);
			} else {
				// 查询
				List<MovieDetails> movieDetailsList = new ArrayList<>();
				List<MovieComment> MoveCommentList = movieCommentMapper.queryMovieCommentByUserCode(userCode);
				for (MovieComment movieComment : MoveCommentList) {
					String mid = movieComment.getMid();
					MovieDetails movieDetails = movieDetailsMapper.queryMovieDetailsByMid(mid).get(0);
					movieDetailsList.add(movieDetails);
				}
				// 查询后放入缓存
				jedis.set("spider_queryMovieDetailsByUserCode_" + userCode, JSON.toJSONString(movieDetailsList));
				return movieDetailsList;
			}
		} else {
			throw new UserException("登陆异常");
		}

	}

	/**
	 * 查询该电影的所有评论
	 * 
	 * @throws UserException
	 */
	public List<MovieComment> QueryCommentsByMid(String mid) throws UserException {

		if (mid != null) {
			Jedis jedis = jedisPool.getResource();
			String data = jedis.get("spider_QueryCommentsByMid_" + mid);

			if (data != null) {

				return JSON.parseArray(data, MovieComment.class);
			} else {
				// 查询后放入缓存
				List<MovieComment> MovieCommentList = movieCommentMapper.queryMovieCommentByMid(mid);
				jedis.set("spider_QueryCommentsByMid_" + mid, JSON.toJSONString(MovieCommentList));
				return MovieCommentList;
			}

		} else {
			throw new UserException("没有此电影");
		}
	}

}
