package com.rumo.service.blog;

import com.rumo.pojo.Blog;
import com.rumo.vo.BlogVo;
import com.rumo.vo.ServerResponse;

public interface IBlogService {
	
	/**
	 * 
	 *  保存博客内容表
	 * 方法名：saveBlog<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年9月26日-下午7:11:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param blog
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse saveBlog(Blog blog);
	
	/**
	 * 
	 * (修改博客内容表)<br/>
	 * 方法名：updateBlog<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:1564545646464<br/>
	 * @param blog
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse updateBlog(BlogVo blogVo);
	
	/**
	 * 
	 * (根据id删除博客内容表)<br/>
	 * 方法名：deleteBlogById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse deleteBlogById(Integer id);
	
	/**
	 * 
	 * (根据id获取博客内容表)<br/>
	 * 方法名：getBlogById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse getBlogById(Integer id);
	public ServerResponse getBlogByIdMap(Integer id);
	
	/**
	 * 
	 * (查询所有的博客内容表)<br/>
	 * 方法名：queryBlogAll<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:1564545646464<br/>
	 * @param param
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse queryBlogAll(BlogVo blogVo);
	/**
	 * 
	 * 查看博客信息，
	 * 方法名：queryBlogs<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月7日-下午8:29:25 <br/>
	 * 手机:1564545646464<br/>
	 * @param pageNo
	 * @param pageSize
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse queryBlogs(int pageNo,int pageSize);
}
