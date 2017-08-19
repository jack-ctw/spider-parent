package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpiderController {
	
	@RequestMapping("/test")
	public String test1(){
		System.out.println(",,,");
		return "index";
	}
}
