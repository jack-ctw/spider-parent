package cn.itcast.spider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.MyException;
import cn.itcast.spider.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 注册成功跳转到登录页面
	 * @param user
	 * @throws MyException 
	 * 
	 */
	@RequestMapping("/registered")
	public String registered(User user) throws MyException{
		userService.registered(user);
		return "login";
	}
	
	/**
	 * 登录成功跳转到首页
	 * @param user
	 * @return
	 * @throws MyException 
	 */
	@RequestMapping("/login")
	public String login(User user,Model model) throws MyException{
		User Exituser = userService.login(user);
		model.addAttribute(Exituser.getUserName());
		return "index";
	}
	
}
