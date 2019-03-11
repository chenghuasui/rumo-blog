package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.service.blog.IBlogService;
import com.rumo.vo.ServerResponse;

import io.swagger.annotations.Api;

@Controller
@Api(description="首页管理")
public class IndexController {
	
	
	@Autowired
	private IBlogService blogService;
	
	//spring4.x之后提供两个 @GetMapping @PostMapping @RestController
	
	/*@GetMapping("/index")
	public String blogquery(
			@RequestParam(value="pageNo",defaultValue="1",required=false)Integer pageNo,
			@RequestParam(value="pageSize",defaultValue="10",required=false)Integer pageSize
			,ModelMap modelMap) {
		ServerResponse serverResponse = blogService.queryBlogs(pageNo, pageSize);
		modelMap.addAttribute("serverResponse", serverResponse);
		return "index";
	}*/
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id")Integer id,ModelMap model) {
		ServerResponse serverResponse = blogService.getBlogByIdMap(id);
		model.addAttribute("blog", serverResponse.getData());
		return "detail";
	}
	
}
