package cn.itcast.spider.dto;

import java.io.Serializable;
import java.util.Date;

public class MovieDetails implements Serializable{
	//TODO 注释
	private String name;
	
	private String type;
	
	private String duration;
	
	private Date releaseTime;
	
	private String releasedDays;
	
	private String standard;
	
	private String country;
	
	private String company;
	
	private String realtimeBoxOffice;
	
	private String amountBoxOffice;
	
	private String experimentBoxOffice;
	
	private String firstDayBoxOffice;
	
	private String firstWeekBoxOffice;
	
	private String firstWeekendBoxOffice;
	
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
	
	public void setFirstWeekendBoxOffice(String firstWeekendBoxOffice) {
		this.firstWeekendBoxOffice = firstWeekendBoxOffice;
	}
	
	public String toString() {
		return "MovieDetails [name=" + name + ", type=" + type + ", duration=" + duration + ", releaseTime="
				+ releaseTime + ", releasedDays=" + releasedDays + ", standard=" + standard + ", country=" + country
				+ ", company=" + company + ", realtimeBoxOffice=" + realtimeBoxOffice + ", amountBoxOffice="
				+ amountBoxOffice + ", experimentBoxOffice=" + experimentBoxOffice + ", firstDayBoxOffice="
				+ firstDayBoxOffice + ", firstWeekBoxOffice=" + firstWeekBoxOffice + ", firstWeekendBoxOffice="
				+ firstWeekendBoxOffice + "]";
	}

}
