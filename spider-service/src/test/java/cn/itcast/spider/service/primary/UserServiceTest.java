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
	@Autowired
	private UserMapper UserMapper;
	
	@Test
	public void test(){
		List<User> userList = UserMapper.queryUserByUserCode("test");
		System.out.println(userList.size());
	}
	
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
	
	
}
