package cn.itcast.sprider.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.EveryDayBoxOfficeDao;
import cn.itcast.spider.pojo.EveryDayBoxOffice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext-dao.xml"})
public class EveryDayBoxOfficeTest {
	
	@Resource
	private EveryDayBoxOfficeDao erveryDayBoxOfficeDao;
	/*
	 *测试连接数据库 
	 */
	@Test
	public void findByNameTest(){
		List<EveryDayBoxOffice> list = erveryDayBoxOfficeDao.findByMid("test");
		System.out.println(list.get(0));
	}
}
