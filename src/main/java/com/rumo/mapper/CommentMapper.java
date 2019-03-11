package com.rumo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rumo.pojo.Comment;

/**
 * 
 * todo:文章评论
 * Comment<br/>
 * 创建人:中华墨风<br/>
 * 时间：2018年11月11日 21:36:28 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface CommentMapper {
	//添加
	public int saveComment(Comment comment);
	//修改
	public int updateComment(Comment comment);
	//删除
	public int deleteCommentById(@Param("id")Integer id);
	//查询单个
	public Comment getCommentById(@Param("id")Integer id);
	//查询所有某篇文章ID对应的评论
	public List<Map<String,Object>> queryCommentAll(@Param("blogId")Integer blogId);
	//查询所有的子评论
	public List<Map<String,Object>> queryCommentByParentId(@Param("blogId")Integer blogId,@Param("parentId")Integer parentId);
}