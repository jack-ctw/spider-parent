package cn.itcast.spider.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieComment;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.MovieCommentService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieCommentServiceTest {
	
	@Autowired
	private MovieCommentService movieCommentService;
	
	/**
	 * 测试新增一条评论
	 */
	@Test
	public void insertMovieCommentTest(){
		
		MovieComment movieComment = new MovieComment();
		movieComment.setId((long) 1);
		movieComment.setMid("641515");
		movieComment.setUserCode("test");
		movieComment.setComment("java is good");
		movieCommentService.insertMovieComment(movieComment);
	}
	
	/**
	 * 查询该电影的所有评论
	 * @throws UserException
	 */
	@Test
	public void QueryCommentsByMidTest() throws UserException{
		List<MovieComment> movieCommentList = movieCommentService.QueryCommentsByMid("641515");
		System.out.println(movieCommentList.size());
	}
	
	/**
	 * 用户查询自己评论过的电影 
	 * @throws UserException
	 */
	@Test
	public void queryMovieDetailsByUserCodeTest() throws UserException{
	 List<MovieDetails> movieDetailsList = movieCommentService.queryMovieDetailsByUserCode("test");
		System.out.println(movieDetailsList.size());
	}

}
