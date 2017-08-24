package cn.itcast.spider.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.UserDao;
import cn.itcast.spider.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	/**
	 * 用户注册
	 * @param user
	 * @return String
	 */
	public void registered(User user){
		String messge ="";
		User exitUser = userDao.findByUserCode(user.getUserCode()).get(0);
		if (exitUser == null) {
			userDao.save(user);
		} else {
			messge="该账号已被注册";
		}
	}
	
	/**
	 * 用户登录             
	 * @param user
	 * @return
	 */
	public String login(User user){
		String message="";
		User exitUser = userDao.findByUserCode(user.getUserCode()).get(0);
		if (exitUser == null) {
			message="账号,请重新输入";
		}else{
			if(user.getPassWord()==exitUser.getPassWord()){
				message="登录ok";
			}else {
				message="密码错误,请重新输入";
			}
		}
		return message;
	}
	
}
