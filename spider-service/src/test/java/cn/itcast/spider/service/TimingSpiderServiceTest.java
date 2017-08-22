package cn.itcast.spider.service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.pojo.MovieDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/applicationContext-*.xml"})
public class TimingSpiderServiceTest {
	
	TimingSpiderService timingSpiderService = new TimingSpiderService();
	/*
	 * 测试失败 
	 * 老师解释不能读取xml
	 */
	@Test
	public void saveRankMovieDetailsTest(){
		saveRankMovieDetailsTest();
	}
	
	
	
}
