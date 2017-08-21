package cn.itcast.spider.controller;

import java.io.IOException;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class Demo {
	
	@Test
	public void test3(){
		try {
			Document doc = Jsoup.connect("http://m.cbooo.cn/").data("query", "Java")
					.userAgent("Mozilla").cookie("auth", "token").timeout(3000).get();
			String AllrealtimeBoxOffice = doc.select("h3").select("span").get(0).text();
			System.out.println(AllrealtimeBoxOffice);
			Elements elements = doc.getElementsByClass("js_bg").select("tbody").select("tr");
			String[] split = elements.get(0).text().split(" ");
			String name = split[0];
			String amountBoxOffice = split[1];
			String releasedDays = split[2];
			String realtimeBoxOffice = split[3];
			String boxOfficeRatio = split[4];
			String screeningRatio = split[5];
			String tomorrowScreenings = split[6];
			for (String string : split) {
				System.out.println(string);
			}
			System.out.println("=============");
			System.out.println(name);
			System.out.println(amountBoxOffice);
			System.out.println(releasedDays);
			System.out.println(realtimeBoxOffice);
			System.out.println(boxOfficeRatio);
			System.out.println(screeningRatio);
			System.out.println(tomorrowScreenings);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 电影基本信息
	 * 
	 * @throws ParseException
	 */
/*	@Test
	public void test1() throws ParseException {
		// 解析html文档 ,底层运用了httpclien
		try {
			Document doc = Jsoup.connect("http://m.cbooo.cn/Movie/MovieDetails?Mid=641515").data("query", "Java")
					.userAgent("Mozilla").cookie("auth", "token").timeout(3000).post();

			// 电影基本信息
			Elements select = doc.getElementById("detail_head").select("p");
			System.out.println(doc.getElementById("detail_head").select("h2").text());
			System.out.println(select.size());
			String type = select.get(0).select("span").get(1).text();
			String duration = select.get(1).select("span").get(1).text();
			String releaseTime = select.get(2).select("span").get(1).text();
			String releasedDays = select.get(3).select("span").get(1).text();
			String standard = select.get(4).select("span").get(1).text();
			String country = select.get(5).select("span").get(1).text();
			String company = select.get(6).select("span").get(1).text();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(releaseTime);
			System.out.println(date);
			System.out.println(releaseTime);
			System.out.println(type);
			System.out.println(company);

			// 电影票房信息
			Elements select2 = doc.getElementById("detail_body").select("li");
			String realtimeBoxOffice = select2.get(0).select("p").get(1).text();
			String amountBoxOffice = select2.get(1).select("p").get(1).text();
			String experimentBoxOffice = select2.get(2).select("p").get(1).text();
			String firstDayBoxOffice = select2.get(3).select("p").get(1).text();
			String firstWeekBoxOffice = select2.get(4).select("p").get(1).text();
			String firstWeekendBoxOffice = select2.get(5).select("p").get(1).text();
			
			for (Element element : select2) {
				System.out.println(element.select("p").get(1).text());
			}
			System.out.println("===============");
			System.out.println(realtimeBoxOffice);
			System.out.println(amountBoxOffice);
			System.out.println(experimentBoxOffice);
			System.out.println(firstDayBoxOffice);
			System.out.println(firstWeekBoxOffice);
			System.out.println(firstWeekendBoxOffice);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * 电影每日数据
	 * 
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {

		/*
		 * 请求成功否 CloseableHttpClient httpClient = HttpClients.createDefault();
		 * HttpGet httpGet = new
		 * HttpGet("http://m.cbooo.cn/Movie/MovieDetails?Mid=641515");
		 * CloseableHttpResponse response1 = httpClient.execute(httpGet);
		 * System.out.println(response1.getStatusLine()); HttpEntity entity1 =
		 * response1.getEntity(); EntityUtils.consume(entity1);
		 * response1.close();
		 */
		//方式一
		/*Document doc = Jsoup.connect("http://m.cbooo.cn/Movie/GetTrend?mId=641515").data("query", "Java")
				.userAgent("Mozilla").cookie("auth", "token").timeout(3000).get();
		Element element = doc.getElementById("GetTrend");
		System.out.println(doc);
		System.out.println(element);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://m.cbooo.cn/Movie/GetTrend?mId=641515");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String data = EntityUtils.toString(entity, "UTF-8");
		
		System.out.println(data);*/
		
	}
	
	
	

}
