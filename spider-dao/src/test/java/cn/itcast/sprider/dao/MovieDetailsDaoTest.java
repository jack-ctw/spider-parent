package cn.itcast.sprider.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.MovieDetailsDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext-dao.xml"})							
public class MovieDetailsDaoTest {

	@Resource
	private MovieDetailsDao movieDetailsDao;
	
	@Test
	public void testfindByName(){
		System.out.println(movieDetailsDao.findByName("test").get(0));
	}
}
