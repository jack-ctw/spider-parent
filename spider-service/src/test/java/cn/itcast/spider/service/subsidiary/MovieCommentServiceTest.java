package cn.itcast.spider.service.subsidiary;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieComment;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.MovieCommentService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieCommentServiceTest {
	
	@Autowired
	private MovieCommentService movieCommentService;
	
	@Test
	public void insertMovieCommentTest(){
		
		MovieComment movieComment = new MovieComment();
		movieComment.setId((long) 1);
		movieComment.setMid("644896");
		movieComment.setUserCode("test");
		movieComment.setComment("java is good");
		movieCommentService.insertMovieComment(movieComment);
	}
	
	@Test
	public void queryMovieDetailsByUserCodetes() throws UserException{
		
		List<MovieDetails> movieDetailsList = movieCommentService.queryMovieDetailsByUserCode("test");
		System.out.println(movieDetailsList.size());
	}
	
	@Test
	public void QueryCommentsByMidTest() throws UserException{
		
		List<MovieComment> commentsList = movieCommentService.QueryCommentsByMid("641515");
		System.out.println(commentsList.size());
	}
}
