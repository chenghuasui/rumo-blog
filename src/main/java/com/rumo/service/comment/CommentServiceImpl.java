package com.rumo.service.comment;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.config.RequestUtil;
import com.rumo.mapper.CommentMapper;
import com.rumo.pojo.Comment;
import com.rumo.vo.CommentVo;
import com.rumo.vo.ServerResponse;


/**
 * 
 * todo:文章评论Service实现类
 * CommentServiceImpl<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年11月11日 21:36:28 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class CommentServiceImpl implements ICommentService  {

	@Autowired
	private CommentMapper commentMapper;
	
	/**
	 * 这里查询第一级评论信息
	 */
	public ServerResponse queryCommentAll(Integer blogId,int pageNo,int pageSize){
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String,Object>> comments = commentMapper.queryCommentAll(blogId);
		
		//递归查询所有的子评论 comments 第一级的评论信息
		recursionChildren(comments);
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(comments);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	  public  void recursionChildren (List<Map<String, Object>> parentList) {
		 //循环第一级的评论信息，把对应的所有的子评论，全部抓出来，然后继续放入第一级评论的map中追加children节点
		  for (Map<String, Object> parentMap : parentList) {
			Integer  parentId = (Integer) parentMap.get("id");
			Integer  blogId = (Integer) parentMap.get("blogId");
			//检索获取每个元素的所有的子节点
		   List<Map<String, Object>> childrenComments = commentMapper.queryCommentByParentId(blogId, parentId); //2
		   //空元素去接
		   List<Map<String, Object>> childrenList = new ArrayList<>();
		   if(childrenComments!=null && childrenComments.size()>0) {
			   //递归
			   recursionChildren(childrenComments);
			   //追加到容器中comments
			   parentMap.put("children",childrenComments);
		   }else {
			   parentMap.put("children",childrenList);
		   }
		 }
	}
	
	
	
	@Override
	public ServerResponse saveComment(Comment comment) {
		comment.setUserId(1);
		comment.setIp("127.0.0.1");
		comment.setStatus(1);
		int count = commentMapper.saveComment(comment);
		return count>0?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateComment(CommentVo commentVo) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentVo, comment);
		int count = commentMapper.updateComment(comment);
		return count>0?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteCommentById(Integer id) {
		int count = commentMapper.deleteCommentById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse getCommentById(Integer id) {
		Comment comment = commentMapper.getCommentById(id);
		return comment!=null?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}
	
	
}
