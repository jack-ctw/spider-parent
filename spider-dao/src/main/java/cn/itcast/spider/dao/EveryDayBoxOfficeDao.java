package cn.itcast.spider.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.spider.entity.EveryDayBoxOffice;

public interface EveryDayBoxOfficeDao extends JpaRepository<EveryDayBoxOffice, String>{
	/*
	 * 根据mid查询电影
	 */
	List<EveryDayBoxOffice> findByMid(String mid);
	
}
