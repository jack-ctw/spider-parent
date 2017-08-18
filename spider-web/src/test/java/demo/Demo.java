package demo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class Demo {
	

	/**
	 * 电影基本信息
	 * 
	 * @throws ParseException
	 */
	@Test
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
	}

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

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://m.cbooo.cn/Movie/GetTrend?mId=641515");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String data = EntityUtils.toString(entity, "UTF-8");
		System.out.println(data);
	}
	
	
	

}
