package cn.itcast.spider.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.jpa.UserDao;
import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.UserException;

@Service
public class UserWriterService {
	
	@Autowired
	private UserDao userDao;
	/**
	 * 用户注册
	 * @param user
	 * @return String
	 * @throws UserException 
	 */
	public void registered(User user) throws UserException{
		
		String message ="";
		 List<User> userList = userDao.findByUserCode(user.getUserCode());
		if (userList == null || userList.size() == 0) {
			userDao.save(user);
		} else {
			message="注册失败";
			throw new UserException(message);
		}
	}
	
}
