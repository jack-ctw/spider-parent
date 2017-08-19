package cn.itcast.spider.dto;

import java.util.List;

public class Data {
	//电影历史每日票房
	private List<HistoryBoxOffice> data1;
	
	public List<HistoryBoxOffice> getData1() {
		return data1;
	}

	public void setData1(List<HistoryBoxOffice> data1) {
		this.data1 = data1;
	}
}
