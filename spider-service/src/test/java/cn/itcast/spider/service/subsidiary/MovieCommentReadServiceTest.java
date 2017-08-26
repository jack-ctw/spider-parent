package cn.itcast.spider.service.subsidiary;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.mapper.MovieCommentMapper;
import cn.itcast.spider.dao.mapper.MovieDetailsMapper;
import cn.itcast.spider.entity.MovieComment;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.info.UserException;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieCommentReadServiceTest {
	
	@Autowired
	private MovieCommentReadService movieCommentReadService;

	/**
	 * 查询该电影的所有评论
	 * @throws UserException
	 */
	@Test
	public void QueryCommentsByMidTest() throws UserException{
		List<MovieComment> movieCommentList = movieCommentReadService.QueryCommentsByMid("641515");
		System.out.println(movieCommentList.size());
	}
	
	/**
	 * 用户查询自己评论过的电影 
	 * @throws UserException
	 */
	@Test
	public void queryMovieDetailsByUserCodeTest() throws UserException{
	 List<MovieDetails> movieDetailsList = movieCommentReadService.queryMovieDetailsByUserCode("test");
		System.out.println(movieDetailsList.size());
	}
}
