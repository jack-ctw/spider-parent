package cn.itcast.spider.dao.mapper;

import java.util.List;

import cn.itcast.spider.entity.User;

public interface UserMapper {
	
	List<User> queryUserByUserCode(String userCode);
}
