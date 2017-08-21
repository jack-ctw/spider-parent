package cn.itcast.spider.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 单个电影历史每日数据(1天)
 * @author jack
 *
 */
@Entity
@Table(name="everyDayBoxOffice")
public class EveryDayBoxOffice implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id ;
	// 日期
	private String InsertDate;
	// 星期几
	private String ReleaseDay;
	// 票房
	private String Boxoffice;
	// 票房占比
	private String BoxPercent;
	// 拍片占比
	private String ShowPercent;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getInsertDate() {
		return InsertDate;
	}

	public void setInsertDate(String insertDate) {
		InsertDate = insertDate;
	}

	public String getReleaseDay() {
		return ReleaseDay;
	}
	
	public void setReleaseDay(String releaseDay) {
		ReleaseDay = releaseDay;
	}
	
	public String getBoxoffice() {
		return Boxoffice;
	}
	
	public void setBoxoffice(String boxoffice) {
		Boxoffice = boxoffice;
	}
	
	public String getBoxPercent() {
		return BoxPercent;
	}
	
	public void setBoxPercent(String boxPercent) {
		BoxPercent = boxPercent;
	}
	
	public String getShowPercent() {
		return ShowPercent;
	}
	
	//为了生成表 暂时修改此方法
	public EveryDayBoxOffice setShowPercent(String showPercent) {
		ShowPercent = showPercent;
		return this;
	}
	
}
