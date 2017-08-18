package Demo;

import org.junit.Test;

import cn.itcast.spider.dto.MovieDetails;
import cn.itcast.spider.service.CboooSpiderService;

public class Demo1 {
	
	@Test
	public void test1(){
		CboooSpiderService spiderService = new CboooSpiderService();
		MovieDetails movieDetails = spiderService.movieDetails("641515");
		System.out.println(movieDetails);
	}
}
