package cn.itcast.spider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.EveryDayBoxOfficeDao;
import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.pojo.EveryDayBoxOffice;
import cn.itcast.spider.pojo.MovieDetails;

@Service
public class TimingSpiderService {

	@Resource
	private MovieDetailsDao movieDetailsDao;
	@Resource
	private EveryDayBoxOfficeDao everyDayBoxOfficeDao;
	

	/**
	 * 持久化电影信息
	 * @param midList
	 */
	public void saveRankMovieDetails(List<String> midList){
		CboooSpiderService cboooService = new CboooSpiderService();
		for (String string : midList) {
			MovieDetails movieDetails = cboooService.movieDetails(string);
			movieDetailsDao.save(movieDetails);
		}
	}
	
	/**
	 * 持久化电影每日信息
	 * @param midList
	 */
	public void saveHistoryBoxOffice(List<String> midList){
		CboooSpiderService cboooService = new CboooSpiderService();
		//获取排行榜的电影
		for (String mid : midList) {
			//获得该电影每一天数据
			HistoryBoxOffice historyBoxOffice = cboooService.historyBoxOffice(mid);
			List<EveryDayBoxOffice> erveryDayBoxOfficeList = historyBoxOffice.getData1();
			for (EveryDayBoxOffice everyDayBoxOffice : erveryDayBoxOfficeList) {
				//保存每一天数据
				everyDayBoxOffice.setMid(mid);
				everyDayBoxOfficeDao.save(everyDayBoxOffice);
			}
		}
	}
}
