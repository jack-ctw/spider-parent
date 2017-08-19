package cn.itcast.spider.dto;

import java.util.List;
/**
 * 实时票房排行榜
 * @author jack
 *
 */
public class RealtimeRank {
	//实时总票房数
	private String realtimeAmountBoxOffice;
	//实时票房排行榜
	private List<RealtimeBoxOffice> allRealtimeBoxOffice;
	
	public String getRealtimeAmountBoxOffice() {
		return realtimeAmountBoxOffice;
	}
	
	public void setRealtimeAmountBoxOffice(String realtimeAmountBoxOffice) {
		this.realtimeAmountBoxOffice = realtimeAmountBoxOffice;
	}
	
	public List<RealtimeBoxOffice> getAllRealtimeBoxOffice() {
		return allRealtimeBoxOffice;
	}
	
	public void setAllRealtimeBoxOffice(List<RealtimeBoxOffice> allRealtimeBoxOffice) {
		this.allRealtimeBoxOffice = allRealtimeBoxOffice;
	}
}
