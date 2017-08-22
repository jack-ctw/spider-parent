package cn.itcast.sprider.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.pojo.MovieDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext-dao.xml"})							
public class MovieDetailsDaoTest {

	@Resource
	private MovieDetails movieDetails;
	@Autowired
	private MovieDetailsDao movieDetailsDao;
	
	@Test
	public void testfindByName(){
		System.out.println(movieDetailsDao);
		
	}
}
