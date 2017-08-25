package cn.itcast.spider.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieComment;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieCommentServiceTest {
	
	@Autowired
	private MovieCommentService movieCommentService;
	
	@Test
	public void QueryCommentsByUserTest(){
		List<MovieComment> commentsByuserCode = movieCommentService.QueryCommentsByUser("test");
		System.out.println(commentsByuserCode.size());
	}
}
