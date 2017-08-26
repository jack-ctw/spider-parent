package cn.itcast.spider.service.subsidiary;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.entity.MovieScore;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.MovieScoreWriterService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieScoreWriterServiceTest {

	@Autowired
	private MovieScoreReadService movieScoreReadService;

	
	/**
	 * 测试统计平均分
	 */
	@Test
	public void getAvgScoreTest(){
		String avgScore = movieScoreReadService.getAvgScore("641515");
		System.out.println(avgScore);
	}
	
	@Test
	public void selectMovieDetailsByUserCodeTest() throws UserException{
		List<MovieDetails> movieDetailsList = movieScoreReadService.selectMovieDetailsByUserCode("test");
		System.out.println(movieDetailsList.size());
	}
}
