package cn.itcast.spider.info;

/**
 * 自定义异常类
 * @author jack
 *
 */
public class MyException extends Exception{

	private static final long serialVersionUID = 1L;
	//异常信息
	private String message;
	
	public MyException(){
		super();
	}
	
	public MyException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
