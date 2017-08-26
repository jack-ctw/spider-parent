package cn.itcast.spider.service.primary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.MovieScoreWriterService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieScoreServiceTest {

	@Autowired
	private MovieScoreWriterService movieScoreService;
	
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
		movieScore.setUserCode("tom");
		movieScoreService.insertMovieScore(movieScore);
	}

}
