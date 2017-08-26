package cn.itcast.spider.service.primary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.service.master.SpiderScheduleService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class SpiderScheduleServiceTest {

	@Autowired
	private SpiderScheduleService scheduleService;
	
	/**
	 *	测试添加avgScore的调度任务 
	 */
	@Test
	public void saveRankMovieDetailsTest(){
		
		scheduleService.saveRankMovieDetails();
	}
}
