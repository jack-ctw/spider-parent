package cn.itcast.spider.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.spider.entity.User;


public interface UserDao extends JpaRepository<User, String>{
	List<User> findByUserCode(String userCode);
}
