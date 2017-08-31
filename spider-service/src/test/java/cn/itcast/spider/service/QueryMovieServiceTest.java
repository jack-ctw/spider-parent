package cn.itcast.spider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class QueryMovieServiceTest {
	
	@Autowired
	private QueryMovieService queryMovieService;
	
	@Test
	public void queryMovieDetailsByMidTest(){
		queryMovieService.queryMovieDetailsByMid("641515");
	}
	
	@Test
	public void everyDayBoxOfficeList(){
		queryMovieService.everyDayBoxOfficeList("641515");
	}
	
	@Test
	public void realtimeRank(){
		queryMovieService.realtimeRank();
	}
	
}
