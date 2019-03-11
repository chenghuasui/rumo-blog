package com.rumo.service.comment;

import com.rumo.pojo.Comment;
import com.rumo.vo.CommentVo;
import com.rumo.vo.ServerResponse;

public interface ICommentService {
	
	/**
	 * 
	 *  保存文章评论
	 * 方法名：saveComment<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年9月26日-下午7:11:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param comment
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse saveComment(Comment comment);
	
	/**
	 * 
	 * (修改文章评论)<br/>
	 * 方法名：updateComment<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:1564545646464<br/>
	 * @param comment
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse updateComment(CommentVo commentVo);
	
	/**
	 * 
	 * (根据id删除文章评论)<br/>
	 * 方法名：deleteCommentById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse deleteCommentById(Integer id);
	
	/**
	 * 
	 * (根据id获取文章评论)<br/>
	 * 方法名：getCommentById<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse getCommentById(Integer id);
	
	/**
	 * 
	 * (查询所有的文章评论)<br/>
	 * 方法名：queryCommentAll<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:1564545646464<br/>
	 * @param param
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse queryCommentAll(Integer blogId,int pageNo,int pageSize);
}
