package cn.itcast.spider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.spider.dao.jpa.EveryDayBoxOfficeDao;
import cn.itcast.spider.dao.jpa.MovieDetailsDao;
import cn.itcast.spider.dao.mapper.MovieDetailsMapper;
import cn.itcast.spider.dto.HistoryBoxOffice;
import cn.itcast.spider.entity.EveryDayBoxOffice;
import cn.itcast.spider.entity.MovieDetails;
import redis.clients.jedis.JedisPool;
/**
 * 定时调度模块
 * @author jack
 *
 */
//组件
@Component
public class SpiderScheduleService {

	@Autowired
	private MovieDetailsDao movieDetailsDao;
	@Autowired
	private EveryDayBoxOfficeDao everyDayBoxOfficeDao;
	@Autowired
	private CboooSpiderService cboooService;
	@Autowired
	private MovieScoreService movieScoreService;
	@Autowired
	private MovieDetailsMapper movieDetailsMapper;
	@Autowired
	private JedisPool jedisPool;
	

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
				String avgScore = movieScoreService.getAvgScore(mid);
				movieDetails.setAvgScore(avgScore);
				movieDetailsDao.save(movieDetails);
				System.out.println("成功添加电影信息:" + movieDetails.getName());
			} else {
				// 存在这个电影,则修改
				// id mid 传给查询的电影信息
				MovieDetails movieDetails2 = movieDetailsList.get(0);
				movieDetails2.setAmountBoxOffice(movieDetails.getAmountBoxOffice());
				movieDetails2.setExperimentBoxOffice(movieDetails.getExperimentBoxOffice());
				movieDetails2.setFirstDayBoxOffice(movieDetails.getFirstDayBoxOffice());
				movieDetails2.setFirstWeekBoxOffice(movieDetails.getFirstWeekBoxOffice());
				movieDetails2.setFirstWeekendBoxOffice(movieDetails.getFirstWeekendBoxOffice());
				movieDetails2.setRealtimeBoxOffice(movieDetails.getRealtimeBoxOffice());
				// 设置平均分 细心
				String avgScore = movieScoreService.getAvgScore(mid);
				movieDetails2.setAvgScore(avgScore);
				movieDetailsDao.save(movieDetails2);
				// 清空缓存
				jedisPool.getResource().del("spider_queryMovieDetailsByMid_"+mid);
				System.out.println("成功更新电影信息:" + movieDetails.getName());
			}
		}
		

	}

	/**
	 * 持久化电影每日信息
	 * 
	 * @param midList
	 */
	@Transactional
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
				
				//	清空缓存
				jedisPool.getResource().del("spider_everyDayBoxOfficeList_"+mid);
				System.out.println("更新mid为"+mid+"电影,"+everyDayBoxOffice.getInsertDate()+"号数据");
			}
		}
	}
	

}
