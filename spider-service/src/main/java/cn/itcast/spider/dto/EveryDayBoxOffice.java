package cn.itcast.spider.dto;

import java.io.Serializable;
/**
 * 单个电影历史每日数据(1天)
 * @author jack
 *
 */
public class EveryDayBoxOffice implements Serializable{
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
	
	public void setShowPercent(String showPercent) {
		ShowPercent = showPercent;
	}
	
	public String toString() {
		return "HistoryBoxOffice [InsertDate=" + InsertDate + ", ReleaseDay=" + ReleaseDay + ", Boxoffice=" + Boxoffice
				+ ", BoxPercent=" + BoxPercent + ", ShowPercent=" + ShowPercent + "]";
	}
}
