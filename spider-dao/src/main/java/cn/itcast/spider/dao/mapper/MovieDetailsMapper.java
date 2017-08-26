package cn.itcast.spider.dao.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.itcast.spider.entity.MovieDetails;

public interface MovieDetailsMapper extends JpaRepository<MovieDetails, String> {
	/*
	 * 根据mid查询电影
	 */
	List<MovieDetails> queryMovieDetailsByMid(String mid);

}
