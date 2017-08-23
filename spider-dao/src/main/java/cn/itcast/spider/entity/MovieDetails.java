package cn.itcast.spider.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "movieDetails")
public class MovieDetails implements Serializable {
	// 可以根据纯在是否进行定时调度
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String mid;
	// 片名
	private String name;
	// 类型
	private String type;
	// 片长
	private String duration;
	// 上映时间
	private Date releaseTime;
	// 上映天数
	private String releasedDays;
	// 制式
	private String standard;
	// 国家地区
	private String country;
	// 发行公司
	private String company;
	// 今天实时票房
	private String realtimeBoxOffice;
	// 累计票房
	private String amountBoxOffice;
	// 点映票房
	private String experimentBoxOffice;
	// 首映票房
	private String firstDayBoxOffice;
	// 首周票房
	private String firstWeekBoxOffice;
	// 首周末票房
	private String firstWeekendBoxOffice;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getReleasedDays() {
		return releasedDays;
	}

	public void setReleasedDays(String releasedDays) {
		this.releasedDays = releasedDays;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRealtimeBoxOffice() {
		return realtimeBoxOffice;
	}

	public void setRealtimeBoxOffice(String realtimeBoxOffice) {
		this.realtimeBoxOffice = realtimeBoxOffice;
	}

	public String getAmountBoxOffice() {
		return amountBoxOffice;
	}

	public void setAmountBoxOffice(String amountBoxOffice) {
		this.amountBoxOffice = amountBoxOffice;
	}

	public String getExperimentBoxOffice() {
		return experimentBoxOffice;
	}

	public void setExperimentBoxOffice(String experimentBoxOffice) {
		this.experimentBoxOffice = experimentBoxOffice;
	}

	public String getFirstDayBoxOffice() {
		return firstDayBoxOffice;
	}

	public void setFirstDayBoxOffice(String firstDayBoxOffice) {
		this.firstDayBoxOffice = firstDayBoxOffice;
	}

	public String getFirstWeekBoxOffice() {
		return firstWeekBoxOffice;
	}

	public void setFirstWeekBoxOffice(String firstWeekBoxOffice) {
		this.firstWeekBoxOffice = firstWeekBoxOffice;
	}

	public String getFirstWeekendBoxOffice() {
		return firstWeekendBoxOffice;
	}

	// 为了生成表 暂时修改此方法
	public MovieDetails setFirstWeekendBoxOffice(String firstWeekendBoxOffice) {
		this.firstWeekendBoxOffice = firstWeekendBoxOffice;
		return this;
	}

}
