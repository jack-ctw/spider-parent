package cn.itcast.spider.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MovieScore")
public class MovieScore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// 电影mid
	private String mid;
	// 用户账号
	private String userCode;
	// 电影得分
	private Integer score;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getUserCode() {
		return userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public MovieScore setScore(Integer score) {
		this.score = score;
		return this;
	}

}
