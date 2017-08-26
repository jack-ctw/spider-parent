package cn.itcast.spider.service.subsidiary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.UserException;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserReadServiceTest {
	

	@Autowired
	private UserReadService userQueryService;
	
	
	@Test
	public void loginTest() throws UserException{
		User user = new User();
		user.setUserCode("test");
		user.setPassWord("test");
		User user2 = userQueryService.login(user);
		System.out.println(user2.getUserCode());
	}
	

	

}
