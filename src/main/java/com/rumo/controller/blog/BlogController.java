package com.rumo.controller.blog;

import java.net.URL;
import java.util.Set;

import javax.validation.Valid;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.pojo.Blog;
import com.rumo.service.blog.IBlogService;
import com.rumo.util.GatherInfo;
import com.rumo.vo.BlogVo;
import com.rumo.vo.ServerResponse;

/**
 * 
 * todo:博客内容表Controller控制器类
 * BlogController<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年10月31日 21:57:05 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	@ResponseBody
	@RequestMapping("/gather")
	public String saveBlogsGather() {
		Set<String> links = GatherInfo.getLinks("https://aotu.io/index.html");
		for (String string : links) {
			try {
				Document document = Jsoup.parse(new URL("https://aotu.io"+string), 3000);
				String img = document.getElementsByClass("post-cover").first().child(0).attr("src");
				String title = document.getElementsByClass("post-tit").eq(0).text();
				String content = document.getElementsByClass("post-content").eq(0).html();
				Blog blog = new Blog();
				blog.setCategoryId(1);
				blog.setContent(content);
				blog.setTitle(title);
				blog.setImg(img);
				blog.setDescription(title);
				blog.setIsHot(0);
				blog.setIsTop(0);
				blog.setStatus(1);
				blog.setIsDelete(0);
				blog.setTags("");
				blog.setUserId(1);
				blogService.saveBlog(blog);
			} catch (Exception e) {
				continue;
			}
		}
		return "success";
	}
	
	@ResponseBody
	@GetMapping("/blog/query")
	public ServerResponse blogquery(
			@RequestParam(value="pageNo",defaultValue="1",required=false)Integer pageNo,
			@RequestParam(value="pageSize",defaultValue="10",required=false)Integer pageSize
			) {
		return blogService.queryBlogs(pageNo, pageSize);
	}

	/**
	 * 方法名：blogdetail<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@GetMapping("/blog/{id}")
	public String blogdetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "blog/detail";
	}
	
	
	/**
	 * 模板方法，提供给分页使用
	 * 方法名：template<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:15074816437<br/>
	 * @param params
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@PostMapping("/blog/template")
	public String template(BlogVo blogVo,ModelMap map) {
		ServerResponse serverResponse = blogService.queryBlogAll(blogVo);
		map.addAttribute("pages", serverResponse.getData());
		return "blog/template";
	}
	
	
	/**
	 * 根据id查询信息
	 * 方法名：getBlog<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@GetMapping("/blog/get/{id}")
	public ServerResponse getBlog(@PathVariable("id") Integer id) {
		return blogService.getBlogById(id);
	}
	
	
	/**
	 * 保存
	 * 方法名：saveBlog<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月31日 21:57:05<br/>
	 * 手机:15074816437<br/>
	 * @param blogVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/blog/save")
	public ServerResponse saveBlog(@Valid BlogVo blogVo) {
		return blogService.saveBlog(blogVo);
	}
	
	/**
	 * 修改
	 * 方法名：updateBlog<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:15074816437<br/>
	 * @param blogVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/blog/update")
	public ServerResponse updateBlog(@Valid BlogVo blogVo) {
		return blogService.updateBlog(blogVo);
	}
	
	
	/**
	 * 删除
	 * 方法名：deleteBlog<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年10月31日 21:57:05 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/blog/delete/{id}")
	public ServerResponse deleteBlog(@PathVariable("id") Integer id) {
		return blogService.deleteBlogById(id);
	}
	
}
