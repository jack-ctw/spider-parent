package cn.itcast.spider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.EveryDayBoxOfficeDao;
import cn.itcast.spider.dao.MovieDetailsDao;
import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.entity.EveryDayBoxOffice;
import cn.itcast.spider.entity.MovieDetails;

//组件
@Component
public class SpiderScheduleService {

	@Autowired
	private MovieDetailsDao movieDetailsDao;
	@Autowired
	private EveryDayBoxOfficeDao everyDayBoxOfficeDao;
	@Autowired
	private CboooSpiderService cboooService;
	
	/**
	 * 测试Quartz
	 */
	public void quartzTest(){
		System.out.println("成功执行...");
	}

	/**
	 * 持久化电影信息
	 * @param midList
	 */
	public void saveRankMovieDetails(){
		List<String> midList = cboooService.getMidList();
		for (String string : midList) {
			MovieDetails movieDetails = cboooService.movieDetails(string);
			movieDetails.setMid(string);
			movieDetailsDao.save(movieDetails);
		}
		System.out.println("持久化电影信息导入成功");
	}
	
	/**
	 * 持久化电影每日信息
	 * @param midList
	 */
	public void saveHistoryBoxOffice(){
		List<String> midList = cboooService.getMidList();
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
		System.out.println("持久化电影每日信息导入成功");
	}
}
