package cn.itcast.spider.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.spider.entity.MovieComment;

public interface MovieCommentDao extends JpaRepository<MovieComment, String>{
	/**
	 * 	查询用户评论的所有评论
	 */
	List<MovieComment> findByUserCode(String userCode);
	
	/**
	 *	根据mid 和 userCode 查询
	 */
	List<MovieComment> findByMidAndUserCode(String mid,String userCode);
}
