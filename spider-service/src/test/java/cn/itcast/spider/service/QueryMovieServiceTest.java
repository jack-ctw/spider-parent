package cn.itcast.spider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class QueryMovieServiceTest {
	
	@Autowired
	private QueryMovieService queryMovieService;
	
	@Test
	public void connectRedisTest(){
		
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("test", "test");
		System.out.println(jedis.get("test"));
		jedis.close();
	}
	
	@Test
	public void jedisPoolTest(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
		Jedis jedis = jedisPool.getResource();
		jedis.set("test", "jedisPool");
		System.out.println(jedis.get("test"));
		jedis.close();
		jedisPool.close();
	}
	
	@Test
	public void queryMovieDetailsByMidTest(){
		queryMovieService.queryMovieDetailsByMid("641515");
	}
	
	@Test
	public void everyDayBoxOfficeList(){
		queryMovieService.everyDayBoxOfficeList("641515");
	}
	
}
