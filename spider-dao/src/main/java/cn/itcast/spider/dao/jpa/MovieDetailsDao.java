package cn.itcast.spider.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.itcast.spider.entity.MovieDetails;

public interface MovieDetailsDao extends JpaRepository<MovieDetails, String> {
	/*
	 * 根据mid查询电影
	 */
	List<MovieDetails> findByMid(String mid);

	/*
	 * out-of-date
	 * 更新电影实时票房和累计票房
	 */
	@Query(value = "UPDATE MovieDetails m SET m.realtimeBoxOffice =:realtimeBoxOffice,m.amountBoxOffice=:amountBoxOffice WHERE m.mid =:mid",nativeQuery = true)
	@Modifying
	void updateMovieDetailsByMid(@Param("realtimeBoxOffice") String realtimeBoxOffice,
			@Param("amountBoxOffice") String amountBoxOffice, @Param("mid") String mid);
}
