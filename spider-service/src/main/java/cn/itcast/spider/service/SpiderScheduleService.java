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
			if (movieDetailsList == null || movieDetailsList.size() == 0) {
				movieDetails.setMid(mid);
				movieDetailsDao.save(movieDetails);
				System.out.println("成功添加电影信息:" + movieDetails.getName());
			} else {
				// 存在这个电影,则修改
				// id mid 传给查询的电影信息
				String exitMid = movieDetailsList.get(0).getMid();
				Long id = movieDetailsList.get(0).getId();
				movieDetails.setId(id);
				movieDetails.setMid(exitMid);
				movieDetailsDao.save(movieDetails);
				System.out.println("成功更新电影信息:" + movieDetails.getName());
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

			// 判断是否存在此mid的数据
			List<EveryDayBoxOffice> erveryDayBoxOfficeList = everyDayBoxOfficeDao.findByMid(mid);

			// 没mid,保存每一天数据
			if (everyDayBoxOfficeDao.findByMid(mid) == null || erveryDayBoxOfficeList.size() == 0) {
				List<EveryDayBoxOffice> ereryDayBoxOfficeList = historyBoxOffice.getData1();
				for (EveryDayBoxOffice everyDayBoxOffice : ereryDayBoxOfficeList) {
					everyDayBoxOffice.setMid(mid);
					everyDayBoxOfficeDao.save(everyDayBoxOffice);
					System.out.println("添加mid为"+mid+"电影"+everyDayBoxOffice.getInsertDate()+"号数据");
				}
			} else {
				// 有mid,将昨天的数据更新进表里 (每天8点更新)
				int lastIndex = historyBoxOffice.getData1().size()-2;
				EveryDayBoxOffice everyDayBoxOffice = historyBoxOffice.getData1().get(lastIndex);
				everyDayBoxOffice.setMid(mid);
				everyDayBoxOfficeDao.save(everyDayBoxOffice);
				System.out.println("更新mid为"+mid+"电影,"+everyDayBoxOffice.getInsertDate()+"号数据");
			}
			
		}
	}
}
