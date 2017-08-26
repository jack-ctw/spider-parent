package cn.itcast.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.UserWriterService;
import cn.itcast.spider.service.subsidiary.UserReadService;

@Controller
public class UserController {
	
	@Autowired
	private UserWriterService userWriterService;
	@Autowired
	private UserReadService userReadService;
	
	/**
	 * 注册成功跳转到登录页面
	 * @param user
	 * @throws UserException 
	 * 
	 */
	@RequestMapping("/registered")
	public String registered(User user) throws UserException{
		
		userWriterService.registered(user);
		return "login";
	}
	
	/**
	 * 登录成功跳转到首页
	 * @param user
	 * @return
	 * @throws UserException 
	 */
	@RequestMapping("/login")
	public String login(User user,Model model) throws UserException{
		
		User Exituser = userReadService.login(user);
		// 将查询的user传给页面
		model.addAttribute(Exituser);
		return "index";
	}
	
}
