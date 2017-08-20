package cn.itcast.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.dto.MovieDetails;
import cn.itcast.spider.service.CboooSpiderService;

@Controller
public class SpiderController {
	
	@Autowired
	private CboooSpiderService cboooSpiderService;
	
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
	
	
	
}
