package cn.itcast.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.dto.MovieDetails;
import cn.itcast.spider.dto.RealtimeRank;
import cn.itcast.spider.service.CboooSpiderService;

@Controller
public class SpiderController {
	
	@Autowired
	private CboooSpiderService cboooSpiderService;
	
	/**
	 * 测试连接jsp
	 * 
	 */
	@RequestMapping("test")
	public String test(){
		System.out.println("hello");
		return "hello";
	}
	
	/**
	 * 根据电影Id获取电影详细信息
	 * url:http:127.0.0.1:8080//spider-web/movieDetails/641515
	 * @param mid
	 * @return MovieDetails
	 */
	@RequestMapping("/movieDetails/{mid}")
	@ResponseBody
	public MovieDetails test2(@PathVariable(value="mid") String mid){
		MovieDetails movieDetails = cboooSpiderService.movieDetails(mid);
		return movieDetails;
	}
	
	/**
	 * 根据电影Id获取电影每日票房信息
	 * url:http:127.0.0.1:8080//spider-web/historyBoxOffice/641515
	 * @param mid
	 * @return HistoryBoxOffice
	 */
	@RequestMapping("/historyBoxOffice/{mid}")
	@ResponseBody
	public HistoryBoxOffice historyBoxOffice(@PathVariable(value="mid") String mid){
		HistoryBoxOffice historyBoxOffice = cboooSpiderService.historyBoxOffice(mid);
		return historyBoxOffice;
	}
	
	/**
	 * 查询实时排行榜票房信息
	 * url:http:127.0.0.1:8080//spider-web/realtimeRank
	 * @return RealtimeRank
	 */
	@RequestMapping("/realtimeRank")
	@ResponseBody
	public RealtimeRank realtimeRank(){
		RealtimeRank realtimeRank = cboooSpiderService.realtimeRank();
		return realtimeRank;
	}
	
}
