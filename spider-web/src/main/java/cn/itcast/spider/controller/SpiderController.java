package cn.itcast.spider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.spider.dao.EveryDayBoxOfficeDao;
import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.dto.RealtimeRank;
import cn.itcast.spider.entity.EveryDayBoxOffice;
import cn.itcast.spider.entity.MovieDetails;
import cn.itcast.spider.service.CboooSpiderService;

@Controller
public class SpiderController {

	@Autowired
	private CboooSpiderService cboooSpiderService;
	@Autowired
	private EveryDayBoxOfficeDao ereryDayBoxOfficeDao;
	@Autowired
	private MovieDetailsDao movieDetailsDao;

	/**
	 * 根据电影Id获取电影详细信息 url:http:127.0.0.1:8080/spider-web/movieDetails/641515
	 * 
	 * @param mid
	 * @return MovieDetails
	 */
	@RequestMapping("/movieDetails/{mid}")
	@ResponseBody
	public MovieDetails movieDetails(@PathVariable(value = "mid") String mid) {
		MovieDetails movieDetails = movieDetailsDao.findByMid(mid).get(0);
		return movieDetails;
	}

	/**
	 * 根据电影Id获取电影每日票房信息
	 * url:http:127.0.0.1:8080/spider-web/everyDayBoxOfficeList/641515
	 * 
	 * @param mid
	 * @return List<EveryDayBoxOffice>
	 */
	@RequestMapping("/everyDayBoxOfficeList/{mid}")
	@ResponseBody
	public List<EveryDayBoxOffice> everyDayBoxOfficeList(@PathVariable(value = "mid") String mid) {
		List<EveryDayBoxOffice> everyDayBoxOfficeList = ereryDayBoxOfficeDao.findByMid(mid);
		return everyDayBoxOfficeList;
	}

	/**
	 * 查询实时排行榜票房信息 url:http:127.0.0.1:8080/spider-web/realtimeRank
	 * @return RealtimeRank
	 * 
	 */
	@RequestMapping("/realtimeRank")
	@ResponseBody
	public RealtimeRank realtimeRank() {
		RealtimeRank realtimeRank = cboooSpiderService.realtimeRank();
		return realtimeRank;
	}

}
