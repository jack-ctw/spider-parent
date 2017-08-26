package cn.itcast.spider.service.primary;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.MovieComment;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.MovieCommentWriterService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class MovieCommentWriterServiceTest {
	
	@Autowired
	private MovieCommentWriterService movieCommentService;
	
	/**
	 * 测试新增一条评论
	 */
	@Test
	public void insertMovieCommentTest(){
		
		MovieComment movieComment = new MovieComment();
		movieComment.setId((long) 1);
		movieComment.setMid("644896");
		movieComment.setUserCode("test");
		movieComment.setComment("java is good");
		movieCommentService.insertMovieComment(movieComment);
	}

}
