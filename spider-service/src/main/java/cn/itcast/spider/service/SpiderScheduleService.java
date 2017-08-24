package cn.itcast.spider.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void quartzTest() {
		System.out.println("成功执行...");
	}

	/**
	 * 持久化电影信息
	 * 
	 * @param midList
	 */
	@Transactional
	public void saveRankMovieDetails() {
		List<String> midList = cboooService.getMidList();
		for (String mid : midList) {
			// 查询出电影信息
			MovieDetails movieDetails = cboooService.movieDetails(mid);
			List<MovieDetails> movieDetailsList = movieDetailsDao.findByMid(mid);
			
			// 如果不存在这个电影
			if (movieDetailsList == null||movieDetailsList.size()==0) {
				movieDetails.setMid(mid);
				movieDetailsDao.save(movieDetails);
				System.out.println("成功添加电影信息:"+movieDetails.getName());
				
			} else {
				// 存在这个电影,则修改
				// 将mid传给爬下来的数据
				Long exitMid = movieDetailsList.get(0).getId();
				movieDetails.setId(exitMid);
				movieDetailsDao.save(movieDetails);
				System.out.println("成功更新电影信息:"+movieDetails.getName());
			}
		}
	
	}

	/**
	 * 持久化电影每日信息
	 * 
	 * @param midList
	 */
	public void saveHistoryBoxOffice() {
		List<String> midList = cboooService.getMidList();
		// 获取排行榜的电影
		for (String mid : midList) {
			// 获得该电影每一天数据
			HistoryBoxOffice historyBoxOffice = cboooService.historyBoxOffice(mid);
			List<EveryDayBoxOffice> erveryDayBoxOfficeList = historyBoxOffice.getData1();
			for (EveryDayBoxOffice everyDayBoxOffice : erveryDayBoxOfficeList) {
				if (everyDayBoxOfficeDao.findByMid(mid) == null) {
					// 表里没此mid,保存每一天数据
					everyDayBoxOffice.setMid(mid);
					everyDayBoxOfficeDao.save(everyDayBoxOffice);
				} else {
					// 有次mid,添加最后一个索引的值
				}
			}
		}
		System.out.println("持久化电影每日信息导入成功");
	}
}
