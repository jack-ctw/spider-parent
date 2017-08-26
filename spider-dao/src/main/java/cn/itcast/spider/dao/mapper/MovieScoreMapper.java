package cn.itcast.spider.dao.mapper;

import java.util.List;

import cn.itcast.spider.entity.MovieScore;

public interface MovieScoreMapper{
	/**
	 * 唯一性查询 
	 */
	List<MovieScore> queryMovieScoreByMidAndUserCore(String mid,String UserCode);
	
	/**
	 * 查看该用户所有的电影评分
	 */
	List<MovieScore> queryMovieScoreByUserCode(String userCode);
	
	/**
	 * 查看该电影所有评分
	 */
	List<MovieScore> queryMovieScoreByMid(String Mid);
}
