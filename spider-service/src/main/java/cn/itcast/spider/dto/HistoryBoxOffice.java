package cn.itcast.spider.dto;

import java.util.List;
/**
 * 单个电影历史每日的数据(所有)
 * @author jack
 *
 */
public class HistoryBoxOffice {
	//封装历史每日票房
	private List<EveryDayBoxOffice> historyBoxOffice;
	
	public List<EveryDayBoxOffice> gethistoryBoxOffice() {
		return historyBoxOffice;
	}

	public void sethistoryBoxOffice(List<EveryDayBoxOffice> historyBoxOffice) {
		this.historyBoxOffice = historyBoxOffice;
	}
}
