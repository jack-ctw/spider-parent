package cn.itcast.spider.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.spider.pojo.MovieDetails;

public interface MovieDetailsDao extends JpaRepository<MovieDetails, String>{
	//根据名字查询
	public List<MovieDetails> findByName(String name);
}	
