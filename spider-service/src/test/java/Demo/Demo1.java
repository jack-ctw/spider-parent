package Demo;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.dto.EveryDayBoxOffice;
import cn.itcast.spider.dto.MovieDetails;
import cn.itcast.spider.dto.RealtimeBoxOffice;
import cn.itcast.spider.dto.RealtimeRank;
import cn.itcast.spider.service.CboooSpiderService;

public class Demo1 {
	CboooSpiderService spiderService = new CboooSpiderService();
	
	/*
	 * 测试movieDetails接口
	 */
	@Test
	public void test1(){
		MovieDetails movieDetails = spiderService.movieDetails("641515");
		System.out.println(movieDetails);
	}
	
	/*
	 * 测试historyBoxOffice接口
	 */
	@Test 
	public void test2(){
		HistoryBoxOffice historyBoxOffice = spiderService.historyBoxOffice("641515");
		System.out.println(historyBoxOffice.gethistoryBoxOffice());
		
	}
	/*
	 * 测试RealtimeRank接口
	 */
	@Test
	public void test3(){
		RealtimeRank realtimeRank = spiderService.realtimeRank();
		System.out.println(realtimeRank.getRealtimeAmountBoxOffice());
		List<RealtimeBoxOffice> list = realtimeRank.getAllRealtimeBoxOffice();
		for (RealtimeBoxOffice realtimeBoxOffice : list) {
			System.out.println(realtimeBoxOffice);
			System.out.println("============");
		}
	}

}
