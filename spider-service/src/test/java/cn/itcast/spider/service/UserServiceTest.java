package cn.itcast.spider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	

	@Test
	public void registeredTest(){
		
		try {
			User user = new User();
			user.setUserCode("test1");
			user.setPassWord("test1");
			userService.registered(user);
		} catch (UserException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest() throws UserException{
		User user = new User();
		user.setUserCode("test");
		user.setPassWord("test");
		User user2 = userService.login(user);
		System.out.println(user2.getUserCode());
	}
	
	@Test
	public void springCacheTest() throws UserException{
		User user = new User();
		user.setUserCode("test");
		user.setPassWord("test");
		System.out.println("第一次登陆");
		userService.login(user);
		System.out.println("第二次登陆");
		userService.login(user);
		
	}
	
	
}
