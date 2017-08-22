package cn.itcast.spider.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.pojo.MovieDetails;

@Service
public class SaveDataService {

	@Resource
	private MovieDetailsDao movieDetailsDao;
	

	public void saveMovieDetails(){
		
	}
}
