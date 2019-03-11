package com.rumo.controller.comment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.pojo.Comment;
import com.rumo.service.comment.ICommentService;
import com.rumo.vo.CommentVo;
import com.rumo.vo.ServerResponse;

/**
 * 
 * todo:文章评论Controller控制器类
 * CommentController<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年11月11日 21:36:28 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/comment")
	public String commentindex() {
		return "comment/index";
	}

	/**
	 * 方法名：commentdetail<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@GetMapping("/comment/{id}")
	public String commentdetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "comment/detail";
	}
	
	
	/**
	 * 模板方法，提供给分页使用
	 * 方法名：template<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:15074816437<br/>
	 * @param params
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@GetMapping("/comment/queryAll/{blogId}/{pageNo}/{pageSize}")
	public ServerResponse queryAll(@PathVariable("blogId")Integer blogId,
			@PathVariable(value="pageNo") Integer pageNo,
			@PathVariable(value="pageSize") Integer pageSize) {
		if(pageNo==null)pageNo =1;
		if(pageSize==null)pageSize =10;
		return commentService.queryCommentAll(blogId, pageNo, pageSize);
	}
	
	
	/**
	 * 根据id查询信息
	 * 方法名：getComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@GetMapping("/comment/get/{id}")
	public ServerResponse getComment(@PathVariable("id") Integer id) {
		return commentService.getCommentById(id);
	}
	
	
	/**
	 * 保存
	 * 方法名：saveComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 21:36:28<br/>
	 * 手机:15074816437<br/>
	 * @param commentVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@GetMapping("/comment/save")
	public ServerResponse saveComment(Comment comment) {
		return commentService.saveComment(comment);
	}
	
	/**
	 * 修改
	 * 方法名：updateComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:15074816437<br/>
	 * @param commentVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/comment/update")
	public ServerResponse updateComment(@Valid CommentVo commentVo) {
		return commentService.updateComment(commentVo);
	}
	
	
	/**
	 * 删除
	 * 方法名：deleteComment<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年11月11日 21:36:28 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/comment/delete/{id}")
	public ServerResponse deleteComment(@PathVariable("id") Integer id) {
		return commentService.deleteCommentById(id);
	}
	
}
