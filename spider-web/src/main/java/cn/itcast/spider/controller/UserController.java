package cn.itcast.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.spider.entity.User;
import cn.itcast.spider.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 注册成功跳转到登录页面
	 * @param user
	 * 
	 */
	@RequestMapping("/registered")
	public String registered(User user){
		userService.registered(user);
		return "login";
	}
	
	/**
	 * 登录成功跳转到首页
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user){
		userService.login(user);
		return "index";
	}
	
	
	
}
