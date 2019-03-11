package com.rumo.service.blog;


import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.BlogMapper;
import com.rumo.pojo.Blog;
import com.rumo.vo.BlogVo;
import com.rumo.vo.ServerResponse;


/**
 * 
 * todo:博客内容表Service实现类
 * BlogServiceImpl<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年10月31日 21:57:05 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class BlogServiceImpl implements IBlogService  {

	@Autowired
	private BlogMapper blogMapper;
	
	public ServerResponse queryBlogAll(BlogVo blogVo){
		PageHelper.startPage(blogVo.getPageNo(), blogVo.getPageSize());
		List<Blog> blogs = blogMapper.queryBlogAll(blogVo);
		PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	@Override
	public ServerResponse saveBlog(Blog blog) {
		int count = blogMapper.saveBlog(blog);
		return count>0?ServerResponse.createBySuccess(blog):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateBlog(BlogVo blogVo) {
		Blog blog = new Blog();
		BeanUtils.copyProperties(blogVo, blog);
		int count = blogMapper.updateBlog(blog);
		return count>0?ServerResponse.createBySuccess(blog):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteBlogById(Integer id) {
		int count = blogMapper.deleteBlogById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse getBlogById(Integer id) {
		Blog blog = blogMapper.getBlogById(id);
		return blog!=null?ServerResponse.createBySuccess(blog):ServerResponse.createByError();
	}
	
	@Override
	public ServerResponse getBlogByIdMap(Integer id) {
		Map<String,Object> blogs = blogMapper.getBlogByIdMap(id);
		return blogs!=null?ServerResponse.createBySuccess(blogs):ServerResponse.createByError();
	}

	@Override
	public ServerResponse queryBlogs(int pageNo, int pageSize) {
		//设置分页
		PageHelper.startPage(pageNo, pageSize);
		//查询数据
		List<Map<String,Object>> blogs = blogMapper.queryBlogs();
		//把分页信息和查询的结果一起组装成一个pageInfo返回给我页面
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(blogs);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	
}
