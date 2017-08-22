package cn.itcast.spider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.pojo.MovieDetails;

@Service
public class TimingSpiderService {

	@Resource
	private MovieDetailsDao movieDetailsDao;

	/**
	 * 持久化电影信息
	 * 
	 */
	public void saveRankMovieDetails(List<String> midList){
		CboooSpiderService cboooService = new CboooSpiderService();
		for (String string : midList) {
			MovieDetails movieDetails = cboooService.movieDetails(string);
			movieDetailsDao.save(movieDetails);
		}
	}
}
