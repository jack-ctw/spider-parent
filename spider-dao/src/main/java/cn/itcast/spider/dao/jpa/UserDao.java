package cn.itcast.spider.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.spider.entity.User;


public interface UserDao extends JpaRepository<User, String>{
	/*
	 * 判断用户是否存在
	 */
	List<User> findByUserCode(String userCode);
}
