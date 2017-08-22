package cn.itcast.spider.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.spider.pojo.EveryDayBoxOffice;

public interface EveryDayBoxOfficeDao extends JpaRepository<EveryDayBoxOffice, String>{
	// 测试
	public List<EveryDayBoxOffice> findByMid(String mid);
}
