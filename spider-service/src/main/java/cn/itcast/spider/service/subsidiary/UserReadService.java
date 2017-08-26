package cn.itcast.spider.service.subsidiary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.spider.dao.mapper.UserMapper;
import cn.itcast.spider.entity.User;
import cn.itcast.spider.info.UserException;

@Service
public class UserReadService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 用户登录             
	 * @param user
	 * @return
	 * @throws UserException 
	 */
	public User login(User user) throws UserException{
		
		String message="";
		List<User> userList = userMapper.queryUserByUserCode(user.getUserCode());
		
		if (userList == null || userList.size() ==0) {
			message="登录失败123";
			throw new UserException(message);
		}else{
			User exitUser = userList.get(0);
			if(user.getPassWord().equals(exitUser.getPassWord())){
				return exitUser;
			}else {
				message="登录失败456";
				throw new UserException(message);
			}
		}
	}
}
