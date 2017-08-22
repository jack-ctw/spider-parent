package cn.itcast.spider.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;

import cn.itcast.spider.dto.EveryDayBoxOffice;
import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.dto.MovieDetails;
import cn.itcast.spider.dto.RealtimeBoxOffice;
import cn.itcast.spider.dto.RealtimeRank;
import cn.itcast.spider.service.CboooSpiderService;


public class CbooSpiderServiceTest {
	
	CboooSpiderService spiderService = new CboooSpiderService();
	
	
	/*
	 * 测试movieDetails接口
	 */
	@Test
	public void movieDetailsTest(){
		MovieDetails movieDetails = spiderService.movieDetails("641515");
		System.out.println(movieDetails);
	}
	
	/*
	 * 测试historyBoxOffice接口
	 */
	@Test 
	public void historyBoxOfficeTest(){
		HistoryBoxOffice historyBoxOffice = spiderService.historyBoxOffice("641515");
		System.out.println(historyBoxOffice.getData1());
	}
	/*
	 * 测试RealtimeRank接口
	 */
	@Test
	public void realtimeRankTest(){
		RealtimeRank realtimeRank = spiderService.realtimeRank();
		System.out.println(realtimeRank.getRealtimeAmountBoxOffice());
		List<RealtimeBoxOffice> list = realtimeRank.getAllRealtimeBoxOffice();
		for (RealtimeBoxOffice realtimeBoxOffice : list) {
			System.out.println(realtimeBoxOffice);
			System.out.println("============");
		}
	}
	/*
	 * 测试Jpa生成表测试 
	 * 根据类生成表
	 */
	@Test
	public void createTableByAPI(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(new MovieDetails().setFirstWeekendBoxOffice("123"));
		em.getTransaction().commit();
		emf.close();
	}
	

}
