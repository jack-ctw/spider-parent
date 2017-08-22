package cn.itcast.spider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.pojo.MovieDetails;

@Service
public class SaveDataService {

	@Resource
	private MovieDetailsDao movieDetailsDao;

	
	/**
	 * 持久化电影信息
	 * 
	 */
	public void saveMovieDetails(String movieId){
		CboooSpiderService cboooSpiderService = new CboooSpiderService();
		MovieDetails movieDetails = cboooSpiderService.movieDetails(movieId);
		
	}
}
