package cn.itcast.spider.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.itcast.spider.dto.MovieDetails;

public class CboooSpiderService {

	public Object realtimeRank() {

		return null;
	}

	/**
	 * 获取电影具体信息
	 * 
	 * @param movieId
	 * @return MovieDetails
	 */
	public MovieDetails movieDetails(String movieId) {

		MovieDetails movieDetails = new MovieDetails();
		try {
			Document doc = Jsoup.connect("http://m.cbooo.cn/Movie/MovieDetails?Mid=" + movieId).data("query", "Java")
					.userAgent("Mozilla").cookie("auth", "token").timeout(3000).post();
			// 电影基本信息
			Elements select = doc.getElementById("detail_head").select("p");
			String name = doc.getElementById("detail_head").select("h2").text();
			String type = select.get(0).select("span").get(1).text();
			String duration = select.get(1).select("span").get(1).text();
			String releaseTime = select.get(2).select("span").get(1).text();
			String releasedDays = select.get(3).select("span").get(1).text();
			String standard = select.get(4).select("span").get(1).text();
			String country = select.get(5).select("span").get(1).text();
			String company = select.get(6).select("span").get(1).text();
			// 封装电影基本信息
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(releaseTime);
			movieDetails.setName(name);
			movieDetails.setType(type);
			movieDetails.setDuration(duration);
			movieDetails.setReleaseTime(date);
			movieDetails.setReleasedDays(releasedDays);
			movieDetails.setStandard(standard);
			movieDetails.setCountry(country);
			movieDetails.setCompany(company);
			// 电影票房信息
			Elements select2 = doc.getElementById("detail_body").select("li");
			String realtimeBoxOffice = select2.get(0).select("p").get(1).text();
			String amountBoxOffice = select2.get(1).select("p").get(1).text();
			String experimentBoxOffice = select2.get(2).select("p").get(1).text();
			String firstDayBoxOffice = select2.get(3).select("p").get(1).text();
			String firstWeekBoxOffice = select2.get(4).select("p").get(1).text();
			String firstWeekendBoxOffice = select2.get(5).select("p").get(1).text();
			// 封装电影票房信息
			movieDetails.setRealtimeBoxOffice(realtimeBoxOffice);
			movieDetails.setAmountBoxOffice(amountBoxOffice);
			movieDetails.setExperimentBoxOffice(experimentBoxOffice);
			movieDetails.setFirstDayBoxOffice(firstDayBoxOffice);
			movieDetails.setFirstWeekBoxOffice(firstWeekBoxOffice);
			movieDetails.setFirstWeekendBoxOffice(firstWeekendBoxOffice);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return movieDetails;
	}

	public Object historyBoxOffice(String movieId) {

		return null;
	}
}
