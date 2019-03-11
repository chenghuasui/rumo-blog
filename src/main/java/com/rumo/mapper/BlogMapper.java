package com.rumo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.rumo.pojo.Blog;
import com.rumo.vo.BlogVo;

/**
 * 
 * todo:博客内容表
 * Blog<br/>
 * 创建人:中华墨风<br/>
 * 时间：2018年10月31日 21:57:05 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface BlogMapper {
	//添加
	public int saveBlog(Blog blog);
	//修改
	public int updateBlog(Blog blog);
	//删除
	public int deleteBlogById(@Param("id")Integer id);
	//查询单个
	public Blog getBlogById(@Param("id")Integer id);
	//查询单个分类名称
	public Map<String,Object> getBlogByIdMap(@Param("id")Integer id);
	//查询所有
	public List<Blog> queryBlogAll(BlogVo blogVo);
	//查询博客信息
	public List<Map<String,Object>> queryBlogs();
}