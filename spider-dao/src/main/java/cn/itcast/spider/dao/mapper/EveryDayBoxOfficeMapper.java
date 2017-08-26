package cn.itcast.spider.dao.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.spider.entity.EveryDayBoxOffice;

public interface EveryDayBoxOfficeMapper extends JpaRepository<EveryDayBoxOffice, String>{
	/*
	 * 根据mid查询电影
	 */
	List<EveryDayBoxOffice> queryEveryDayBoxOfficByMid(String mid);
	
}
