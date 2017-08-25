package cn.itcast.spider.excepiton;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.spider.info.UserException;

/**
 * 自定义异常处理解析器
 * 
 * @author jack
 *
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object objcet,
			Exception exception) {
		UserException myException = null;
		if (exception instanceof UserException) {
			myException = (UserException) exception;
		} else {
			myException = new UserException("未知异常");
		}
		ModelAndView mav = new ModelAndView();
		// 根据异常信息处理
		String message = myException.getMessage();
		if (message.equals("注册失败")) {
			mav.addObject("该账号已经存在,请重注册");
			mav.setViewName("registered");
		} else if (message.equals("登录失败")) {
			mav.addObject("账号密码有误,请重新输入");
			mav.setViewName("login");
		} else {
			mav.addObject(message);
			mav.setViewName("error");
		}
		return mav;
	}

}
