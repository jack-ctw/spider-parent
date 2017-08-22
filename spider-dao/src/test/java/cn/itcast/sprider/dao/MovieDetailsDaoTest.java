package cn.itcast.sprider.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.EveryDayBoxOfficeDao;
import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.pojo.EveryDayBoxOffice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext-dao.xml"})							
public class MovieDetailsDaoTest {

	@Resource
	private MovieDetailsDao movieDetailsDao;
	@Resource
	private EveryDayBoxOfficeDao everyDayBoxOfficeDao;
	
	/*	
	 *	测试连通数据库
	 */
	@Test
	public void testfindByName(){
		//System.out.println(movieDetailsDao);
		System.out.println(movieDetailsDao.findByName("test").get(0));
	}
	
	
	
	
}
