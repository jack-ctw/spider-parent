package cn.itcast.spider.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * 实时票房排行榜
 * @author jack
 *
 */
@Entity
@Table(name="realtimeRank")
public class RealtimeRank implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id ;
	
	//实时总票房数
	private String realtimeAmountBoxOffice;
	//实时票房排行榜
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "realtimeBoxOffice")
	private List<RealtimeBoxOffice> allRealtimeBoxOffice;
	
	public List<RealtimeBoxOffice> getAllRealtimeBoxOffice() {
		return allRealtimeBoxOffice;
	}
	
	public void setAllRealtimeBoxOffice(List<RealtimeBoxOffice> allRealtimeBoxOffice) {
		this.allRealtimeBoxOffice = allRealtimeBoxOffice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getRealtimeAmountBoxOffice() {
		return realtimeAmountBoxOffice;
	}
	
	public RealtimeRank setRealtimeAmountBoxOffice(String realtimeAmountBoxOffice) {
		this.realtimeAmountBoxOffice = realtimeAmountBoxOffice;
		return this;
	}
	
}
