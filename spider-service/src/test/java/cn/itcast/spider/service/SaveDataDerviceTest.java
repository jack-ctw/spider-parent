package cn.itcast.spider.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.pojo.MovieDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext-dao.xml"})
public class SaveDataDerviceTest {
	
	@Resource
	private MovieDetailsDao movieDetailsDao;
	
	@Test
	public void saveMovieDetailsTest(){
		CboooSpiderService cbsevice = new CboooSpiderService();
		System.out.println(movieDetailsDao);
		MovieDetails movieDetails = cbsevice.movieDetails("641515");
		movieDetailsDao.save(movieDetails);
		
	}
}
