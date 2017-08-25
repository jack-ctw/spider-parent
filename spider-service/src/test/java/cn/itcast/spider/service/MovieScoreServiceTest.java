package cn.itcast.spider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.info.UserException;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieScoreServiceTest {

	@Autowired
	private MovieScoreService movieScoreService;
	
	/**
	 * 测试评分
	 * @throws UserException 
	 */
	@Test
	public void insertMovieScoreTest() throws UserException{
		
		MovieScore movieScore = new MovieScore();
		movieScore.setId((long) 1);
		movieScore.setMid("641515");
		movieScore.setScore(80);
		movieScore.setUserCode("jack");
		movieScoreService.insertMovieScore(movieScore);
	}
	
	/**
	 * 测试统计平均分
	 */
	@Test
	public void getAvgScoreTest(){
		
		String avgScore = movieScoreService.getAvgScore("641515");
		System.out.println(avgScore);
	}
}
