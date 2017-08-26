package cn.itcast.spider.service.primary;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.dao.mapper.UserMapper;
import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.UserException;
import cn.itcast.spider.service.master.UserWriterService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserWriterService userService;
	

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
	
	
}
