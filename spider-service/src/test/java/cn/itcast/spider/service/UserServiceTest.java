package cn.itcast.spider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.UserException;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void registeredTest(){
		
		try {
			User user = new User();
			user.setId((long) 1);
			user.setUserCode("test");
			user.setPassWord("test");
			userService.registered(user);
		} catch (UserException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest(){
		
		try {
			User user = new User();
			user.setId((long) 1);
			user.setUserCode("test");
			user.setPassWord("test");
			User login = userService.login(user);
			System.out.println(login.getUserCode());
		} catch (UserException e) {
			System.out.println("...");
			e.printStackTrace();
		}
	}
}
