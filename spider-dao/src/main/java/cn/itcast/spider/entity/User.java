package cn.itcast.spider.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String userName;
	
	private String userCode;
	
	private String passWord;
	
	private Integer age;
	
	private String sex;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserCode() {
		return userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public User setSex(String sex) {
		this.sex = sex;
		return this;
	}
}
