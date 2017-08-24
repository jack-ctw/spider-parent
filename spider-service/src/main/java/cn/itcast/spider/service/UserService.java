package cn.itcast.spider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.UserDao;
import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.MyException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	/**
	 * 用户注册
	 * @param user
	 * @return String
	 * @throws MyException 
	 */
	public void registered(User user) throws MyException{
		String message ="";
		 List<User> userList = userDao.findByUserCode(user.getUserCode());
		if (userList == null || userList.size() == 0) {
			userDao.save(user);
		} else {
			message="注册失败";
			throw new MyException(message);
		}
	}
	
	/**
	 * 用户登录             
	 * @param user
	 * @return
	 * @throws MyException 
	 */
	public User login(User user) throws MyException{
		String message="";
		List<User> userList = userDao.findByUserCode(user.getUserCode());
		
		if (userList == null || userList.size() ==0) {
			message="登录失败123";
			throw new MyException(message);
		}else{
			User exitUser = userList.get(0);
			if(user.getPassWord().equals(exitUser.getPassWord())){
				return exitUser;
			}else {
				message="登录失败456";
				throw new MyException(message);
			}
		}
	}
	
}
