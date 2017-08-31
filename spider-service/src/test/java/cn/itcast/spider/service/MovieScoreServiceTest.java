package cn.itcast.spider.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.MovieScoreService;

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
		movieScore.setMid("666143");
		movieScore.setScore(80);
		movieScore.setUserCode("test");
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
	
	@Test
	public void selectMovieDetailsByUserCodeTest() throws UserException{
		
		List<MovieDetails> movieDetailsList = movieScoreService.selectMovieDetailsByUserCode("test");
		System.out.println(movieDetailsList.size());
	}

}
