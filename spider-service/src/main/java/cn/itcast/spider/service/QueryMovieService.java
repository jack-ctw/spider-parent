package cn.itcast.spider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.itcast.spider.dao.mapper.EveryDayBoxOfficeMapper;
import cn.itcast.spider.dao.mapper.MovieDetailsMapper;
import cn.itcast.spider.entity.EveryDayBoxOffice;
import cn.itcast.spider.entity.MovieDetails;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class QueryMovieService {

	@Autowired
	private EveryDayBoxOfficeMapper everyDayBoxOfficeMapper;
	@Autowired
	private MovieDetailsMapper movieDetailsMapper;
	@Autowired
	private JedisPool jedisPool;

	/**
	 * 根据电影Id获取电影详细信息
	 * 
	 */
	public MovieDetails queryMovieDetailsByMid(String mid) {

		Jedis jedis = jedisPool.getResource();

		try {
			String data = jedis.get("spider_queryMovieDetailsByMid_" + mid);

			if (data != null) {

				System.out.println("查询缓存得到" + data);
				return JSON.parseObject(data, MovieDetails.class);

			} else {
				// 查询后放入缓存
				MovieDetails movieDetails = movieDetailsMapper.queryMovieDetailsByMid(mid).get(0);
				jedis.set("spider_queryMovieDetailsByMid_" + mid, JSON.toJSONString(movieDetails));
				System.out.println("Redis..添加到缓存成功" + movieDetails);
				return movieDetails;

			}
		} finally {

			jedis.close();
		}

	}

	/**
	 * 根据电影Id获取电影每日票房信息
	 * 
	 */
	public List<EveryDayBoxOffice> everyDayBoxOfficeList(String mid) {

		Jedis jedis = jedisPool.getResource();

		try {

			String data = jedis.get("spider_everyDayBoxOfficeList_" + mid);

			if (data != null) {

				return JSON.parseArray(data, EveryDayBoxOffice.class);
			} else {
				// 查询后放入缓存
				List<EveryDayBoxOffice> everyDayBoxOfficeList = everyDayBoxOfficeMapper.queryEveryDayBoxOfficByMid(mid);
				jedis.set("spider_everyDayBoxOfficeList_" + mid, JSON.toJSONString(everyDayBoxOfficeList));
				return everyDayBoxOfficeList;

			}
		} finally {

			jedis.close();
		}

	}

}
