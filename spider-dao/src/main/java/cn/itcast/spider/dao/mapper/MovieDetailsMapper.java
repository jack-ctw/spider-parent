package cn.itcast.spider.dao.mapper;

import java.util.List;

import cn.itcast.spider.entity.MovieDetails;

public interface MovieDetailsMapper  {
	/**
	 * 根据mid查询电影
	 */
	List<MovieDetails> queryMovieDetailsByMid(String mid);

}
