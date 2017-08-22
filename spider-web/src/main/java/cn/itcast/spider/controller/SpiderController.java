package cn.itcast.spider.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.dto.RealtimeRank;
import cn.itcast.spider.pojo.MovieDetails;
import cn.itcast.spider.service.CboooSpiderService;
import cn.itcast.spider.service.TimingSpiderService;

@Controller
public class SpiderController {
	
	@Autowired
	private CboooSpiderService cboooSpiderService;
	
	@Autowired
	private TimingSpiderService timingSpiderService;
	
	/**
	 * 测试连接jsp
	 */
	@RequestMapping("test")
	public String test(){
		System.out.println("test");
		return "hello";
	}
	
	/**
	 * 根据电影Id获取电影详细信息
	 * url:http:127.0.0.1:8080/spider-web/movieDetails/641515
	 * @param mid
	 * @return MovieDetails
	 */
	@RequestMapping("/movieDetails/{mid}")
	@ResponseBody
	public MovieDetails movieDetails(@PathVariable(value="mid") String mid){
		MovieDetails movieDetails = cboooSpiderService.movieDetails(mid);
		return movieDetails;
	}
	
	/**
	 * 根据电影Id获取电影每日票房信息
	 * url:http:127.0.0.1:8080/spider-web/historyBoxOffice/641515
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
	 * url:http:127.0.0.1:8080/spider-web/realtimeRank
	 * @return RealtimeRank
	 */
	@RequestMapping("/realtimeRank")
	@ResponseBody
	public RealtimeRank realtimeRank(){
		RealtimeRank realtimeRank = cboooSpiderService.realtimeRank();
		return realtimeRank;
	}
	
	/**
	 * 更新电影详细信息
	 * url:http:127.0.0.1:8080/spider-web/updateMovieDetails
	 * 
	 */
	@RequestMapping("/updateMovieDetails")
	public String updateData(){
		timingSpiderService.saveRankMovieDetails(cboooSpiderService.GetMidList());
		return "SUCCESS";
	}
	
	
}
